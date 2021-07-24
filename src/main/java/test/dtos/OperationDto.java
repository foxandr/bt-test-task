package test.dtos;

import test.models.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperationDto {

    private Long id;

    private UserIdDto userId;

    private AccountDto account;

    private BigDecimal totalSum;

    private OperationType operationType;

    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public UserIdDto getUserId() {
        return userId;
    }

    public AccountDto getAccount() {
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

    public void setUserId(UserIdDto userId) {
        this.userId = userId;
    }

    public void setAccount(AccountDto account) {
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
