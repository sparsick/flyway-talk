flyway-talk-jax-18
=================

This repository contains slides, source code examples and Jenkins job configuration for the talk "Continuous Database Integration mit Flyway" @ Herbstcampus in Nuremberg (2018-09-05).

Following tools were used in the demonstration:
- Sonatype Nexus as Maven repository manager
- Jenkins  as CI server
- Used Jenkins Plugins:
  - Repository Connector Plugin
  - File System SCM Plugin
- Flyway 5.0.7
- Maven as Build Tool
- MySQL

For the case,  you don't want to use your own database, I prepare a VM with MySQL (_Vagrantfile_). The VM is started by the command _vagrant up_. It requires an installed VirtualBox and Vagrant.

flyway-5.0.7
----------------------------

The subfolder _flyway-5.0.7_ contains a pre-configured Flyway commandline tool. If you want to use it against your own MySQL database, you have to change the url, user and password configuration in 'flyway-5.0.7/conf/flyway.properties'.

flyway-demo
--------------------

The subfolder _flyway-demo_ contains a Maven project, that demonstrates how to use the Flyway Java API (see _FlwayServletListener_) in a web application ( _demo-web-application_) and Flyway Maven Plugin ( _database-scripts_ ).
Notice, that you have to adjust the Flyway Maven plugin configuration in the _pom.xml_ to use it against your own MySQL database.

Furthermore, there is a demo web application ( _demo-web-application_ ) I used to demonstrate a build pipeline in Jenkins.
Here, again, you have to adjust the database source configuration ( _demo-web-applikation/src/main/resources/META-INF/spring/demo-context.xml_ ).
This demo web application based on the wicket-quickstart archetype.

jenkins-job-config
-------------------

This subfolder contains the Jenkins job configuration. Copy the folder structure in your Jenkins instance and add the
source code or the commandline tool in the job workspace, respectively.

slides
---------

This subfolder contains the slides of the presentation.
