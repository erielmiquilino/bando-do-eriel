package com.banco.view.dialogs;

import com.banco.model.Account;
import com.banco.model.tables.TableModelAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.List;

public class AccountPersonDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTable accountTable;
    private JButton editarButton;
    private JButton excluirButton;
    private List<Account> accountList;
    private TableModelAccount tableModelAccount;

    public AccountPersonDialog(List<Account> accountList) {
        this.accountList = accountList;

        setTitle("Contas");
        setContentPane(contentPane);
        setSize(new Dimension(481, 490));
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = accountTable.getSelectedRow();
                if (index > -1) {

                    Account account = getTableModelAccount().getSelectedAccount(index);

                    account.setLastChangeDate(LocalDateTime.now());

                    AccountPersonFormDialog dialog = new AccountPersonFormDialog(account);
                    dialog.pack();
                    dialog.setVisible(true);

                    getTableModelAccount().updateAccount(dialog.getAccount(), index);

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = accountTable.getSelectedRow();
                if (index > -1) {
                    getTableModelAccount().removeSelectedAccount(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onOK();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public TableModelAccount getTableModelAccount() {
        if (tableModelAccount == null) {
            tableModelAccount = new TableModelAccount(accountList);
        }
        return tableModelAccount;
    }

    private void createUIComponents() {
       accountTable = new JTable(getTableModelAccount());
    }
}
