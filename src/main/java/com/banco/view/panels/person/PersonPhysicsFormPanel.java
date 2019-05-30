package com.banco.view.panels.person;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;

public class PersonPhysicsFormPanel {
    private JTextField txtCpf;
    private JTextField txtRg;
    private JPanel contentPane;
    private JXDatePicker txaDateOfBirth;


    public JPanel getContentPane() {
        return contentPane;
    }

    private void createUIComponents() {
        contentPane = new JPanel();
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public JTextField getTxtRg() {
        return txtRg;
    }

    public JXDatePicker getTxaDateOfBirth() {
        return txaDateOfBirth;
    }
}
