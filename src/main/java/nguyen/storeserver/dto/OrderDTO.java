package nguyen.storeserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer codeOrder;
    private String user;
    private String staff;
    private Integer itemId;
    private Integer quantity;
    private String store;
    private double money;
    private String process;
}
