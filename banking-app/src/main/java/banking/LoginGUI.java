package banking;

import model.User;
import serviceImpl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 25.01.2016.
 */
public class LoginGUI extends JFrame{
    private JPanel panel1;
    private JButton logInButton;
    private JTextField loginTextField;
    private JTextField passwordTextField;
    private JButton registerButton;
    private User user= null;
    private String login;
    private String password;

    private UserServiceImpl userService = new UserServiceImpl();
    public LoginGUI(){
        super("ACME Bank");
        setContentPane(panel1);
        pack();

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateUserGUI();

            }
        });
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login = loginTextField.getText();
                password = passwordTextField.getText();
                boolean success = false;
                try {
                    user = userService.getByLogin(login);
                    if(user!=null){
                       success = userService.verifyPassword(login, password);
                    }
                }
                catch (Exception ex){
                    String message = new String("Login failed, try again" + ex);
                    JOptionPane.showConfirmDialog(panel1, message);
                }
                finally {
                    if(success){
                        JOptionPane.showConfirmDialog(panel1, "Login successful");

                    }
                }
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
