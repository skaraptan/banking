package serviceImpl; /**
 * Created by skaraptan on 2015-11-17.
 */
import DAO.AccountService;
import model.Account;
import model.User;
import model.Operation;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
        }
    }
    public Collection<Account> getAccount(User user) throws SQLException{
        Session session = null;
        List accounts = new ArrayList<Account>();
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            session.beginTransaction();
            Integer userId = user.getUserId();
            Query query = session.createQuery(
                    "select  from account INNER JOIN users BY user_id WHERE users.user_id = :userId"
            )
                    .setInteger("userId", userId);
            accounts = (List<Account>)query.list();
           // session.getTransaction().commit();
        }
        finally {
            if ( session != null && session.isOpen()){
                session.close();
            }
        }
        return accounts;
    }

    public void newOperation(Long operationId, BigDecimal amount, Boolean isPayment, java.sql.Date date, Account account, Account targetAccount){

        targetAccount.setMoneyAmount( targetAccount.getMoneyAmount().add(amount)); //changes target account state according to transaction
        account.setMoneyAmount(account.getMoneyAmount().subtract(amount)); //changes payer account according to transaction
        new Operation(operationId, amount, isPayment, date, account, targetAccount);

    }
}
