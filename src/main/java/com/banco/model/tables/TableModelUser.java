package com.banco.model.tables;

import com.banco.model.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelUser extends AbstractTableModel {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int EMAIL = 2;

    private String[] columns = new String[] {"ID","Nome","Email"};
    private List<User> userList;

    public TableModelUser(List<User> userList) {
        this.userList = userList;
    }

    public TableModelUser() {
        this.userList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return userList.size();
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
            case EMAIL:
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
        User user = userList.get(rowIndex);
        switch (columnIndex){
            case ID:
                return user.getId();
            case NAME:
                return user.getName();
            case EMAIL:
                return user.getMail();


            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }


    public User getSelectedUser(int lineIndex) {
        return this.userList.get(lineIndex);
    }

    public void addUser(User user) {
        this.userList.add(user);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void removeSelectedUser(int lineIndex) {
        this.userList.remove(lineIndex);
        fireTableDataChanged();
    }

    public void addAccounts(List<User> userList) {
        int index = getRowCount();
        this.userList.addAll(userList);
        fireTableRowsInserted(index, index + userList.size());
    }

    public void clearTable() {
        this.userList.clear();
        fireTableDataChanged();
    }

}
