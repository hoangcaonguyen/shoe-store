package nguyen.storeserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Purchase_Order")
public class PurchaseOrder {
    @Id
    @Column(name = "code_order")
    private Integer codeOrder;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "id_staff")
    private Integer idStaff;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "purchase_quantity")
    private int purchaseQuantity;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "money")
    private double money;
}
