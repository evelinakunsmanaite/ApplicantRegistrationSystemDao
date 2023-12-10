package com.validators;

import com.controller.InitServlet;
import com.errors.ValidationError;
import com.model.Abiturient;
import com.model.User;

public class Validator extends InitServlet {

    public static void validate(String login, String password, User isUser, Abiturient isAbiturient, boolean isAdmin, ValidationError error) {
        boolean bool = true;

        if (login.trim().length() == 0) {
            error.addError("user.login.error");
            bool = false;
        }

        if (password.trim().length() == 0) {
            error.addError("user.pass.error");
            bool = false;
        }

        if (isUser == null && isAbiturient == null && !isAdmin && bool) {
            error.addError("user.pass");
        }
    }
}
