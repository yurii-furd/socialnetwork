package com.furd.socialnetwork.commands;

import com.furd.socialnetwork.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class UserRegistration implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("psw");
        String pswRepea = request.getParameter("psw-repea");
        String fullName = request.getParameter("full-name");
        String homeCity = request.getParameter("home-city");
        String phoneNumber = request.getParameter("phone-number");
        int phoneNumber1 = Integer.parseInt(phoneNumber.trim());
        String birthday = request.getParameter("birthday");

        String email = request.getParameter("email");


        // Validation
        // TODO 1. Check login is free and correct

        if (login.length() < 3) {
            return "error";
        } else if (password != pswRepea && password.length() < 5) {
            return "error";
        } else if (fullName.length() < 5 && fullName.length() > 25) {
            return "error";
        }

        // Creating user
        User user = new User()
                .setLogin(login)
                .setPassword(password)
                .setPassword(pswRepea)
                .setFullName(fullName)
                .setHomeCity(homeCity)
                .setPhoneNumber(phoneNumber1)
                //.setBirthday(birthday1)
                .setEmail(email);

        // Store user to DB


        return "/index.jsp";
    }

}
