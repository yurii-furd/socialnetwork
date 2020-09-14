package com.furd.socialnetwork.commands;

import com.furd.socialnetwork.dao.UserDAO;
import com.furd.socialnetwork.dao.impl.H2UserDAO;
import com.furd.socialnetwork.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class UserRegistration implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("psw");
        String pswRepeat = request.getParameter("psw-repeat");
        String fullName = request.getParameter("full-name");
        String homeCity = request.getParameter("home-city");
        String phoneNumber = request.getParameter("phone-number");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String birthday = request.getParameter("birthday");
        Date date = null;
        try {
            date = new Date(formatter.parse(birthday).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String email = request.getParameter("email");


        // Validation
        // TODO 1. Check login is free and correct

        if (login.length() < 3) {
            return "error";
        } else if (!password.equals(pswRepeat) || password.length() < 5) {
            return "error";
        } else if (fullName.length() < 5 || fullName.length() > 25) {
            return "error";
        }

        // Creating user
        User user = new User()
                .setLogin(login)
                .setPassword(password)
                .setFullName(fullName)
                .setHomeCity(homeCity)
                .setPhoneNumber(phoneNumber)
                .setBirthday(date)
                .setEmail(email);

        // Store user to DB
        UserDAO userDAO = new H2UserDAO();
        userDAO.create(user);
        System.out.println(user.getId());


        return "/index.jsp";
    }

}