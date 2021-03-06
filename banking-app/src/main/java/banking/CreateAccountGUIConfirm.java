package banking;

import model.Account;
import model.User;
import serviceImpl.AccountServiceImpl;

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
    private User currentUser;
    private AccountServiceImpl accountService = new AccountServiceImpl();

    public CreateAccountGUIConfirm(User user){
        super("ACME Bank");
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        this.currentUser = user;
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accountNumberFormattedTextField.setValue(accountService.getAccount(currentUser).get(0).getAccountNumber());
        accountNumberFormattedTextField.repaint();
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageGUI(currentUser);
                dispose();
            }
        });
    }
}