package com.banco.view.panels.person;

import com.banco.model.Person;
import com.banco.model.tables.TableModelPerson;
import com.banco.view.dialogs.AccountPersonDialog;
import com.banco.view.dialogs.AccountPersonFormDialog;
import com.banco.view.dialogs.PersonDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class PersonGridPanel {
    private JPanel personGridPanel;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton incluirButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton visualizarContasDaPessoaButton;
    private JButton incluirContaButton;
    private JTable personTable;

    private TableModelPerson tableModelPerson;

    public PersonGridPanel() {
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person();

                person.setId(getTableModelPerson().getRowCount() + 1);
                person.setCreationDate(LocalDateTime.now());

                PersonDialog dialog = new PersonDialog(person);
                dialog.pack();
                dialog.setVisible(true);

                getTableModelPerson().addPerson(dialog.getPerson());
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = personTable.getSelectedRow();
                if (index > -1) {
                    Person person = getTableModelPerson().getSelectedPerson(index);

                    person.setLastChangeDate(LocalDateTime.now());

                    PersonDialog dialog = new PersonDialog(person);
                    dialog.pack();
                    dialog.setVisible(true);

                    getTableModelPerson().updatePerson(dialog.getPerson(), index);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = personTable.getSelectedRow();
                if (index > -1) {
                    getTableModelPerson().removeSelectedPerson(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!");
                }
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

    public TableModelPerson getTableModelPerson() {
        if (tableModelPerson == null) {
            tableModelPerson = new TableModelPerson();
        }
        return tableModelPerson;
    }

    private void createUIComponents() {
        personGridPanel = new JPanel();
        personGridPanel.setVisible(false);

        personTable = new JTable(getTableModelPerson());
    }
}
