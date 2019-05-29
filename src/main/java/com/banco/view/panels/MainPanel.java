package com.banco.view.panels;

import com.banco.view.panels.person.PersonGridPanel;
import com.banco.view.panels.user.UserGridPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JPanel mainPanel;
    private JButton usuariosButton;
    private JButton pessoasButton;
    private JButton sairButton;
    private JPanel dataPanel;

    private UserGridPanel userGridPanel;
    private PersonGridPanel personGridPanel;

    public MainPanel() {
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUserGridPanel().getUserGridPanel().setVisible(true);
                getPersonGridPanel().getPersonGridPanel().setVisible(false);
            }
        });
        pessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUserGridPanel().getUserGridPanel().setVisible(false);
                getPersonGridPanel().getPersonGridPanel().setVisible(true);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public UserGridPanel getUserGridPanel() {
        if (userGridPanel == null) {
            userGridPanel = new UserGridPanel();
        }
        return userGridPanel;
    }

    public PersonGridPanel getPersonGridPanel() {
        if (personGridPanel == null) {
            personGridPanel = new PersonGridPanel();
        }
        return personGridPanel;
    }


    private void createUIComponents() {
        dataPanel = new JPanel(new CardLayout());
        dataPanel.add(getUserGridPanel().getUserGridPanel());
        dataPanel.add(getPersonGridPanel().getPersonGridPanel());
    }
}
