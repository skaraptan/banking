package serviceImpl;

import DAO.UserService;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        System.out.println("Successfully created " + user.toString() + "    ID:  " + user.getUserId());
    }

    public User getById(Integer userId){
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, userId);
            Hibernate.initialize(user);
        } catch (Exception e) {
            System.err.print(e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user;
    }


    public User getByLogin(String login) throws Exception {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("login", login))
                    .uniqueResult();
            Hibernate.initialize(user);
            System.out.println(user.getLogin());
        } catch (Exception e) {
            System.out.println("Error, user probably doesn't exist");
            System.err.print(e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user;
    }
    public boolean verifyPassword(String login, String password) throws SQLException {
        System.out.printf("Test passwd");
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("login", login))
                    .uniqueResult();
            Hibernate.initialize(user);
            System.out.println(user.getLogin());
        } catch (Exception e) {
            System.out.println("Error, user probably doesn't exist");
            System.err.print(e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        if (user.getPassword().equals(password)) {
            System.out.println("Accessed");
            return true;
        } else {
            System.out.println("Access denied");
            return false;
        }
    }

    public void changePassword(User user, String oldPassword, String newPassword, String confirmPassword) throws SQLException {


            Session session = null;
            try {
                if (newPassword.equals(confirmPassword) && verifyPassword(user.getLogin(), oldPassword)) {
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    user = (User) session.get(User.class, user.getUserId());
                    user.setPassword(newPassword);
                    session.update(user);
                    session.getTransaction().commit();
                    System.out.println("Password changed");
                } else {
                    System.out.println("User with such credentials didn't found. Check input data and try again");
                    throw new Exception("Password change failed!\n");
                }
            }
            catch (Exception e) {
                System.err.print(e);
            } finally {

                if (session != null && session.isOpen())
                    session.close();
            }
        }
        }
