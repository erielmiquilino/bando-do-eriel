package com.banco;

import com.banco.util.HibenateFactory;
import com.banco.view.dialogs.LoginDialog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class Main {



    public static void main(String[] args) throws Exception {
        new HibenateFactory();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        LoginDialog loginDialog = new LoginDialog();
        loginDialog.setVisible(true);



    }

}
