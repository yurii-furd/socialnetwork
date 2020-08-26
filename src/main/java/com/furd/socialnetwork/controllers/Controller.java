package com.furd.socialnetwork.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGetDoPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGetDoPost(req, resp);
    }

    protected void doGetDoPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String value = request.getParameter("command");
        if("registration".equals(value)){
            String email = request.getParameter("email");
            System.out.println(email);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, resp);
    }
}
