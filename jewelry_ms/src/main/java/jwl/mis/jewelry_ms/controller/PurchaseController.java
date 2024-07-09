package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.ExpenseNotFoundException;
import jwl.mis.jewelry_ms.exception.PurchaseNotFoundException;
import jwl.mis.jewelry_ms.model.Inventory;
import jwl.mis.jewelry_ms.model.Purchase;
import jwl.mis.jewelry_ms.model.Supplier;
import jwl.mis.jewelry_ms.repository.InventoryRepository;
import jwl.mis.jewelry_ms.repository.PurchaseRepository;
import jwl.mis.jewelry_ms.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @PostMapping("/addPurchase")
    Purchase newPurchase(@RequestParam (value = "receipt", required = false) MultipartFile receipt,
                         @RequestParam ("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                         @RequestParam ("item_id") String item_id,
                         @RequestParam ("sup_id") Long sup_id,
                         @RequestParam ("description") String description,
                         @RequestParam ("unitPrice") double unitPrice,
                         @RequestParam ("tax") double tax,
                         @RequestParam ("quantity") int quantity,
                         @RequestParam ("cost") double cost){
        Purchase newPurchase=new Purchase();
        newPurchase.setDate(date);

        // Fetch Inventory and Supplier
        Optional<Inventory> inventory = inventoryRepository.findById(item_id);
        Optional<Supplier> supplier = supplierRepository.findById(sup_id);

        // Check if Inventory exists
        if (inventory.isPresent()) {
            newPurchase.setInventory(inventory.get());
        } else {
            throw new IllegalArgumentException("Invalid item_id: " + item_id);
        }

        // Check if Supplier exists
        if (supplier.isPresent()) {
            newPurchase.setSupplier(supplier.get());
        } else {
            throw new IllegalArgumentException("Invalid sup_id: " + sup_id);
        }

        newPurchase.setDescription(description);
        newPurchase.setUnitPrice(unitPrice);
        newPurchase.setTax(tax);
        newPurchase.setQuantity(quantity);
        newPurchase.setCost(cost);
        if (receipt != null) {
            try {
                newPurchase.setReceipt(receipt.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return purchaseRepository.save(newPurchase);
    }

    @GetMapping("/getPurchase")
    List<Purchase> getAllPurchase(){
        return purchaseRepository.findAll();
    }

    @GetMapping("/getPurchaseById/{purchaseId}")
    Purchase getById(@PathVariable Long purchaseId){
        return purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new PurchaseNotFoundException(purchaseId));
    }

    @PutMapping("/updatePurchaseById/{purchaseId}")
    Purchase updatePurchase(@RequestParam(value = "receipt", required = false) MultipartFile receipt,
                            @RequestParam ("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                            @RequestParam ("item_id") String item_id,
                            @RequestParam ("sup_id") Long sup_id,
                            @RequestParam ("description") String description,
                            @RequestParam ("unitPrice") double unitPrice,
                            @RequestParam ("tax") double tax,
                            @RequestParam ("quantity") int quantity,
                            @RequestParam ("cost") double cost,
                            @PathVariable Long purchaseId){
        Purchase existingPurchase=purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new PurchaseNotFoundException(purchaseId));

        existingPurchase.setDate(date);
        // Fetch Inventory and Supplier
        Optional<Inventory> inventory = inventoryRepository.findById(item_id);
        Optional<Supplier> supplier = supplierRepository.findById(sup_id);

        // Check if Inventory exists
        if (inventory.isPresent()) {
            existingPurchase.setInventory(inventory.get());
        } else {
            throw new IllegalArgumentException("Invalid item_id: " + item_id);
        }

        // Check if Supplier exists
        if (supplier.isPresent()) {
            existingPurchase.setSupplier(supplier.get());
        } else {
            throw new IllegalArgumentException("Invalid sup_id: " + sup_id);
        }

        existingPurchase.setDescription(description);
        existingPurchase.setUnitPrice(unitPrice);
        existingPurchase.setTax(tax);
        existingPurchase.setQuantity(quantity);
        existingPurchase.setCost(cost);
        if (receipt != null) {
            try {
                existingPurchase.setReceipt(receipt.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return purchaseRepository.save(existingPurchase);

    }

    @DeleteMapping("/deletePurchase/{purchaseId}")
    String deletePurchase(@PathVariable Long purchaseId){
        if(!purchaseRepository.existsById(purchaseId)){
            throw new PurchaseNotFoundException(purchaseId);
        }
        purchaseRepository.deleteById(purchaseId);
        return "Purchase with id "+ purchaseId +" has been deleted sucessfully";
    }

}
