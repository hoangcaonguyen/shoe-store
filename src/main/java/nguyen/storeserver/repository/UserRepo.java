package nguyen.storeserver.repository;

import nguyen.storeserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User getByFullName (String fullName);
    List<User> getByGender (String gender);
    List<User> getByAddress (String address);
    User getByPhoneNumber (String phoneNumber);
    User getByEmail (String email);
    @Query("")
    List<User> findByRoles (String role);
    @Query("")
    List<User> findByStore (String store);
}
