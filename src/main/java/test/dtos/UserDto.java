package test.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class UserDto {

    private UserIdDto userId;

    private String address;

    @JsonManagedReference
    private List<AccountDto> accounts;

    public UserIdDto getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setUserId(UserIdDto userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
