package com.csit321g2.galo_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g2.galo_crud.entity.ItemEntity;
import com.csit321g2.galo_crud.service.ItemService;

@RestController
@RequestMapping("/item/api")
public class ItemController {
    
    @Autowired 
    ItemService iserv;    

    public ItemController() {
       
    }

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Hello, Rey";
    }

    @PostMapping("/postNewItem")
    public ItemEntity postItem(@RequestBody ItemEntity Item) {
        return iserv.postItem(Item);
    }

    @GetMapping("/getAllItems")
    public List<ItemEntity> getAllItems() {
        return iserv.getAllItems();
    }

    @PutMapping("/putItem")
    public ItemEntity putItem(@RequestParam("id") int id, @RequestBody ItemEntity newItemDetails) {
        return iserv.putItem(id, newItemDetails);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        return iserv.deleteItem(id);
    }

}
