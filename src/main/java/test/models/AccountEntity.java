package test.models;

import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    private static final String DEFAULT_CURRENCY = "USD";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, length = 12)
    private String number;

    @Column(name = "account_balance", precision = 10, scale = 4)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(length = 25)
    private String currency = DEFAULT_CURRENCY;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "firstName", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride( name = "lastName", column = @Column(name = "last_name", nullable = false))
    })
    private UserId userId;

    @ManyToOne
    @JoinFormula("(SELECT o.id FROM operations o WHERE o.account_id = id ORDER BY o.datetime DESC LIMIT 1)")
    private OperationEntity operation;

    public Long getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public OperationEntity getOperation() {
        return operation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void setOperation(OperationEntity operation) {
        this.operation = operation;
    }
}
