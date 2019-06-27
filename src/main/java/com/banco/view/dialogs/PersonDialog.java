package com.banco.view.dialogs;

import com.banco.controller.ValidationPerson;
import com.banco.model.person.Person;
import com.banco.view.panels.person.PersonLegalFormPanel;
import com.banco.view.panels.person.PersonPhysicsFormPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.ZoneId;
import java.util.Date;

public class PersonDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelType;
    private JTextField txtName;
    private JTextField txtTelephone;
    private JTextField txtZipCode;
    private JTextField txtAddress;
    private JTextField txtDistrict;
    private JTextField txtCity;
    private JTextField txtAddressNumber;
    private JTextField txtState;
    private JComboBox cmbModality;

    private boolean vaidDialog;

    private PersonLegalFormPanel personLegalFormPanel;
    private PersonPhysicsFormPanel personPhysicsFormPanel;

    private Person person;

    public PersonDialog(Person person) {
        this.person = person;

        setTitle("Pessoa");
        setContentPane(contentPane);
        setSize(new Dimension(500, 375));
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);

        Date date = new Date(System.currentTimeMillis());
        personLegalFormPanel.getTxtOpenigDate().setDate(date);
        personPhysicsFormPanel.getTxaDateOfBirth().setDate(date);

        setFormValue();

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

        cmbModality.addActionListener(new ActionListener() {
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
        getFormValue();
        if (ValidationPerson.isValidPerson(person)) {
            vaidDialog = true;
            dispose();
        }
    }

    private void onCancel() {
        vaidDialog = false;
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

    private void setFormValue() {
        txtName.setText(this.person.getName());
        txtTelephone.setText(this.person.getTelephone());
        txtZipCode.setText(this.person.getAddress().getZipCode());
        txtAddress.setText(this.person.getAddress().getAddress());
        txtAddressNumber.setText(this.person.getAddress().getAddressNumber());
        txtDistrict.setText(this.person.getAddress().getDistrict());
        txtCity.setText(this.person.getAddress().getCity());
        txtState.setText(this.person.getAddress().getState());
        cmbModality.setSelectedIndex(this.person.getModality());

        if (this.person.getModality() == 0) {
            getPersonPhysicsFormPanel().getTxtCpf().setText(this.person.getCpfCnpj());
            getPersonPhysicsFormPanel().getTxtRg().setText(this.person.getRegistration());

            if (this.person.getDate() != null) {
                getPersonPhysicsFormPanel().getTxaDateOfBirth()
                        .setDate(Date.from(this.person.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }

        } else {
            getPersonLegalFormPanel().getTxtCnpj().setText(this.person.getCpfCnpj());
            getPersonLegalFormPanel().getTxtIE().setText(this.person.getRegistration());

            if (this.person.getDate() != null) {
                getPersonLegalFormPanel().getTxtOpenigDate()
                        .setDate(Date.from(this.person.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
        }
    }

    private void getFormValue() {

        this.person.setName(txtName.getText());
        this.person.setTelephone(txtTelephone.getText());
        this.person.getAddress().setZipCode(txtZipCode.getText());
        this.person.getAddress().setAddress(txtAddress.getText());
        this.person.getAddress().setAddressNumber(txtAddressNumber.getText());
        this.person.getAddress().setDistrict(txtDistrict.getText());
        this.person.getAddress().setCity(txtCity.getText());
        this.person.getAddress().setState(txtState.getText());
        this.person.setModality(cmbModality.getSelectedIndex());

        if (this.person.getModality() == 0) {
            this.person.setCpfCnpj(getPersonPhysicsFormPanel().getTxtCpf().getText());
            this.person.setRegistration(getPersonPhysicsFormPanel().getTxtRg().getText());
            this.person.setDate(getPersonPhysicsFormPanel()
                    .getTxaDateOfBirth().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            this.person.setCpfCnpj(getPersonLegalFormPanel().getTxtCnpj().getText());
            this.person.setRegistration(getPersonLegalFormPanel().getTxtIE().getText());
            this.person.setDate(getPersonLegalFormPanel()
                    .getTxtOpenigDate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
    }

    public Person getPerson() {
        return person;
    }

    public boolean isVaidDialog() {
        return vaidDialog;
    }
}
