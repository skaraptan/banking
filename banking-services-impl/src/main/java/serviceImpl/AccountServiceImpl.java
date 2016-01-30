package serviceImpl; /**
 * Created by skaraptan on 2015-11-17.
 */

import DAO.AccountService;
import model.Account;
import model.Operation;
import model.User;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    public String createAccount(Account account) throws SQLException {
        String message;
        if (getAccount(account.getUser()).isEmpty()) {
            Session session = null;
            try {
                session = new HibernateUtil().getSessionFactory().openSession();
                session.beginTransaction();
                session.save(account);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                message = new String("Successfully created " + account.toString() + "    AN:  " + account.getAccountNumber());
                System.out.println(message);
                return message;
            }
        } else {
            message = new String("User already has account specified");
            System.out.println(message);
            return message;
        }
    }

    public List<Account> getAccount(User user) throws SQLException {
        Session session = null;
        List accounts = new ArrayList<Account>();
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            accounts = session.createCriteria(Account.class)
                    .add(Restrictions.eq("user", user))
                    .list();
            if (accounts.isEmpty()) {
                throw new Exception("User has no accounts\n");
            }
        } catch (Exception e) {
            System.err.print(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return accounts;
    }

    public synchronized void newOperation(Operation operation) {
        new OperationServiceImpl(operation).start();
    }
}