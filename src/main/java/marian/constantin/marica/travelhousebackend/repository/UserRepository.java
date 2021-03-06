package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String username);

    boolean existsByEmail(String username);

    @Modifying
    @Query("update User u set u.phoneNumber = :phoneNumber where u.email = :email")
    void updatePhoneNumber(String email, String phoneNumber);

    @Modifying
    @Query("update User u set u.password = :password where u.email = :email")
    void changePassword(String email, String password);
}
