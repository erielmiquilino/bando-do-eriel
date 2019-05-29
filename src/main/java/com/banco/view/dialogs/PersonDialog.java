package com.banco.view.dialogs;

import com.banco.view.panels.person.PersonLegalFormPanel;
import com.banco.view.panels.person.PersonPhysicsFormPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PersonDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelType;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JComboBox comboBox1;

    private PersonLegalFormPanel personLegalFormPanel;
    private PersonPhysicsFormPanel personPhysicsFormPanel;

    public PersonDialog() {
        setTitle("Pessoa");
        setContentPane(contentPane);
        setSize(new Dimension(500, 375));
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();

                int selected = comboBox.getSelectedIndex();
                if(selected == 0){
                    getPersonPhysicsFormPanel().getContentPane().setVisible(true);
                    getPersonLegalFormPanel().getContentPane().setVisible(false);
                } else {
                    getPersonPhysicsFormPanel().getContentPane().setVisible(false);
                    getPersonLegalFormPanel().getContentPane().setVisible(true);
                }
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
        dispose();
    }

    private void onCancel() {
        dispose();
    }


    public PersonPhysicsFormPanel getPersonPhysicsFormPanel() {
        if (personPhysicsFormPanel == null) {
            personPhysicsFormPanel = new PersonPhysicsFormPanel();
            personPhysicsFormPanel.getContentPane().setVisible(true);
        }
        return personPhysicsFormPanel;
    }

    public PersonLegalFormPanel getPersonLegalFormPanel() {
        if (personLegalFormPanel == null) {
            personLegalFormPanel = new PersonLegalFormPanel();
            personLegalFormPanel.getContentPane().setVisible(false);
        }
        return personLegalFormPanel;
    }


    private void createUIComponents() {
        panelType = new JPanel(new CardLayout());
        panelType.add(getPersonPhysicsFormPanel().getContentPane());
        panelType.add(getPersonLegalFormPanel().getContentPane());

    }
}
