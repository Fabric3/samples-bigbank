Fabric3 BigBank Sample Application
====================================

Introduction
----------------
 Ths sample provides an overview of how to build service-based systems with Fabric3. BigBank is a fictitious financial institution tasked with modernizing its
 IT infrastructure to support its mobile banking and API initiatives. BigBank has elected to build an API platform that interfaces with its legacy systems
 through a combination of JMS and Web Services (WS-*). Rather than simply wrapping these services and exposing them as RESTful resources, the API platform
 provides additional capabilities and features such as fraud monitoring. The API platform uses event-driven design (pub/sub channels) and modern messaging
 technologies such as ZeroMQ to achieve these goals.

Topics Demonstrated
--------------------
* Building a RESTful API using JAX-RS with Fabric3
* Pub/Sub messaging and event-driven design using ZeroMQ with Fabric3
* Asynchronous programming and callbacks with Fabric3
* Legacy system integration using JAX-WS (WS-*) and JMS with Fabric3
* Service modularity, packaging and deployment with Fabric3


Prerequisites
----------------

* JDK 7.0 or later

* Maven 3.1.1 or later to build the samples. Maven can be downloaded from http://maven.apache.org/download.html.


Installation
----------------

* To build the samples, execute the following command from the top level directory:


	mvn clean install

  _Be sure to ensure ports 8181, 61616, 8383 are available as they are required for remote transports enabled by the application._


Documentation
----------------

* The samples documentation can be found at https://fabric3.atlassian.net/wiki/display/FABRIC/Getting+Started.

Reporting Issues
----------------

* If you experience a problem or would like to suggest improvements, send a note to the user list (http://xircles.codehaus.org/projects/fabric3/lists)
  or file a JIRA issue.



