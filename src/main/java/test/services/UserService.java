package test.services;

import test.models.UserEntity;

import java.util.Collection;

public interface UserService {

    Collection<UserEntity> getUsers();

    UserEntity createUser(UserEntity userEntity);
}
