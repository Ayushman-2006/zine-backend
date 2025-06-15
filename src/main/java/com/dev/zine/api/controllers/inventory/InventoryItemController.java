package com.dev.zine.api.controllers.inventory;

import com.dev.zine.model.InventoryItems;
import com.dev.zine.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

    @Autowired
    private InventoryItemService inventoryService;

    @GetMapping
    public ResponseEntity<?> getAllItems() {
        try {
            List<InventoryItems> items = inventoryService.getAllItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch items: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        try {
            Optional<InventoryItems> item = inventoryService.getItemById(id);
            if (item.isPresent()) {
                return ResponseEntity.ok(item.get());
            } else {
                return ResponseEntity.status(404).body("Item not found with ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch item: " + e.getMessage());
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getItemByCategory(@PathVariable String category) {
        try {
            List<InventoryItems> items = inventoryService.getItemByCategory(category);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch items by category: " + e.getMessage());
        }
    }

    @PostMapping("/item")
    public ResponseEntity<?> addItem(@RequestBody InventoryItems inventory) {
        try {
            InventoryItems saved = inventoryService.addItem(inventory);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to add item: " + e.getMessage());
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody InventoryItems inventory) {
        try {
            InventoryItems updated = inventoryService.updateItem(id, inventory);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to update item: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            inventoryService.deleteItem(id);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete item: " + e.getMessage());
        }
    }
}
