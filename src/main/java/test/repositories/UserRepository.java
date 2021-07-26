package test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.models.UserEntity;
import test.models.UserId;

public interface UserRepository extends JpaRepository<UserEntity, UserId> {
}
