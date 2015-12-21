package DAO;

import model.Account;
import model.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.util.Collection;

/**
 * Created by skaraptan on 2015-11-10.
 */
public interface AccountService {
    void createAccount(Account account) throws SQLException;
    Collection<Account> getAccount(User user) throws SQLException;
    void newOperation(Long operationId, BigDecimal amount, Boolean isPayment, java.sql.Date date, Account account, Account targetAccount) throws SQLTransactionRollbackException;


}
