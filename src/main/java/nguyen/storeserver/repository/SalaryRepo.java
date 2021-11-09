package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
}
