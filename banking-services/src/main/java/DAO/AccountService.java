package DAO;

import model.Account;
import model.Operation;
import model.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by skaraptan on 2015-11-10.
 */
public interface AccountService {
    String createAccount(Account account) throws Exception;
    List<Account> getAccount(User user) throws Exception;
    void newOperation(Operation operation) throws Exception;
    void deleteAccount(User user) throws Exception;
    Account getByAccountNumber(String accountNumber);

}
