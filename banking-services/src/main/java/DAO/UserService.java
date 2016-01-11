package DAO; /**
 * Created by skaraptan on 2015-11-10.
 */
import model.User;

import java.sql.SQLException;

public interface UserService {

        void createUser(User user) throws SQLException;
        User getById(Integer userId)throws SQLException;
        boolean verifyPassword(String login, String password) throws SQLException;
        void changePassword(User user, String oldPassword, String newPassword, String confirmPassword) throws SQLException;



}
