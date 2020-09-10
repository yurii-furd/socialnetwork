package com.furd.socialnetwork.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
