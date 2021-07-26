package test.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;

public class AccountDto {

    private Long id;

    private String number;

    private BigDecimal balance;

    private String currency;

    @JsonBackReference
    private UserDto user;

    @JsonManagedReference
    private OperationDto operation;

    public Long getId() {
        return id;
    }

    public UserDto getUser() {
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

    public void setUser(UserDto user) {
        this.user = user;
    }

    public void setOperation(OperationDto operation) {
        this.operation = operation;
    }
}
