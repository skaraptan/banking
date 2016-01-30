package banking;

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

    public ManageGUI(){
        super("ACME Bank");
        setContentPane(panel1);
        pack();
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateAccountGUI();
                dispose();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
