package com.mozilla.seleniumgrid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.internal.listeners.TestSessionListener;
import org.openqa.grid.selenium.proxy.DefaultRemoteProxy;

public class SpeedyGonzalesProxy extends DefaultRemoteProxy implements TestSessionListener {

    public SpeedyGonzalesProxy(final RegistrationRequest request, final Registry registry) {
        super(request, registry);
    }

    @Override
    public void beforeSession(final TestSession session) {

        super.beforeSession(session);
        synchronized (this) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL(remoteHost + "/extra/MoveMouse");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.getResponseCode();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
