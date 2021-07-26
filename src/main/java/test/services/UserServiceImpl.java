package test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.models.AccountEntity;
import test.models.UserEntity;
import test.repositories.UserRepository;
import test.utils.AccountNumberGenerator;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Collection<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        if (userEntity.getAccounts() == null) {
            userEntity.setAccounts(new ArrayList<>());
        }
        if (userEntity.getAccounts().isEmpty()) {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setNumber(AccountNumberGenerator.generate());
            userEntity.getAccounts().add(accountEntity);
        }

        userEntity.getAccounts().forEach(accountEntity -> accountEntity.setUserId(userEntity.getUserId()));

        entityManager.persist(userEntity);
        return userEntity;
    }
}
