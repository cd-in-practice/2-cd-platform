#!groovy
import hudson.security.*
import jenkins.model.*

def instance = Jenkins.getInstance()
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def users = hudsonRealm.getAllUsers()
users_s = users.collect { it.toString() }
def env = System.getenv()
def adminUsername = env['ADMIN_USERNAME']
def adminPass = env['ADMIN_PASS']

// Create the admin user account if it doesn't already exist.
if (adminUsername in users_s) {
    println "Admin user already exists - updating password"

    def user = hudson.model.User.get(adminUsername);
    def password = hudson.security.HudsonPrivateSecurityRealm.Details.fromPlainPassword(adminPass)
    user.addProperty(password)
    user.save()
}
else {
    println "--> creating local admin user"

    hudsonRealm.createAccount(adminUsername, adminPass)
    instance.setSecurityRealm(hudsonRealm)

    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    instance.setAuthorizationStrategy(strategy)
    instance.save()
    
}
