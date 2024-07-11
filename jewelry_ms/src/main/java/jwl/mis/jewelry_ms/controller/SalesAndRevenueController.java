package jwl.mis.jewelry_ms.controller;


import jwl.mis.jewelry_ms.model.Inventory;
import jwl.mis.jewelry_ms.model.SalesAndRevenues;
import jwl.mis.jewelry_ms.repository.InventoryRepository;
import jwl.mis.jewelry_ms.repository.SalesAndRevenueRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class SalesAndRevenueController {

    @Autowired
    private SalesAndRevenueRepository salesAndRevenueRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/saveTransaction")
    public String saveTransaction(@RequestBody SalesAndRevenues transaction) {
        try {
            // Set the current date as transaction date
            transaction.setDate(LocalDate.now());

            // Save the transaction
            salesAndRevenueRepository.save(transaction);

            // Update inventory stock
            updateInventoryStock(transaction.getInventory().getItem_id(), transaction.getQty());

            return "Transaction saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to save transaction";
        }
    }

    private void updateInventoryStock(String itemId, Long qty) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(itemId);
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            int availableStock = inventory.getAvailableStock();
            if (availableStock < qty) {
                throw new ResourceNotFoundException("Insufficient stock for item: " + itemId);
            }
            inventory.setAvailableStock(availableStock - qty.intValue());
            inventoryRepository.save(inventory);
        } else {
            throw new ResourceNotFoundException("Inventory item not found with id: " + itemId);
        }
    }

    @GetMapping("/salesAndRevenues")
    public List<SalesAndRevenues> getAllSalesAndRevenues() {
        return salesAndRevenueRepository.findAll();
    }


}