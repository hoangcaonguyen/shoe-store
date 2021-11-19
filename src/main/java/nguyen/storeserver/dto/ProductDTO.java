package nguyen.storeserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer productId;
    private String productName;
    private double importPrice;
    private double Price;
}
