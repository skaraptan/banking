package DAO; /**
 * Created by skaraptan on 2015-11-10.
 */
import model.User;

public interface UserService {

        void createUser(User user) throws Exception;
        User getById(Integer userId)throws Exception;
        boolean verifyPassword(String login, String password) throws Exception;
        void changePassword(User user, String oldPassword, String newPassword, String confirmPassword) throws Exception;



}
