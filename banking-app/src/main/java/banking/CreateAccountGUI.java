package banking;

import model.Account;
import model.User;
import serviceImpl.AccountServiceImpl;
import serviceImpl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 30.01.2016.
 */
public class CreateAccountGUI extends JFrame{
    private JPanel panel1;
    private JTextField loginTextField;
    private JButton generateAccountButton;
    private UserServiceImpl userService = new UserServiceImpl();
    private AccountServiceImpl accountService = new AccountServiceImpl();
    private String accountNumber;
    public CreateAccountGUI(){
        super("ACME Bank");
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        generateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User currentUser = null;
                Account currentUserAccount = null;
                Boolean success = false;

                try {
                    currentUser = userService.getByLogin(loginTextField.getText());
                    currentUserAccount = new Account(currentUser);
                    accountNumber = accountService.createAccount(currentUserAccount);
                    success = true;
                }
                catch(Exception ex){
                    JOptionPane.showConfirmDialog(panel1, "No such username, or user already has account" + ex);
                }
                finally{
                    if(success) {
                        new CreateAccountGUIConfirm(accountNumber);
                        dispose();
                    }
                }
            }
        });
    }
}
