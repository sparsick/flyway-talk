flyway-talk-swkdo
=================

This repository contains slides, source code examples and Jenkins job configuration for the talk "Continuous Database Integration with Flyway and Jenkins" @ Softwerkskammer Dortmund (2013-09-25).

Following tools were used in the demonstration:
- Nexus in version 2.6.0 as Maven repository manager
- Jenkins in version 1.530 as CI server
- Installed Jenkins Plugins: Repository Connector Plugin and Build Pipeline Plugin
- Flyway in version 2.2.1
- Maven in version 3.0.4
- MySQL in version 5.5

flyway-commandline-2.2.1
----------------------------

The subfolder _flyway-commandline-2.2.1_ contains a pre-configured Flyway commandline tool. If you want to use it against your own MySQL database, you have to change the url, user and password configuration in 'flyway-commandline-2.2.1/conf/flyway.properties'.


flyway-demo
--------------------

The subfolder _flyway-demo_ contains a Maven project, that demonstrates how to use the Flyway Java API ( _flyway-api-demo_ ) and Flyway Maven Plugin ( _database-scripts_ ).
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
