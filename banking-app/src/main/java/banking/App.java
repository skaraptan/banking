package banking;

import model.User;
import model.Account;
import serviceImpl.AccountServiceImpl;
import serviceImpl.UserServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        Scanner s = new Scanner(System.in);
        System.out.println("Test app");
        User user1 = new User(null, "Serhiy", "Karaptan", "skaraptan", "rfhgbr1995");
        User user2 = new User(null, "Jan", "Kowalski", "jkowalski", "jkow1234");
        userService.createUser(user1);
        userService.createUser(user2);
        Account account1 = new Account("1234567890", new BigDecimal(1000000), user1);
        Account account2 = new Account("9876543210", new BigDecimal(5566770), user2);
        accountService.createAccount(account1);
        System.out.println(accountService.getAccount(user1).toString());
        //accountService.createAccount(account2);
    }
}
