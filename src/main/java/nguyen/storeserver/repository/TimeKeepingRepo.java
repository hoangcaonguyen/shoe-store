package nguyen.storeserver.repository;

import nguyen.storeserver.entity.TimeKeeping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeKeepingRepo extends JpaRepository<TimeKeeping, Integer> {
}
