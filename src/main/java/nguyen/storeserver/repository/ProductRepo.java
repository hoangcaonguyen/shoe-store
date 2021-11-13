package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product getByProductName (String productName);
    List<Product> getByImportPrice(double importPrice);
    List<Product> getByPrice(double price);
    List<Product> getByUpdaterId (Integer updaterId);
    Product getByUpdateTime (LocalDateTime updateTime);
}
