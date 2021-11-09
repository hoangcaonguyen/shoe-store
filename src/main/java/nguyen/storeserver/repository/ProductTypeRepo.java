package nguyen.storeserver.repository;

import nguyen.storeserver.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType, Integer> {
    ProductType getByTypeName(String typeName);
}
