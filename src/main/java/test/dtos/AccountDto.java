package test.dtos;

import java.math.BigDecimal;
import java.util.Set;

public class AccountDto {

    private Long id;

    private String number;

    private BigDecimal balance;

    private String currency;

    private UserDto user;

    private Set<OperationDto> operations;

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

    public Set<OperationDto> getOperations() {
        return operations;
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

    public void setOperations(Set<OperationDto> operations) {
        this.operations = operations;
    }
}
