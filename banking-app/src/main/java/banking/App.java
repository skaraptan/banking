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
        //Services
        UserServiceImpl userService = new UserServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        HistoryService historyService = new HistoryServiceImpl();
        System.out.println("Test app");
        new StartScreen();
/*
        //User creation section
  //      User user1 = new User(null, "Serhiy", "Karaptan", "skaraptan", "rfhgbr1995");
  //      User user2 = new User(null, "Jan", "Kowalski", "jkowalski", "jkow1234");
 //       userService.createUser(user1);
 //       userService.createUser(user2);

        User user3 = userService.getById(5);
        User user4 = userService.getById(6);
        //Account creation section
        Account account1 = accountService.getAccount(user3).get(0);
        Account account2 = accountService.getAccount(user4).get(0);
        //accountService.createAccount(account1);
        //accountService.createAccount(account2);

        //Test getting users from DB by Id
        //Test getting account from DB by user
        //List<Account> accounts1 = accountService.getAccount(user3);
        //List<Account> accounts2 = accountService.getAccount(user4);

        Operation operation1 = new Operation(null, new BigDecimal(10000.67), false, new Date(), account1, account2);
        Operation operation2 = new Operation(null, new BigDecimal(30000.67), false, new Date(), account1, account2);
        accountService.newOperation(operation1);
        accountService.newOperation(operation2);
        //Test password verification (boolean Type)
        //userService.verifyPassword("skaraptan", "rfhgbr1995");

        //Test password changing
        //userService.changePassword(user3, "niak1", "rfhgbr1995", "rfhgbr1995");
       // List<Operation> history = historyService.getAccountHistory(accounts2.get(0));
        //for(int i=0; i < history.size(); i++){
         //   System.out.println("Operation ID   :   " + history.get(i).getOperationId());
        //}

*/

    }
}
