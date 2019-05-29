package com.banco.model.tables;

import com.banco.model.Account;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelAccount extends AbstractTableModel {

    private static final int ID = 0;
    private static final int AGENCY = 1;
    private static final int ACCOUNT = 2;
    private static final int ACCOUNT_TYPE = 3;

    private String[] columns = new String[] {"ID","Agencia","Conta","Tipo"};
    private List<Account> accountList;

    public TableModelAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

    public TableModelAccount() {
        this.accountList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return accountList.size();
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
            case AGENCY:
                return Long.class;
            case ACCOUNT:
                return String.class;
            case ACCOUNT_TYPE:
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
        Account account = accountList.get(rowIndex);
        switch (columnIndex){
            case ID:
                return account.getAccount();
            case AGENCY:
                return account.getAgency();
            case ACCOUNT:
                return account.getAccount();
            case ACCOUNT_TYPE:
                return account.getAccountType();

            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }


    public Account getSelectedAccount(int lineIndex) {
        return this.accountList.get(lineIndex);
    }

    public void addAccount(Account account) {
        this.accountList.add(account);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void removeSelectedAccount(int lineIndex) {
        this.accountList.remove(lineIndex);
        fireTableDataChanged();
    }

    public void addAccounts(List<Account> accountList) {
        int index = getRowCount();
        this.accountList.addAll(accountList);
        fireTableRowsInserted(index, index + accountList.size());
    }

    public void clearTable() {
        this.accountList.clear();
        fireTableDataChanged();
    }

}
