package com.banco.view.panels.user;

import com.banco.model.User;
import com.banco.model.tables.TableModelUser;
import com.banco.view.dialogs.UserDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class UserGridPanel {
    private JPanel userGridPanel;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton inclurButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JTable userTable;


    private TableModelUser tableModelUser;

    public UserGridPanel() {
        inclurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();

                user.setId(getTableModelUser().getRowCount() + 1);
                user.setCreationDate(LocalDateTime.now());

                UserDialog dialog = new UserDialog(user);
                dialog.pack();
                dialog.setVisible(true);

                getTableModelUser().addUser(dialog.getUser());

            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = userTable.getSelectedRow();
                if (index > -1) {
                    User user = getTableModelUser().getSelectedUser(index);

                    user.setLastChangeDate(LocalDateTime.now());

                    UserDialog dialog = new UserDialog(user);
                    dialog.pack();
                    dialog.setVisible(true);

                    getTableModelUser().updateUser(user, index);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = userTable.getSelectedRow();
                if (index > -1) {
                    getTableModelUser().removeSelectedUser(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
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

    public TableModelUser getTableModelUser() {
        if (tableModelUser == null) {
            tableModelUser = new TableModelUser();
        }
        return tableModelUser;
    }


    private void createUIComponents() {
        userGridPanel = new JPanel();
        userGridPanel.setVisible(false);

        userTable = new JTable(getTableModelUser());
    }
}
