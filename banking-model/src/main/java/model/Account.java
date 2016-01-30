/**
 * Created by skaraptan on 2015-10-19.
 */
package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Random;

@Entity
@Table (name = "Account")
public class Account {

    @Id
    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "moneyAmount")
    private BigDecimal moneyAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Account(){}
    public Account(BigDecimal moneyAmount, User user) {
        this.accountNumber = createAccountNumber();
        this.moneyAmount = moneyAmount;
        this.user = user;
    }
    public Account(User user) {
        this.accountNumber = createAccountNumber();
        this.moneyAmount = new BigDecimal(0);
        this.user = user;
    }

    public String createAccountNumber(){
            String accountNumber = new String("12 3430 0000 " +
                    (new Random().nextInt(8999)+1000) + " " +
                    (new Random().nextInt(8999)+1000) + " " +
                    (new Random().nextInt(8999)+1000) + " " +
                    (new Random().nextInt(8999)+1000));
            setAccountNumber(accountNumber);
            return getAccountNumber();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }
}
