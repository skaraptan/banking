package banking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yoga2pro on 30.01.2016.
 */
public class StartScreen extends  JFrame{

    private JPanel panel1;
    private JButton signInButton;
    private JButton registerButton;

    public StartScreen(){
        super("ACME Bank");
        setContentPane(panel1);
        pack();

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();

            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateUserGUI();

            }
        });
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
