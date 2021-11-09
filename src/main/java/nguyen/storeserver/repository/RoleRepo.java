package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role getByRoleName (String roleName);
}
