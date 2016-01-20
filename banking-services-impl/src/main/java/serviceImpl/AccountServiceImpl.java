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

public class AccountServiceImpl implements AccountService{
    public void createAccount(Account account) throws SQLException{
        Session session = null;
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
            System.out.println("Successfully created " + account.toString() + "    AN:  " + account.getAccountNumber());
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
            if(accounts.isEmpty()){
                throw new Exception("User has no accounts");
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

    public void newOperation(Operation operation){

        TransactionException err = new TransactionException("Lack of cash");
        Session session = null;
        try{

            if(operation.getAccount().getMoneyAmount().compareTo(operation.getAmount()) < 0){
                System.out.println("Not enough money");

                throw err;
            }
            else {
                operation.getTargetAccount().setMoneyAmount(operation.getTargetAccount().getMoneyAmount().add(operation.getAmount())); //changes target account state according to transaction
                operation.getAccount().setMoneyAmount(operation.getAccount().getMoneyAmount().subtract(operation.getAmount())); //changes payer account according to transaction
                session = new HibernateUtil().getSessionFactory().openSession();
                session.beginTransaction();
                session.update(operation.getTargetAccount());
                session.update(operation.getAccount());
                new HistoryServiceImpl().addToHistory(operation);
                session.getTransaction().commit();
            }
        }
        catch(TransactionException E){
                System.err.println("Transaction failed : \n" + err);

        }
        finally{
            if(session != null && session.isOpen()){
                session.close();
            }
            System.out.println("Transaction ends properly");
        }


    }
}
