package com.banco.view.dialogs;

import com.banco.view.frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPasswordField txtPassword;
    private JTextField txtUser;

    public LoginDialog() {
        setTitle("Bem vindo ao banco do ian");
        setSize(new Dimension(300,150));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        if (txtUser.getText().equals("admin") && String.valueOf(txtPassword.getPassword()).equals("admin")) {
            System.out.println("ENTROU");
            dispose();
            new MainFrame();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario e(ou) senha Incorreto!",
                    "Verifique!", JOptionPane.INFORMATION_MESSAGE);
            txtUser.requestFocus();
            txtUser.setText("");
            txtPassword.setText("");
        }

    }

    private void onCancel() {
        System.exit(0);
    }
}
