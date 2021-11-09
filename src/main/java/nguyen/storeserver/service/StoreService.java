package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.StoreDTO;
import nguyen.storeserver.entity.Store;
import nguyen.storeserver.repository.StoreRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public List<Store> getAllStore() {
        return storeRepo.findAll();
    }
    public Store findStoreById(Integer storeId) {
        return storeRepo.getById(storeId);
    }
    public Store findStoreByName(String storeName){
        return storeRepo.getByStoreName(storeName);
    }
    public Store findStoreByAddress(String storeAddress){
        return storeRepo.getByStoreAddress(storeAddress);
    }
    @Transactional
    public ResponseDTO AddStore(StoreDTO storeDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Store store = storeRepo.getByStoreName(storeDTO.getStoreName());
            Assert.isNull(store, MessageUtils.getMessage("error.notfound",storeDTO.getStoreName()));
            storeRepo.save(store);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
    @Transactional
    public ResponseDTO DeleteStore(Integer storeId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Store store = storeRepo.getById(storeId);
            Assert.notNull(store, MessageUtils.getMessage("error.notfound",storeId));
            storeRepo.delete(store);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
}
