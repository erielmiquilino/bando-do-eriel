package com.banco.controller;

import com.banco.model.User;

import javax.swing.*;

public class ValidationUser {

    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isValidUser(User user) {
        String errorMessage = "";

        boolean valid = true;

        if (user.getName().isEmpty()) {
            valid = false;
            errorMessage += "Campo nome esta em branco\n";
        }

        if (user.getMail().isEmpty()) {
            valid = false;
            errorMessage += "Campo Email esta em branco\n";
        } else if (!isValid(user.getMail())) {
            valid = false;
            errorMessage += "Email Invalido\n";
        }

        if (user.getPassword().isEmpty()) {
            valid = false;
            errorMessage += "Campo Senha esta em branco\n";
        }

        if (!valid) {
            JOptionPane.showMessageDialog(null, errorMessage);
        }

        return valid;
    }



}
