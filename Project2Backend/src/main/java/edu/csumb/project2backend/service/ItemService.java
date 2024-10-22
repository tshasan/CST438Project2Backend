package edu.csumb.project2backend.service;

import edu.csumb.project2backend.entities.Items;
import edu.csumb.project2backend.entities.User;
import edu.csumb.project2backend.repositories.ItemRepo;
import edu.csumb.project2backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private UserRepo userRepo;

    public Items addItem(String itemName, String url, Double price, String description, User user) {
        Items item = new Items();
        item.setName(itemName);
        item.setUrl(url);
        item.setPrice(price);
        item.setDescription(description);
        item.setUser(user);
        return itemRepo.save(item);
    }

    public List<Items> getItemsForUser(User user) {
        return itemRepo.findByUser(user);
    }

    public void deleteItem(Items item) {
        itemRepo.delete(item);
    }
}
