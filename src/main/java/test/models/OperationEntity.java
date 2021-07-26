package test.models;

import test.converters.OperationTypeConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Convert(converter = OperationTypeConverter.class)
    private OperationType operationType;

    @Column(name = "datetime", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
