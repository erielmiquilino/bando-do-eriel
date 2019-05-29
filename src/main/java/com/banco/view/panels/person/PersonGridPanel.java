package com.banco.view.panels.person;

import com.banco.view.dialogs.AccountPersonDialog;
import com.banco.view.dialogs.AccountPersonFormDialog;
import com.banco.view.dialogs.PersonDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGridPanel {
    private JPanel personGridPanel;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton incluirButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton visualizarContasDaPessoaButton;
    private JButton incluirContaButton;

    public PersonGridPanel() {
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonDialog dialog = new PersonDialog();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        visualizarContasDaPessoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountPersonDialog dialog = new AccountPersonDialog();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        incluirContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountPersonFormDialog dialog = new AccountPersonFormDialog();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }

    public JPanel getPersonGridPanel() {
        return personGridPanel;
    }

    private void createUIComponents() {
        personGridPanel = new JPanel();
        personGridPanel.setVisible(false);
    }
}
