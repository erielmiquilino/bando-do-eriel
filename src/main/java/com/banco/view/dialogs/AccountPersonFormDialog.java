package com.banco.view.dialogs;

import com.banco.model.account.Account;
import com.banco.model.account.AccountType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountPersonFormDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox<AccountType> cmbAccountType;
    private JTextField txtAccount;
    private JTextField txtAgency;

    private boolean validDialog;

    private Account account;

    public AccountPersonFormDialog(Account account) {
        this.account = account;

        setTitle("Conta");
        setContentPane(contentPane);
        setSize(new Dimension(300,125));
        setLocationRelativeTo(null);
        setModal(true);
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
        validDialog = true;
        dispose();
    }

    private void setFormValues () {
        txtAccount.setText(account.getAccount());
        txtAgency.setText(String.valueOf(account.getAgency()));
        cmbAccountType.setSelectedItem(account.getAccountType());
    }


    private void getFormValues () {
        account.setAccount(txtAccount.getText());
        account.setAgency(Long.parseLong(txtAgency.getText()));
        account.setAccountType((AccountType) cmbAccountType.getSelectedItem());
    }

    public Account getAccount() {
        return account;
    }

    private void onCancel() {
        validDialog = false;
        dispose();
    }


    private void createUIComponents() {
        cmbAccountType = new JComboBox<>();
        cmbAccountType.setModel(new DefaultComboBoxModel<>(AccountType.values()));
    }


    public boolean isValidDialog() {
        return validDialog;
    }
}
