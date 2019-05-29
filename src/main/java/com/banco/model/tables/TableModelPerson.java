package com.banco.model.tables;

import com.banco.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelPerson extends AbstractTableModel {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int TELEPHONE = 2;
    private static final int CPF_CNPJ = 3;

    private String[] columns = new String[] {"ID","Nome","Telefone","CPF CNPJ"};
    private List<Person> personList;

    public TableModelPerson(List<Person> personList) {
        this.personList = personList;
    }

    public TableModelPerson() {
        this.personList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case ID:
                return Integer.class;
            case NAME:
                return String.class;
            case TELEPHONE:
                return String.class;
            case CPF_CNPJ:
                return String.class;

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = personList.get(rowIndex);
        switch (columnIndex){
            case ID:
                return person.getId();
            case NAME:
                return person.getName();
            case TELEPHONE:
                return person.getTelephone();
            case CPF_CNPJ:
                return person.getCpfCnpj();

            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }


    public Person getSelectedPerson(int lineIndex) {
        return this.personList.get(lineIndex);
    }

    public void addPerson(Person person) {
        this.personList.add(person);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void removeSelectedPerson(int lineIndex) {
        this.personList.remove(lineIndex);
        fireTableDataChanged();
    }

    public void addAccounts(List<Person> personList) {
        int index = getRowCount();
        this.personList.addAll(personList);
        fireTableRowsInserted(index, index + personList.size());
    }

    public void clearTable() {
        this.personList.clear();
        fireTableDataChanged();
    }
}
