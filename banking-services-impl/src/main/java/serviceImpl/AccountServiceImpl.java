package serviceImpl; /**
 * Created by skaraptan on 2015-11-17.
 */

import DAO.AccountService;
import model.Account;
import model.Operation;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    public synchronized String createAccount(Account account){
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
                message = new String("Successfully created " + "    AN:  " + account.getAccountNumber());
                System.out.println(message);
                return message;
            }
        } else {
            message = new String("User already has account specified");
            System.out.println(message);
            return message;
        }
    }

    public List<Account> getAccount(User user) {
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

    public synchronized void deleteAccount(User user) {
        Session session = null;
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            Account account = (Account)session.createCriteria(Account.class).add(Restrictions.eq("user", user)).uniqueResult();
            if(account!=null) {
                session.beginTransaction();
                session.delete(account);
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.err.print(ex);
            session.getTransaction().rollback();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public synchronized Account getByAccountNumber(String accountNumber){
            Account account = null;
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                account = (Account) session.createCriteria(Account.class)
                        .add(Restrictions.eq("accountNumber", accountNumber))
                        .uniqueResult();
                Hibernate.initialize(account);
            } catch (Exception e) {
                System.out.println("Error,account probably doesn't exist");
                System.err.print(e);
            } finally {
                if (session != null && session.isOpen())
                    session.close();
            }
            return account;
    }
}