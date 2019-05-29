package com.banco.view.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountPersonDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTable table1;
    private JButton editarButton;
    private JButton excluirButton;

    public AccountPersonDialog() {
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

}
