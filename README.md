# MyStoreAutomationTesting
# To execute the TCs run the following command
 mvn clean test -Dtestng="testngFileName"
# In order to execute the TCs related to any specific group then execute the below command
 mvn clean test -Dtestng="testngFileName" -Dgroups=sanity
 
 <!--Update the line 48 and 49 in pom.xml file with your current java version, check by running mvn -version command-->
