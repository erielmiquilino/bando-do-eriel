package com.banco.model.tables;

import com.banco.model.user.User;
import com.banco.model.user.UserDao;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelUser extends AbstractTableModel {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int EMAIL = 2;

    private UserDao userDao;
    private String[] columns = new String[] {"ID","Nome","Email"};
    private List<User> userList;


    public TableModelUser() {
        this.userDao = new UserDao();
        this.userList = this.userDao.listUsers();
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
        this.userDao.saveUser(user);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void updateUser(User user ,int index) {
        this.userList.set(index, user);
        this.userDao.alterUser(user);
        fireTableDataChanged();
    }


    public void removeSelectedUser(int lineIndex) {
        this.userList.remove(lineIndex);
        fireTableDataChanged();
    }

    public void addUsers(List<User> userList) {
        int index = getRowCount();
        this.userList.addAll(userList);
        fireTableRowsInserted(index, index + userList.size());
    }

    public void clearTable() {
        this.userList.clear();
        fireTableDataChanged();
    }

}
