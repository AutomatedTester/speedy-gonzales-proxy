package com.mozilla.seleniumgrid;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.internal.listeners.TestSessionListener;
import org.openqa.grid.selenium.proxy.DefaultRemoteProxy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeedyGonzalesProxy extends DefaultRemoteProxy implements TestSessionListener {

    private Pattern urlPattern = Pattern.compile("http://(\\w+)");

    public SpeedyGonzalesProxy(RegistrationRequest request, Registry registry) {
        super(request, registry);
        System.out.println("Starting Speedy Gonzales Proxy");
    }

    @Override
    public void beforeSession(TestSession session) {
        super.beforeSession(session);
        synchronized (this){
            try {
                String nodeAddress = session.getSlot().getPath();
                Matcher matcher = urlPattern.matcher(nodeAddress);
                String cleanAddress = "";
                while (matcher.find()){
                    cleanAddress = matcher.group();
                }
                URL url = new URL("http://" + cleanAddress + ":3000/moveMouse");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.getInputStream();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
