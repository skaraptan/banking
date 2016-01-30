package serviceImpl;

import model.Operation;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import util.HibernateUtil;

/**
 * Created by Yoga2pro on 30.01.2016.
 */
public class OperationServiceImpl extends Thread {
    private Operation operation;

    public OperationServiceImpl(Operation operation) {
        this.operation = operation;
    }
    public void run(){
            TransactionException err = new TransactionException("Lack of cash");
            Session session = null;

            try {

                if (operation.getAccount().getMoneyAmount().compareTo(operation.getAmount()) < 0) {
                    System.out.println("Not enough money");
                    throw err;
                } else {
                    operation.getTargetAccount().setMoneyAmount(operation.getTargetAccount().getMoneyAmount().add(operation.getAmount())); //changes target account state according to transaction
                    operation.getAccount().setMoneyAmount(operation.getAccount().getMoneyAmount().subtract(operation.getAmount())); //changes payer account according to transaction
                    session = new HibernateUtil().getSessionFactory().openSession();
                    session.beginTransaction();
                    session.update(operation.getTargetAccount());
                    session.update(operation.getAccount());
                    new HistoryServiceImpl().addToHistory(operation);
                    session.getTransaction().commit();
                }
            } catch (TransactionException E) {
                System.err.println("Transaction failed : \n" + err);

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                System.out.println("Transaction ends properly");
            }


        }
    }
