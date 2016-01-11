package DAO;

import model.Account;
import model.Operation;
import model.User;

import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.util.List;

/**
 * Created by skaraptan on 2015-11-10.
 */
public interface AccountService {
    void createAccount(Account account) throws SQLException;
    List<Account> getAccount(User user) throws SQLException;
    void newOperation(Operation operation) throws SQLTransactionRollbackException;


}
