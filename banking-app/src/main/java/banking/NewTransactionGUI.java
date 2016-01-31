package banking;

import model.Account;
import model.Operation;
import model.User;
import org.hibernate.TransactionException;
import serviceImpl.AccountServiceImpl;

import javax.swing.*;
import javax.transaction.Transaction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Yoga2pro on 31.01.2016.
 */
public class NewTransactionGUI extends JFrame{
    private JTextField targetAccountNumberTextField;
    private JPanel panel1;
    private JTextField amountTextField;
    private JButton makeTransactionButton;
    private User currentUser;
    private Account targetAccount;
    private Account currentUserAccount;
    private BigDecimal amount;
    private AccountServiceImpl accountService = new AccountServiceImpl();

    public NewTransactionGUI(User user){
        super("ACME Bank");
        this.currentUser = user;
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        currentUserAccount = accountService.getAccount(currentUser).get(0);
        makeTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                targetAccount = accountService.getByAccountNumber(targetAccountNumberTextField.getText());
                amount = new BigDecimal(amountTextField.getText());
                boolean success = false;
                try {
                    accountService.newOperation(new Operation(null, amount, true, new Date(), currentUserAccount, targetAccount));
                    success = true;
                    Thread.sleep(1000);
                }
                catch (TransactionException ex){
                }
                catch (InterruptedException exx){

                }
                finally {
                    if(success) {
                        JOptionPane.showConfirmDialog(panel1, "Transaction to account \n" + targetAccount.getAccountNumber() + "\nwith amount:  " +
                                amount + "\n ends properly. Thank you\n" + "\nYou balance is: " + accountService.getAccount(currentUser).get(0).getMoneyAmount());
                    }
                    else{
                        JOptionPane.showConfirmDialog(panel1, "Not enough money!" + "\n\nYou balance is: " + currentUserAccount.getMoneyAmount());
                    }
                    new ManageGUI(currentUser);
                    dispose();
                }

            }
        });


    }
}
