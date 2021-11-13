package nguyen.storeserver.repository;

import nguyen.storeserver.entity.Item;
import nguyen.storeserver.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {
    List<PurchaseOrder> getByIdUser (Integer idUser);
    List<PurchaseOrder> getByIdStaff (Integer idStaff);
    List<PurchaseOrder> getByItemId (Integer itemId);
    List<PurchaseOrder> getByStoreId (Integer storeId);
    @Query("select o from PurchaseOrder o where o.storeId in (SELECT storeId FROM Store where storeName =: store)")
    List<Item> getByStore (String Store);
    List<PurchaseOrder> getByStatusId (Integer statusId);
    @Query("select o from PurchaseOrder o where o.statusId in (SELECT statusId FROM Status where statusName =: status)")
    List<Item> getByStatus (String Status);
    PurchaseOrder getByCreateTime (LocalDateTime createTime);
}
