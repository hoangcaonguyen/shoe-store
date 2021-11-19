package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepo extends JpaRepository<Process, Integer> {
    Process getByProcessName(String processName);
}
