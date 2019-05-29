package com.banco.view.frames;

import com.banco.view.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    public MainFrame() {
        setTitle("Bando do Eriel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setContentPane(getMainPanel().getMainPanel());

        setVisible(true);
    }

    public MainPanel getMainPanel() {
        if (mainPanel == null) {
            mainPanel = new MainPanel();
        }
        return mainPanel;
    }
}
