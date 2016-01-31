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
    private JButton generateAccountButton;
    private AccountServiceImpl accountService = new AccountServiceImpl();
    private String accountNumber;
    private User currentUser;
    public CreateAccountGUI(User user){
        super("ACME Bank");
        this.currentUser = user;
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        generateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Account currentUserAccount = null;
                Boolean success = false;

                try {
                    currentUserAccount = new Account(currentUser);
                    accountNumber = accountService.createAccount(currentUserAccount);
                    success = true;
                }
                catch(Exception ex){
                    JOptionPane.showConfirmDialog(panel1, "User already has account" + ex);
                }
                finally{
                    if(success) {
                        new CreateAccountGUIConfirm(currentUser);
                        dispose();
                    }
                    else{
                        new CreateAccountGUIConfirm(currentUser);
                        dispose();
                    }
                }
            }
        });
    }
}
