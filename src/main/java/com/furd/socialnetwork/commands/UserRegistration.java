package com.furd.socialnetwork.commands;

import com.furd.socialnetwork.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRegistration implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String login = request.getParameter("login");
        String password = request.getParameter("psw");
        String pswRepea = request.getParameter("psw-repea");
        String fullName = request.getParameter("full-name");
        String homeCity = request.getParameter("home-city");
        String phoneNumber = request.getParameter("phone-number");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String birthday = request.getParameter("birthday");
        Date date = formatter.parse(birthday);

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
                .setPhoneNumber(phoneNumber)
                .setBirthday(date)
                .setEmail(email);

        // Store user to DB


        return "/index.jsp";
    }

}
