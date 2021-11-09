package nguyen.storeserver.repository;

import nguyen.storeserver.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {
}
