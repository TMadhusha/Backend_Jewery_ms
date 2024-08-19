package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.InventoryNotFoundException;
import jwl.mis.jewelry_ms.model.Inventory;
import jwl.mis.jewelry_ms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    // Post the values to the database
    @PostMapping("/inventory")
    public Inventory newInventory(@RequestParam("item_id") String item_id,
                                  @RequestParam("itemName") String itemName,
                                  @RequestParam("type") String type,
                                  @RequestParam("actualPrice") double actualPrice,
                                  @RequestParam("description") String description,
                                  @RequestParam("sellingPrice") double sellingPrice,
                                  @RequestParam("availableStock") int availableStock,
                                  @RequestParam("image") MultipartFile image) {

        Inventory newInventory = new Inventory();
        newInventory.setItem_id(item_id);
        newInventory.setItemName(itemName);
        newInventory.setType(type);
        newInventory.setActualPrice(actualPrice);
        newInventory.setDescription(description);
        newInventory.setSellingPrice(sellingPrice);
        newInventory.setAvailableStock(availableStock);
        try {
            if (image != null && !image.isEmpty()) {
                newInventory.setImage(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryRepository.save(newInventory);
    }

    // Get all values from the database
    @GetMapping("/inventory")
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Get values by specific ID
    @GetMapping("/inventory/{item_id}")
    public Inventory getInventoryByItemId(@PathVariable String item_id) {
        return inventoryRepository.findById(item_id)
                .orElseThrow(() -> new InventoryNotFoundException(item_id));
    }

    // Update specific values by using the ID
    @PutMapping("/inventory/{item_id}")
    public Inventory updateInventory(@PathVariable String item_id,
                                     @RequestParam("itemName") String itemName,
                                     @RequestParam("type") String type,
                                     @RequestParam("actualPrice") double actualPrice,
                                     @RequestParam("description") String description,
                                     @RequestParam("sellingPrice") double sellingPrice,
                                     @RequestParam("availableStock") int availableStock,
                                     @RequestParam("image") MultipartFile image) {
        try {
            Inventory existingInventory = inventoryRepository.findById(item_id)
                    .orElseThrow(() -> new InventoryNotFoundException(item_id));

            existingInventory.setItemName(itemName);
            existingInventory.setType(type);
            existingInventory.setActualPrice(actualPrice);
            existingInventory.setDescription(description);
            existingInventory.setSellingPrice(sellingPrice);
            existingInventory.setAvailableStock(availableStock);
            if (image != null && !image.isEmpty()) {
                existingInventory.setImage(image.getBytes());
            }

            return inventoryRepository.save(existingInventory);
        } catch (IOException e) {
            throw new RuntimeException("Failed to update inventory", e);
        }
    }

    // Delete specific ID
    @DeleteMapping("/inventory/{item_id}")
    public String deleteInventory(@PathVariable String item_id) {
        if (!inventoryRepository.existsById(item_id)) {
            throw new InventoryNotFoundException(item_id);
        }
        inventoryRepository.deleteById(item_id);
        return "Product with ID " + item_id + " has been deleted successfully";
    }

    @GetMapping("/inventory/type/{type}")
    List<Inventory> getInventoryByType(@PathVariable String type) {
        return inventoryRepository.findByType(type);
    }

    @GetMapping("/inventory/sellingPrice/{itemId}")
    public Double getSellingPriceByItemId(@PathVariable String itemId) {
        try {
            Long itemIdLong = Long.parseLong(itemId);
            return inventoryRepository.findSellingPriceByItemId(itemIdLong);
        } catch (NumberFormatException e) {
            // Handle the case where itemId is not a valid number
            throw new IllegalArgumentException("Invalid itemId: " + itemId);
        }
    }
}


