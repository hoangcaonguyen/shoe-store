package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Integer> {
    Status getByStatusName (String statusName);
}
