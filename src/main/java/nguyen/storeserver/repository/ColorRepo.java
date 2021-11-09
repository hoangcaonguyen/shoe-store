package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {
    Color getByColorName(String colorName);
}
