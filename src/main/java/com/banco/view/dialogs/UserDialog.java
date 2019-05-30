package com.banco.view.dialogs;

import com.banco.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPasswordField txtPassword;
    private JTextField txtEmail;
    private JTextField txtName;

    private User user;

    public UserDialog(User user) {
        this.user = user;

        setTitle("Usuário");
        setContentPane(contentPane);
        setSize(new Dimension(350, 125));
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);
        setFormValues();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        getFormValues();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void setFormValues () {
        txtName.setText(this.user.getName());
        txtEmail.setText(this.user.getMail());
        txtPassword.setText(this.user.getPassword());
    }

    private void getFormValues () {
        this.user.setName(txtName.getText());
        this.user.setMail(txtEmail.getText());
        this.user.setPassword(String.valueOf(txtPassword.getPassword()));
    }

    public User getUser() {
        return user;
    }
}
