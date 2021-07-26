package test.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;

public class AccountDto {

    private Long id;

    private String number;

    private BigDecimal balance;

    private String currency;

    private UserIdDto userId;

    @JsonManagedReference
    private OperationDto operation;

    public Long getId() {
        return id;
    }

    public UserIdDto getUserId() {
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

    public OperationDto getOperation() {
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

    public void setUserId(UserIdDto userId) {
        this.userId = userId;
    }

    public void setOperation(OperationDto operation) {
        this.operation = operation;
    }
}
