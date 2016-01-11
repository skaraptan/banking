
package model; /**
 * Created by skaraptan on 2015-10-19.
 */

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="Operation")
public class Operation {

    @Id  @GeneratedValue
    @Column( name = "operationId")
    private Long operationId;

    @Column( name = "amount")
    private BigDecimal amount;

    @Column( name = "isPayment")
    private Boolean isPayment;

    @Column(name = "date")
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_account_number", referencedColumnName = "accountNumber")
    private Account account;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "target_account_number", referencedColumnName = "accountNumber")
    private Account targetAccount;

    public Operation(){}

    public Operation(Long operationId, BigDecimal amount, Boolean isPayment, Date date, Account account, Account targetAccount){
        this.operationId = operationId;
        this.amount = amount;
        this.isPayment = isPayment;
        this.date = date;
        this.account = account;
        this.targetAccount = targetAccount;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setType(Boolean isPayment){
        this.isPayment = isPayment;
    }
    public Boolean getType(){
        return isPayment;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
    public void setOperationId(Long operationId){
        this.operationId = operationId;
    }
    public Long getOperationId(){
        return operationId;
    }
    public void setTargetAccount(Account targetAccount){
        this.targetAccount = targetAccount;
    }
    public Account getTargetAccount(){
        return targetAccount;
    }
}
