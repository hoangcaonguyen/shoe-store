package nguyen.storeserver.repository;

import nguyen.storeserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    List<User> getByFullName (String fullName);
    List<User> getByGender (String gender);
    List<User> getByAddress (String address);
    User getByPhoneNumber (String phoneNumber);
    User getByEmail (String email);
    User findByEmail (String email);
    User findByPhoneNumber (String phoneNumber);
    @Query("select u from User u where u.roleId in (SELECT roleId FROM Role where roleName =: role)")
    List<User> findByRoles (String role);
    @Query("select u from User u where u.storeId in (SELECT storeId FROM Store where storeName =: store)")
    List<User> findByStore (String store);
}
