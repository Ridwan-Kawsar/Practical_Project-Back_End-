Coverage: 96.6%
# Software Core Practical Project (Pokemon)

For the practical project, the developer was given the choice on what theme to build their application around. For my project, I have chosen to build it around a Pokemon database which allows the user to create, read, update and delete entries of pokemons from the front-end (webpage) that is connected to a local database in MySQL. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Required softwares:
-Bash Terminal / Terminal (Command-Line Interface / Connection to Github) - https://git-scm.com/downloads

-Jira (Atlassian Website for project planning) - [https://www.atlassian.com/](https://www.atlassian.com/try/cloud/signup?bundle=jira-software&edition=free)

-MySQL WorkBench (Database) - https://dev.mysql.com/downloads/windows/installer/8.0.html

-Java (Coding Language) - https://www.oracle.com/uk/java/technologies/javase-downloads.html

-Eclipse (Code Editor) - http://www.eclipse.org/downloads

-Visual Studio Code (Code Editor for HTML and Programming Language; Java and JS) - https://code.visualstudio.com/

-Maven (Build Tool / Manages dependencies) - https://maven.apache.org/download.cgi

-SpringBoot (Backend Application) - https://spring.io/tools

-Postman (Testing HTTP Requests) - https://www.postman.com/downloads/

-H2 Console  (Remote Database) - http://localhost:8080/h2-console/

-HTML/Live Server (Webpage Development) - Live Server is found in the extensions section of Visual Studio Code.

-CSS/Bootstrap (Front-end Styling) - https://getbootstrap.com/

-JavaScript (Coding Functionality for Front-End)

### Installation

SpringBoot Installation

Navigate to the Spring Tools page, then click the relevant download for your system:

![image](https://user-images.githubusercontent.com/104441372/181388489-982edd59-22f5-4cd9-af02-41fda765326e.png)

This will download a tar.gz (Linux), .dmg (macOS), or self-extracting .jar (Windows).

Extract/Open this file; this should generate a folder containing the installation.

Inside this folder (e.g. sts-4.8.1-RELEASE), run the SpringToolSuite4 application:

![image](https://user-images.githubusercontent.com/104441372/181388512-e0fe3e05-3669-47a4-9822-d07819de7e2e.png)

This should open the Spring Tool Suite IDE.

Eclipse
Spring Tools can be installed as an Eclipse extension by navigating to this marketplace link and dragging the Install button inside of a running Eclipse:

![image](https://user-images.githubusercontent.com/104441372/181388534-f4ba4f61-db52-4751-ac96-34c2f59228e5.png)

This will import and automatically install Spring according to your Eclipse configuration.

Once your workspace has loaded, go to File > New > Project..., then choose Spring Starter Project from the list:

![image](https://user-images.githubusercontent.com/104441372/181388463-b1983613-1920-4192-938e-ab200c898410.png)

![image](https://user-images.githubusercontent.com/104441372/181388429-90019519-24c4-4bfc-af9b-382a2f50a0fe.png)

On the following screen, fill out the details of your project as follows:

Name can be anything you wish (in PascalCase), e.g. StarterProject.
Ensure that you're saving your project to your spring workspace.
Type refers to the build tool, which should be Maven.
Packaging refers to the archive created by the build tool, which should be Jar.
Ensure that the Java version is at least 8 (preferably 11 or higher, as Java 8 is starting to become obsolete).
Of course, keep the Language as Java.
The Group should match your organisation, e.g. com.qa.
The Artifact should match the Name.
Keep the Version as-is for now.
The Package should be your Group field plus your project Name (all in lowercase), e.g. com.qa.starterproject.

Ignore everything else, then click Next.

![image](https://user-images.githubusercontent.com/104441372/181388592-b86ddc1f-3f48-4da6-9f05-efea6bbe06e4.png)

The following screen allows you to select any Spring framework projects you wish to use.

From the list, select Spring Data JPA, Spring Web, and H2 Database, then click Finish.

![image](https://user-images.githubusercontent.com/104441372/181388619-7c27e5d2-827f-41d6-a0e5-6f8b56b76cf3.png)

Spring will take time to set the project up - you can see its progress in the bottom-right of your screen.

Once done, you should be able to expand out your project in the Project Explorer:

![image](https://user-images.githubusercontent.com/104441372/181388654-528fda1d-5c2e-41fd-8e65-81763d9889a9.png)

## Running the tests

*How to run automated tests in Java*
1. Right click over the desired project/folder/package
2. Scroll down to 'Coverage As'
3. Select '2 JUnit Test'

JUnit Tests - focuses on Unit tests, but can also be used for a variety of other use cases.
Mockito Tests - Mockito is an open source testing framework. It allows the creation of test objects (mock objects) in automated unit tests. Mockito allows us to verify the behaviour of the system under test without establishing connections first. Therefore we can test our code that, for example, connects to a database and runs queries without actually having to connect to the database. Mocked objects return dummy data to avoid external dependencies and allow us to make sure the flow of our code is correct and the logic is doing what we expect as opposed to working, but working incorrectly.

### Unit Tests 

A unit is the smallest whole increment, from which this testing gets its name. It is by far one of the most important tests and it tests a small amount of code, usually a single method, to see if it returns the expected output. A unit test is meant to be a single item under test, so break up the complexity of methods calling methods, we might use stubs and drivers. In Object-Oriented languages such as Java and C#, a unit test might be best represented by a class object, we can try to isolate the units (methods and attributes) and ensure that they function correctly when called in isolation. This testing is usually done by programmers themselves as it requires an understanding of what the code is doing.

The following resources/utilities may help us support our efforts to perform Unit testing:

*Stubs*
Stubs are replacements for called methods, rather than calling the real method we hard code what the response from that message will be - as long as the other method is doing its job correctly, the method under test should therefore pass. To appreciate how we might use a stub, consider a class that defines a has-a relationship (The class defines an attribute that itself is a class).
Sometimes we might stub the behaviour of this unique attribute because it is not the target "unit" of the test and falls outside our scope.

*Drivers*
Drivers are replacements for inputs, they "drive" information into the method under test. Drivers can be beneficial when testing methods that take in information from an external system. A driver may facilitate the test, but it will not be the target of testing. Perhaps a driver may return a certain resource unique to its related technology.

### Integration Tests 

Integration Testing is usually the next step after unit testing, once the functionality of the individual components is confirmed. Next, we verify that the functionality of the combined methods and modules. The approach to do this varies, but there are three common ways:

*Top-down integration*
Top-down integration is where you start with high-level components or modules and you test that they successfully interact with a low-level module. If the low-level module calls an even further low-level module - that input will be stubbed.

*Bottom-up integration*
Bottom-up integration is where you start at a low-level component or module and you test that the driving inputs from a high-level module are correct.

*Big Bang integration*
Big bang integration doesn't follow many guidelines. In essence, you combine everything and hope that it works. It is quick, however, if the test fails it does not give much information as to why.

## Deployment

*Executing the IMS via CLI*
1. Clone the project via the following link in a terminal/bash terminal; git@github.com:Ridwan-Kawsar/IMS-22EnableMay2.git 
2. Open a terminal and change directory till you're aligned with the IMS folder.
3. Then type 'java -jar ims-0.0.1-jar-with-dependencies.jar' in the terminal to execute the IMS

*Executing the IMS via a local instance*
1. Clone the project via the following link in a terminal/bash terminal; git@github.com:Ridwan-Kawsar/IMS-22EnableMay2.git 
2. Launch a code editor and open the project from there. 
3. The path for this is IMS-22EnableMay2 > src/main/java > com.qa.ims > Runner.java
4. Open MySQL and enter a Local Instance; Local Host: 3306, DB User and Password found in IMS-22EnableMay2 > src/main/resources > db.properties
5. Go back to the Runner file, run as java application.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/tools) - Backend Application

## Versioning

We use [Github](https://github.com/) for versioning.

## Authors

* **Ridwan Kawsar** - *Completion of MVP* - [ridwankawsar](https://github.com/Ridwan-Kawsar)

## License

MIT License

Copyright (c) [2022] [Ridwan Kawsar]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Acknowledgments

* QA Community
* W3Schools
* Stackoverflow
* Bootstrap
* **Jordan Harrison** - *Taught me front-end content; HTML, CSS, JavaScript and SpringBoot for Backend* - [jordanharrison](https://github.com/JHarry444)
* **Jordan Benbelaid** - *Taught me backend content; Java Beginner & Intermediate, JUnit and Mockito Testing, Maven and MySQL* - [jordanbenbelaid](https://github.com/jordanbenbelaid)

## Jira Board
