package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String username);

    User findByEmail(String username);
}
