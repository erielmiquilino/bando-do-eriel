package com.banco.view.panels.person;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;

public class PersonLegalFormPanel {
    private JTextField txtCnpj;
    private JTextField txtIE;
    private JPanel contentPane;
    private JXDatePicker txtOpenigDate;


    public JPanel getContentPane() {
        return contentPane;
    }

    private void createUIComponents() {
        contentPane = new JPanel();
    }

    public JTextField getTxtCnpj() {
        return txtCnpj;
    }

    public JTextField getTxtIE() {
        return txtIE;
    }

    public JXDatePicker getTxtOpenigDate() {
        return txtOpenigDate;
    }
}
