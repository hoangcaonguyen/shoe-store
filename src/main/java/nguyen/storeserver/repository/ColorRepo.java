package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {
    @Query("select i from  Item i where i.status =: status ")
    List<Color> getByStatus(Integer status);
    Color getByColorName(String colorName);
}
