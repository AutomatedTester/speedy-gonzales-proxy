# Speedy Gonzales Proxy

This is a project to help make Mozilla Web QA Selenium Tests more reliable by sending messages to a
[servlet](https://github.com/AutomatedTester/speedy-gonzales-servlet) on the node. This plugin is run on the Selenium
Grid Hub machine with

This proxy adds a custom call to the servlet running on the node machine before the test starts.


Step 1 Compile the class
``` bash
	javac -cp PATH-TO-selenium-server.jar -d bin src/com/mozilla/seleniumgrid/SpeedyGonzalesProxy.java
```

Step 2 Add the compiled proxy class to class path of the HUB

``` bash
    java -cp PATH-TO-selenium-server.jar:PATH-TO-speedy-gonzales-proxy/bin org.openqa.grid.selenium.GridLauncher -role hub

```

Step 3 Add the compile proxy class to the class path of the nod

We then need to tell the Selenium Grid node to use Speedy Gonzales and we do this with
``` bash
     java -cp PATH-TO-selenium-server.jar:PATH-TO-speedy-gonzales-proxy/bin org.openqa.grid.selenium.GridLauncher -proxy com.mozilla.seleniumgrid.SpeedyGonzalesProxy -role wb -hub URL-OF-HUB
    localhost
```

If we do not use the -proxy option then the node will ignore the new proxy and cary on as normal
