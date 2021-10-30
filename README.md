# redhivegames
### Hi there! :rocket:

### This project contains automated tests of Web Site: https://redhivegames.com/en
#### :space_invader: Tutorial articles for 3D MOBA game Overprime, bunch of builds for every hero with description.

#### List of automated tests:

#### UI
-	Positive/negative login tests
-	Parameterized tests  of registration form
-	Tests of opening pages in main menu by authorized/not authorized user and checking expected content. Pages, that are opened from main menu:
    - **Decks**
    - **Articles**
    - **Create article** (not authorized user is redirected to login page)
    - **Create deck** (not authorized user is redirected to login page)
    - **Card price calculator** (for not authorized user message with login link is displayed))

#### API
Usage of models/rest assured library for testing of tweets on RedHiveGames Twitter account. Tests contain check of:
-	RedHiveGames account name
-	tweet's data (for some specified twitter id)
-	getting id of oldest tweet and checking its content
-	number of tweets in RedHiveGames Twitter account
-	number of tweets, where RedHiveGames account put “like” mark


The following **technologies** are used:

* :white_check_mark: **Java**  - OOP language, that was used for the automation tests development
* :white_check_mark: **Intellij Idea**  - integrated development environment (IDE) for developing computer software 
* :white_check_mark: **Selenide** - framework for test automation powered by Selenium WebDriver
* :white_check_mark: **Selenoid** - cross browser Selenium solution
* :white_check_mark: **Gradle** - build automation tool for managing dependencies modules, setting tasks configuration, etc.
* :white_check_mark: **JUnit5** - serves as a foundation for launching testing frameworks on the JVM
* :white_check_mark: **Jenkins** - automation server, used to execution of tests from GutHub repository on Selenoid
* :white_check_mark: **Allure Reports** - reporting tool for analysis of test execution results
* :white_check_mark: **Allure TestOps** - test management system for keeping test cases and graphs/metrics investigation
* :white_check_mark: **GitHub** - code hosting platform for version control and collaboration
* :white_check_mark: **Telegram** - messenger, in which notifications about test execution results are sent!  


Java | Intellij Idea | Selenide | Selenoid | Gradle |
:---------: | :---------: | :---------: | :---------: | :---------: 
![image](https://user-images.githubusercontent.com/86851419/129460968-afa39d7b-2b6c-4cfe-a4d7-a832b2241964.png) | ![image](https://user-images.githubusercontent.com/86851419/129460290-f0bb0b77-ced9-41d0-96e3-3b51e6e9c1c4.png) | ![image](https://user-images.githubusercontent.com/86851419/129460419-c463163c-0c76-46d6-9416-0ee4ec26b879.png) |![image](https://user-images.githubusercontent.com/86851419/129460507-e47ea71f-e8e0-4dfa-a5be-fa88bbd79522.png) | ![image](https://user-images.githubusercontent.com/86851419/129461122-84b505ee-c082-44da-a100-226d47f6a665.png)
**JUnit5** | **Jenkins** | **Allure** |**GitHub** | **Telegram**
![image](https://user-images.githubusercontent.com/86851419/129460565-68f2b13e-0f71-4510-9266-21c1bf95d55b.png)| ![image](https://user-images.githubusercontent.com/86851419/129460671-00864a0c-a1e9-415b-9df3-25062b4ee5ca.png) | ![image](https://user-images.githubusercontent.com/86851419/129460019-82755ea3-50b7-4d91-a5d0-f98430544079.png) |![image](https://user-images.githubusercontent.com/86851419/129461200-cc199a3e-8a0b-4879-883b-ca0c7b8e7d9c.png) |![image](https://user-images.githubusercontent.com/86851419/129460847-d77a8a9d-0022-440f-b0f4-96dde9d22e58.png)

### USAGE examples

### For run remote tests need pass value:
* URL(default: selenoid.autotests.cloud/wd/hub/)
* ALLURE_NOTIFICATIONS_VERSION (default: 3.1.1)
* ENVIRONMENT (default: TEST)
* RUN_MODE (default: remote)
* BROWSER (default: chrome)
* BROWSER_VERSION (default: 91.0)
* BROWSER_SIZE (default: 1920x1080)
* BROWSER_MOBILE (mobile device name, for example iPhone X, default: not chosen)
* THREADS (number of threads, default: 5)


### Run tests using local browser:
```bash
gradle clean test
```

### Run tests using Selenoid:
```bash
gradle clean test -Durl=selenoid.autotests.cloud/wd/hub/ -DrunMode=remote
```

### Serve Allure report:
```bash
allure serve build/allure-results
```
### Results of tests execution in Allure Reports: 
![image](https://user-images.githubusercontent.com/86851419/139345770-2ee7d7ce-bf70-4ecb-94d1-7bd204f8a2a2.png)

### Launches in Allure TestOps:
![image](https://user-images.githubusercontent.com/86851419/139475971-bfe88afc-4077-4d3d-a470-00803fb06a01.png)

### Test cases and meta information in Allure TestOps:
![image](https://user-images.githubusercontent.com/86851419/139531412-a0e12f9b-87b9-4451-aa5d-e95440c6d6bb.png)

### Results of Tests execution in Telegram:
![image](https://user-images.githubusercontent.com/86851419/139345085-88f8dd73-ba9d-4438-b2b1-a8d8be39ca2b.png)

### Recorded test run:
![alt text](https://github.com/rocketby/redhives/blob/master/src/test/resources/video/testrun.gif "Tests execution recorded")


