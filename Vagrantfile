# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|

  machine_box = "CentOS-7.1.1503-x86_64-netboot"
  config.ssh.forward_agent = true

  config.vm.define "2-nginx" do |machine|
    machine.vm.box = machine_box
    machine.vm.network "private_network", ip: "192.168.52.10"
    machine.vm.network "forwarded_port", guest: 80, host: 5123
    machine.vm.provision "shell" do |s|
      s.inline = "echo '192.168.52.1 artifactory' >> /etc/hosts"
    end
    machine.vm.provider "virtualbox" do |node|
        node.name = "2-nginx"
        node.memory = 512
        node.cpus = 2
    end
   end

  config.vm.define "2-springboot" do |machine|
    machine.vm.box = machine_box
    machine.vm.network "private_network", ip: "192.168.52.11"
    machine.vm.network "forwarded_port", guest: 7896, host: 7896
    machine.vm.provision "shell" do |s|
      s.inline = "echo '192.168.52.1 artifactory' >> /etc/hosts"
    end
    machine.vm.provider "virtualbox" do |node|
        node.name = "2-springboot"
        node.memory = 1024
        node.cpus = 2

    end
   end

end
