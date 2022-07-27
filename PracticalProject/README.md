Coverage: 68%
# Inventory Management System (IMS)

The Inventory Management System allows the user to create, read, update and delete records of customers, items and orders on a database that is connected to a local instance, MySQL. It also allows for the addition & deletion of items for an order. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Required softwares:
-Bash Terminal / Terminal (Command-Line Interface / Connection to Github) - https://git-scm.com/downloads
-Jira (Atlassian Website for project planning) - [https://www.atlassian.com/](https://www.atlassian.com/try/cloud/signup?bundle=jira-software&edition=free)
-MySQL WorkBench (Database) - https://dev.mysql.com/downloads/windows/installer/8.0.html
-Java (Coding Language) - https://www.oracle.com/uk/java/technologies/javase-downloads.html
-Eclipse (Code Editor) - http://www.eclipse.org/downloads
-Maven (Converts projects into jar files so that in can be run through a CLI / Manages dependencies) - https://maven.apache.org/download.cgi

### Installing

*Installing Java*
1. To do this; open “File Explorer” then navigate into "This PC", then "Local Disk (C:)", then "LocalInstall", then "DevOps", then "Java".

![image](https://user-images.githubusercontent.com/104441372/173260344-1f6ca768-2a7b-4bf9-8e48-993691a59819.png)

2. Double click the executable "jdk-14.0.1_window-x64_bin.exe"/"jdk-8u221-windows-x64.exe". The following window will appear. Click "next".

![image](https://user-images.githubusercontent.com/104441372/173260396-a756373f-0cc7-4219-a2ef-e9ac9f3b67d2.png)

3. Then click "next" again.

![image](https://user-images.githubusercontent.com/104441372/173260406-16672361-99e9-47a0-b75f-32a8d09f67b4.png)

4. Click "next" once more.

![image](https://user-images.githubusercontent.com/104441372/173260427-f7dbc523-e0db-4801-8e18-e7bc3b9b6ce8.png)

5. Then click close.

![image](https://user-images.githubusercontent.com/104441372/173260449-90191c7b-a6a7-4791-a0fb-de4e1e4ed4a8.png)

The JDK will now be installed in C:/Program Files/Java

*Setting Environment Variables for Java Development Kit*

1. Press the Windows button and type "path" into the search field, then select "Edit the system environment variables"

![image](https://user-images.githubusercontent.com/104441372/173260506-98789a2c-69b7-4470-889a-d18f1810e602.png)

2. Click "Environment Variables...".

![image](https://user-images.githubusercontent.com/104441372/173260519-f1e9fd9c-98bd-413f-9c2c-bf257770072a.png)

3. From this screen you can edit both the "User" and the "System" variables, you should change the "System" variables (bottom half of the window) as we want our changes to affect ALL users. Click "New..." to add a new system variable.

![image](https://user-images.githubusercontent.com/104441372/173260554-b6c3bfa2-cd1b-4542-b728-1e315a46481b.png)

4. In the new popup window, we will create our new JAVA_HOME variable and give it a value corresponding to our JDK folder.

![image](https://user-images.githubusercontent.com/104441372/173260593-1b993bbb-142e-466b-9d00-30899d5934c5.png)

5. Click "OK" and we should now see our new JAVA_HOME system variable in the "System variables" box like so.

![image](https://user-images.githubusercontent.com/104441372/173260613-2b67a347-68ec-4436-a328-8bfbac457435.png)

6. Now we need to edit the "Path" variable to include a reference to the /bin (binary files) folder in our JAVA_HOME.
To do this select the "Path" variable under "System variables" and then click "Edit...".

![image](https://user-images.githubusercontent.com/104441372/173260632-834c0df4-dc19-4db2-894e-723e924e403a.png)

7. You need to append the path of the Java /bin folder to this "Path" variable, so to do this, we will reference the JAVA_HOME variable we created like so: %JAVA_HOME%\bin

8.When you have done this your "Path" variable should look like the image below (make sure that there is a semi-colon before and after %JAVA_HOME%\bin).

![image](https://user-images.githubusercontent.com/104441372/173260661-22eb65a6-f4e3-4acd-bc4b-6c8424ae7dcf.png)

9. To test that this has saved, open “command prompt”, type "java" and hit enter. If the "Path" variable has been configured correctly then the OS will run the file called "Java" in your JAVA_HOME /bin folder (Java.exe) and you should see this output:

![image](https://user-images.githubusercontent.com/104441372/173260680-3b8e1ebb-5e43-4497-b8da-246a01a9bb7d.png)

10. You can also check which Java version you're using if you open “command prompt” and run "java -version".

![image](https://user-images.githubusercontent.com/104441372/173260694-3a3ace3a-4c55-4cf7-a904-62c037240f73.png)

## Running the tests

*How to run automated tests in Java*
1. Right click over the desired project/folder/package
2. Scroll down to 'Coverage As'
3. Select '2 JUnit Test'

JUnit Tests - 
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

## Versioning

We use [Github](https://github.com/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Jordan Benbelaid** - *Made Adjustments to initial work* - [jordanbenbelaid](https://github.com/jordanbenbelaid)
* **Ridwan Kawsar** - *Final work - Completion of MVP* - [ridwankawsar](https://github.com/Ridwan-Kawsar)

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
* Jordan Benbelaid
* Cameron Guthrie

## Jira Board
https://ridwan-kawsar.atlassian.net/jira/software/projects/QAW5P/boards/2/roadmap
