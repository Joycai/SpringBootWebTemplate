package joycai.springboot.sample.db.repository;

import joycai.springboot.sample.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
