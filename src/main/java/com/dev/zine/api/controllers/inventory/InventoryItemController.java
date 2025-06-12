package com.dev.zine.api.controllers.inventory;


import com.dev.zine.model.InventoryItems;
import com.dev.zine.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

    @Autowired
    public InventoryItemService inventoryService;

    @GetMapping
    public List<InventoryItems> getAllItems(){
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<InventoryItems> getItemById(@PathVariable Long id) {
        return inventoryService.getItemById(id);
    }

    @GetMapping("/category/{category}")
    public List<InventoryItems> getItemByCategory(@PathVariable String category){
        return inventoryService.getItemByCategory(category);
    }

    @PostMapping("/item")
    public InventoryItems addItem(@RequestBody InventoryItems inventory) {
        return inventoryService.addItem(inventory);
    }

    @PutMapping("/item/{id}")
    public InventoryItems updateItem(@PathVariable Long id,@RequestBody InventoryItems inventory) {
        return inventoryService.updateItem(id,inventory);
    }



    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
    }








}
