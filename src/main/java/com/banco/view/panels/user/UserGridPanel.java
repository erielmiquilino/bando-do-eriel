package com.banco.view.panels.user;

import com.banco.view.dialogs.UserDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGridPanel {
    private JPanel userGridPanel;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton inclurButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JTable table1;

    public UserGridPanel() {
        inclurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDialog dialog = new UserDialog();
                dialog.pack();
                dialog.setVisible(true);
                System.exit(0);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getUserGridPanel() {
        return userGridPanel;
    }

    private void createUIComponents() {
        userGridPanel = new JPanel();
        userGridPanel.setVisible(false);
    }
}
