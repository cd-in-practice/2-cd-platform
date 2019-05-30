## CD platform
```
docker build -f JenkinsDockerSlaveDockerfile -t jenkins-docker-swarm-agent:latest
docker build -f JenkinsMavenDockerfile -t jenkins-docker-maven:3.6.1-jdk8 .
docker-compose up -d
vagrant up
```
如果修改了自定义的 Dockerfile（JenkinsDockerSlaveDockerfile、JenkinsMasterDockerfile，JenkinsMavenDockerfile），则使用 `docker-compose build` 重新构建镜像。

jenkins: http://localhost:8080/

artifactory: http://localhost:8081

### Artifactory 配置
remote repository:
* spring-milestone: http://repo.spring.io/milestone
* apache-maven2: http://repo.maven.apache.org/maven2
* jcenter: https://jcenter.bintray.com
* jboss: https://repository.jboss.org/nexus/content/repositories/releases/
* sonatype: https://oss.sonatype.org/content/repositories/releases/