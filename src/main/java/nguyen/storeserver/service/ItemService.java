package nguyen.storeserver.service;

import nguyen.storeserver.entity.Item;
import nguyen.storeserver.repository.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
    public Optional<Item> findById(Integer itemId) {
        return itemRepo.findById(itemId);
    }
    public List<Item> findByProductName(String productName) {
        return itemRepo.getByProductName(productName);
    }
    public List<Item> findByColorName(String colorName) {
        return itemRepo.getByColorName(colorName);
    }
    public List<Item> findBySize(Integer size) {
        return itemRepo.getBySize(size);
    }
    public List<Item> findByNumItems(Integer numItems) {
        return itemRepo.getByNumItems(numItems);
    }
    public List<Item> findByType(String type) {
        return itemRepo.getByType(type);
    }
    public List<Item> findByStore(String store) {
        return itemRepo.getByStore(store);
    }
    public List<Item> findBySale(Integer sale) {
        return itemRepo.getBySale(sale);
    }
    //@Transactional
    //    public ResponseDTO AddItem (String colorName){
    //        ResponseDTO responseDTO = new ResponseDTO();
    //        .Color color = colorRepo.getByColorName(colorName);
    //        Assert.isNull(color, MessageUtils.getMessage("error.notfound",colorName));
    //        colorRepo.save(color);
    //        return responseDTO;
    //    }
    //    @Transactional
    //    public ResponseDTO DeleteColor(Integer colorId) {
    //        ResponseDTO responseDTO = new ResponseDTO();
    //        Color color = colorRepo.getById(colorId);
    //        Assert.notNull(color, MessageUtils.getMessage("error.notfound",colorId));
    //        List<Item> items = itemRepo.getByColorId(colorId);
    //        for(Item i : items){
    //            i.setColorId(1);
    //            itemRepo.update(i);
    //        }
    //        colorRepo.delete(color);
    //        return responseDTO;
    //    }
}
