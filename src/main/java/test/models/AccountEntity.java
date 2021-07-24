package test.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

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

    @OneToMany(mappedBy = "account")
    private Set<OperationEntity> operations;

    public AccountEntity() {
    }

    public AccountEntity(UserEntity user, String number, BigDecimal balance, String currency, Set<OperationEntity> operations) {
        this.user = user;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.operations = operations;
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

    public Set<OperationEntity> getOperations() {
        return Collections.unmodifiableSet(operations);
    }
}
