package test.models;

import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number", nullable = false, length = 12)
    private String number;

    @Column(name = "account_balance", nullable = false, precision = 10, scale = 4)
    private BigDecimal balance;

    @Column(length = 25)
    private String currency;

    @ManyToOne
    @MapsId("userId")
    @JoinColumns({
            @JoinColumn(name = "first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "last_name", referencedColumnName = "last_name")
    })
    private UserEntity user;

    @ManyToOne
    @JoinFormula("(SELECT o.id FROM operations o WHERE o.account_id = id ORDER BY o.datetime DESC LIMIT 1)")
    private OperationEntity operation;

    public AccountEntity() {
    }

    public AccountEntity(UserEntity user, String number, BigDecimal balance, String currency, OperationEntity operation) {
        this.user = user;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
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
}
