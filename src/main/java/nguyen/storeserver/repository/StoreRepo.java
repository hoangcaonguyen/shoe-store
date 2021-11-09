package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, Integer> {
    Store getByStoreName (String storeName);
    Store getByStoreAddress (String storeAddress);
}
