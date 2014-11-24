package com.mozilla.seleniumgrid;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveMouse extends HttpServlet {

    private static final long serialVersionUID = -4703434773383837063L;

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        Robot moveMouse;
        try {
            moveMouse = new Robot();
            moveMouse.mouseMove(0, 0);

            resp.setContentType("text/html");
            resp.getWriter().write("<html><body>We have moved the mouse</body></html>");
            resp.getWriter().flush();
        } catch (AWTException e) {
            throw new ServletException(e);
        }

    }

}
