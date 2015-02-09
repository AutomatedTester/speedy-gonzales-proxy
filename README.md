# Speedy Gonzales Proxy

This is a project to help make Mozilla Web QA Selenium Tests more reliable by sending messages to a on the node to move the mouse. 

This plugin is run on the Selenium Grid Hub machine with:

``` bash
    java -cp "speedy-gonzales-<version>.jar:selenium-server-standalone.jar" org.openqa.grid.selenium.GridLauncher -role hub
```

We then need to tell the Selenium Grid node to use Speedy Gonzales and we do this with
``` bash
    java -cp "speedy-gonzales-<version>.jar:selenium-server-standalone.jar" -role node -hubHost
    localhost -proxy com.mozilla.seleniumgrid.SpeedyGonzalesProxy -servlets com.mozilla.seleniumgrid.MoveMouse
```

If we don't do the node item above it will NOT be used and will carry on as normal.
