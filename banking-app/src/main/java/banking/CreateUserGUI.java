package banking;

import model.User;
import serviceImpl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.SampleModel;

/**
 * Created by Yoga2pro on 24.01.2016.
 */
public class CreateUserGUI extends JFrame{
    private JTextField LoginTextField;
    private JPanel panel1;
    private JTextField nameTextField;
    private JTextField lastNameTextField;
    private JButton registerButton;
    private JTextField passwordTextField;
    private JButton loginButton;

    public User newUser;

    public CreateUserGUI(){
        super("ACME Bank");
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newUser = new User(null, nameTextField.getText(), lastNameTextField.getText(), LoginTextField.getText(), (String)passwordTextField.getText());
                try{
                new UserServiceImpl().createUser(newUser);
                }
                catch(Exception ex){
                    JOptionPane.showConfirmDialog(panel1, "Smth want wrong");
                }
                JOptionPane.showConfirmDialog(panel1, ("User  with ID : " + newUser.getUserId() +"   created!"));
                dispose();
                new LoginGUI();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
