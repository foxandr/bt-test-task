package test.models;

import javax.persistence.*;
import java.util.Collections;
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

    @OneToMany(mappedBy = "user")
    @OrderBy("account_number ASC, currency DESC")
    private List<AccountEntity> accounts;

    public UserEntity() {
    }

    public UserEntity(UserId userId, String address) {
        this.userId = userId;
        this.address = address;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public List<AccountEntity> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}
