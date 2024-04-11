# bnz.assignment

## Instructions
1. The project used maven as the dependency management tool

## Executing tests

1. Open the project using IntelliJ or VS Code
2. Download the dependencies using command "mvn clean install"
3. Run the tests using command "mvn test" or using TestRunner option on projectx.runner.TestRunner class

## Failing tests

NOTE: There are two tests failing and those failures are due to application bugs
1. When the Last Name field is left empty, the error message goes as "First Name is required"
2. Some car models Author details are not displayed in the comments list

## View cucumber-reports.html
1. After the test run is finished, generated cucumber-reports.html can be found under the target folder.

