package DAO;

import model.Account;
import model.Operation;
import model.User;

import java.util.List;

/**
 * Created by skaraptan on 2015-11-10.
 */
public interface AccountService {
    void createAccount(Account account) throws Exception;
    List<Account> getAccount(User user) throws Exception;
    void newOperation(Operation operation) throws Exception;


}
