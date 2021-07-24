package test.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "firstName", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride( name = "lastName", column = @Column(name = "last_name", nullable = false))
    })
    private UserId userId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(name = "total_sum", nullable = false, precision = 10, scale = 4)
    private BigDecimal totalSum;

    @Column(name = "operation", nullable = false)
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Column(name = "datetime", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    public OperationEntity() {
    }

    public OperationEntity(UserId userId, AccountEntity account, BigDecimal totalSum,
                           OperationType operationType, LocalDateTime dateTime) {
        this.userId = userId;
        this.account = account;
        this.totalSum = totalSum;
        this.operationType = operationType;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
