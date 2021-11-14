package nguyen.storeserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "store_address")
    private String storeAddress;
    @Column(name = "status")
    private Integer status;
}
