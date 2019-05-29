package com.banco.view.panels.person;

import javax.swing.*;

public class PersonGridPanel {
    private JPanel personGridPanel;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton incluirButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton incluirContaButton;
    private JButton visualizarContasDaPessoaButton;

    public JPanel getPersonGridPanel() {
        return personGridPanel;
    }

    private void createUIComponents() {
        personGridPanel = new JPanel();
        personGridPanel.setVisible(false);
    }
}
