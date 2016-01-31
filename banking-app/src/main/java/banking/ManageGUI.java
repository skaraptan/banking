package banking;

import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 30.01.2016.
 */
public class ManageGUI extends JFrame{
    private JPanel panel1;
    private JButton createAccountButton;
    private JButton manageButton;
    private JButton newTransactionButton;
    private JTextArea welcomeChooseWhatYouTextArea;
    private JButton logOutButton;
    private User currentUser;
    public ManageGUI(User user){
        super("ACME Bank");
        this.currentUser = user;
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateAccountGUI(currentUser);
                dispose();
            }
        }
        );
        manageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteAccountGUI(currentUser);
                dispose();
            }
        });
        newTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NewTransactionGUI(currentUser);
                dispose();
            }
        });
        logOutButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StartScreen();
                dispose();
            }
        }));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
