package jwl.mis.jewelry_ms.repository;

import jakarta.transaction.Transactional;
import jwl.mis.jewelry_ms.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,String> {
    List<Inventory> findByType(String type);


    // Example repository method signature
    @Query("SELECT i.sellingPrice FROM Inventory i WHERE i.item_id = :itemId")
    Double findSellingPriceByItemId(@Param("itemId") Long itemId);

    @Modifying
    @Transactional
    @Query("UPDATE Inventory i SET i.availableStock = i.availableStock - :qty WHERE i.item_id = :itemId")
    void reduceStock(@Param("itemId") String itemId, @Param("qty") Long qty);

}
