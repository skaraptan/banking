package serviceImpl;

import DAO.UserService;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;

/**
 * Created by skaraptan on 2015-12-21.
 */
public class UserServiceImpl implements UserService {

    public void createUser(User user) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }
            catch (Exception e){}
            finally{
                session.close();
            }
            System.out.println("Successfully created " + user.toString());
            //return user.getUserId();
    }

    public User getById(Integer userId) throws SQLException {
            User user = null;
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                user = (User) session.get(User.class, userId);
                Hibernate.initialize(user);
            }
            catch (Exception e){
                System.err.print(e);
                }
            finally{
                if(session!=null && session.isOpen())
                session.close();
            }
            return user;
    }

    public boolean verifyPassword(String login, String password) throws SQLException {
        System.out.printf("Test passwd");
        return false;
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) throws SQLException {
        System.out.printf("test change");
    }
}
