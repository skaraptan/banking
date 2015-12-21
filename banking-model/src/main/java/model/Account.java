/**
 * Created by skaraptan on 2015-10-19.
 */
package model;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Account(String accountNumber, BigDecimal moneyAmount, User user) {
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
        this.user = user;
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
