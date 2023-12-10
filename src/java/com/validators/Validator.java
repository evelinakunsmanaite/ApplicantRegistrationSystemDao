package com.validators;

import com.controller.InitServlet;
import com.errors.ValidationError;
import com.model.Abiturient;

public class Validator extends InitServlet{
    public static void validate(String login, String password,boolean isUser,Abiturient isAbiturient,boolean isAdmin, ValidationError error) {
        
         if (login.trim().length() == 0) {
            error.addError("user.login.error");
        }

        if (password.trim().length() == 0) {
            error.addError("user.pass.error");
        }
        
        if (!isUser && isAbiturient == null && !isAdmin) {
            error.addError("user.pass");
        }
    }
}
