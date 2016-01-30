package model;

import javax.persistence.*;

/**
 * Created by skaraptan on 2015-10-19.
 */

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Integer userId;

    @Column(name="name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    //@OneToMany(mappedBy = ".user_id")
   // private Set<Account> accounts;


    public User(){}
    public User(Integer userId, String name, String lastName, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

  /*  public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
    */
}
