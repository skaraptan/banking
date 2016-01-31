package banking;

import model.User;
import serviceImpl.AccountServiceImpl;
import serviceImpl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 31.01.2016.
 */
public class DeleteAccountGUI extends JFrame {
    private JPanel panel1;
    private JButton deleteAccountButton;
    private AccountServiceImpl accountService = new AccountServiceImpl();
    private User currentUser;
    public DeleteAccountGUI(User user){

        super("ACME Bank");
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.currentUser = user;
        deleteAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accountService.deleteAccount(currentUser);
                if(accountService.getAccount(currentUser).isEmpty())
                    JOptionPane.showConfirmDialog(panel1, "Account deleted!");
                new ManageGUI(currentUser);
                dispose();
            }
        });
    }
}
