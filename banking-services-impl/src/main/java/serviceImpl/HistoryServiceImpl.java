package serviceImpl; /**
 * Created by skaraptan on 2015-12-07.
 */

import DAO.HistoryService;
import model.Account;
import model.Operation;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService{
    public void addToHistory(Operation operation) {
        Session session = null;
        try{
            session = new HibernateUtil().getSessionFactory().openSession();
            session.beginTransaction();
            session.save(operation);
            session.getTransaction().commit();
        }
        catch(Exception E){
                System.err.print("Failed to add operation to history");

        }
        finally{
            if(session != null && session.isOpen()){
                session.close();
            }
            System.out.println("History updated");
        }
    }

    public List<Operation> getAccountHistory(Account account){
        Session session = null;
        List<Operation> accountHistory = new ArrayList<Operation>();
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
             accountHistory = session.createCriteria(Operation.class)
                    .add(Restrictions.eq("account", account))
                    .list();
        }
        catch  (Exception e){
            System.err.print(e);
        }
        finally {
            if ( session != null && session.isOpen()){
                session.close();
            }
        }
        return accountHistory;
    }
    }
