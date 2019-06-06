package com.banco;

import com.banco.view.dialogs.LoginDialog;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        LoginDialog loginDialog = new LoginDialog();
        loginDialog.setVisible(true);


    }

}
