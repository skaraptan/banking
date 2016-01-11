package banking;

import DAO.HistoryService;
import model.Account;
import model.Operation;
import model.User;
import serviceImpl.AccountServiceImpl;
import serviceImpl.HistoryServiceImpl;
import serviceImpl.UserServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        HistoryService historyService = new HistoryServiceImpl();
        System.out.println("Test app");


        //Test getting users from DB by Id
        User user3 = userService.getById(118);
        User user4 = userService.getById(119);



        //Test getting account from DB by user
        List<Account> accounts1 = accountService.getAccount(user3);
        List<Account> accounts2 = accountService.getAccount(user4);

        Operation operation1 = new Operation(null, new BigDecimal(1002.67), false, new Date(), /*basic*/ accounts2.get(0), /*target*/ accounts1.get(0));
        accountService.newOperation(operation1);

        List<Operation> history = historyService.getAccountHistory(accounts2.get(0));
        for(int i=0; i < history.size(); i++){
            System.out.println("Operation ID   :   " + history.get(i).getOperationId());
        }
        /*
       //User creation section
            User user1 = new User(null, "Serhiy", "Karaptan", "skaraptan", "rfhgbr1995");
            User user2 = new User(null, "Jan", "Kowalski", "jkowalski", "jkow1234");
            userService.createUser(user1);
            userService.createUser(user2);


        //Account creation section
        Account account1 = new Account("1234567890", new BigDecimal(100000), user1);
        Account account2 = new Account("9876543210", new BigDecimal(556677), user2);
        accountService.createAccount(account1);
        accountService.createAccount(account2);


        //Test password verification (boolean Type)
        userService.verifyPassword("skaraptan", "rfhgbr1995");


        //Test password changing
        userService.changePassword(user1, "rfhgbr1995", "Ziemniak1", "Ziemniak1");

    */


    }
}
