package test.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride( name = "firstName", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride( name = "lastName", column = @Column(name = "last_name", nullable = false))
    })
    private UserId userId;

    @Column(nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "last_name", referencedColumnName = "last_name")
    })
    @OrderBy("account_number ASC, currency DESC")
    private List<AccountEntity> accounts;

    public UserId getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}
