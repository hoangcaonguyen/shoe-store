package nguyen.storeserver.controller;

import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.StoreDTO;
import nguyen.storeserver.entity.Store;
import nguyen.storeserver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
    private StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }
    @GetMapping
    public List<Store> getAllStore(){
        return storeService.getAllStore();
    }
    @GetMapping(value = "/id")
    public Store findStoreById(@RequestParam Integer storeId){
        return storeService.findStoreById(storeId);
    }
    @GetMapping(value = "/name")
    public Store findStorebyName(@RequestParam String storeName){
        return storeService.findStoreByName(storeName);
    }
    @GetMapping(value = "/address")
    public Store findStoreByAddress(@RequestParam String storeAddress){
        return storeService.findStoreByAddress(storeAddress);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addStore(@RequestBody StoreDTO storeDTO){
        ResponseDTO response = new ResponseDTO();
        response = storeService.AddStore(storeDTO);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteStore(@PathVariable(name = "id")Integer storeId ){
        ResponseDTO response = new ResponseDTO();
        response = storeService.DeleteStore(storeId);
        return response;
    }
}
