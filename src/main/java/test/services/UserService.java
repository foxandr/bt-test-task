package test.services;

import test.models.UserEntity;
import test.models.UserId;

import java.util.Collection;

public interface UserService {

    Collection<UserEntity> getUsers();

    UserEntity createUser(UserEntity userEntity);

    void deleteUser(UserId userId);
}
