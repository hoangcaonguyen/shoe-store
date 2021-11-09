package nguyen.storeserver.service;

import nguyen.storeserver.entity.Item;
import nguyen.storeserver.repository.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

}
