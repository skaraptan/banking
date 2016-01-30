package banking;

import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 30.01.2016.
 */
public class CreateAccountGUIConfirm extends JFrame {
    private JPanel panel1;
    private JFormattedTextField accountNumberFormattedTextField;
    private JButton returnButton;
    private String accountNumber;

    public CreateAccountGUIConfirm(String accountNumber){
        super("ACME Bank");
        setContentPane(panel1);
        pack();
        this.accountNumber = accountNumber;
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accountNumberFormattedTextField.setValue(accountNumber);
        accountNumberFormattedTextField.repaint();
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageGUI();
                dispose();
            }
        });
    }
}