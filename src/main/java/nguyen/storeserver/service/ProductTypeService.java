package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Item;
import nguyen.storeserver.entity.ProductType;
import nguyen.storeserver.repository.ItemRepo;
import nguyen.storeserver.repository.ProductTypeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {
    private final ProductTypeRepo productTypeRepo;
    private final ItemRepo itemRepo;

    public ProductTypeService(ProductTypeRepo productTypeRepo, ItemRepo itemRepo) {
        this.productTypeRepo = productTypeRepo;
        this.itemRepo = itemRepo;
    }
    public List<ProductType> getAllProductTypes() {
        return productTypeRepo.findAll();
    }
    public Optional<ProductType> findProductTypeById(Integer typeId) {
        return productTypeRepo.findById(typeId);
    }
    public ProductType findProductTypeByName(String typeName) {
        return productTypeRepo.getByTypeName(typeName);
    }
    @Transactional
    public ResponseDTO AddProductType(String typeName){
        ResponseDTO responseDTO = new ResponseDTO();
        ProductType productType = productTypeRepo.getByTypeName(typeName);
        Assert.isNull(productType, MessageUtils.getMessage("error.notfound",typeName));
        productTypeRepo.save(productType);
        return responseDTO;
    }
    @Transactional
    public ResponseDTO DeleteProductType(Integer typeId) {
        ResponseDTO responseDTO = new ResponseDTO();
        ProductType productType = productTypeRepo.getById(typeId);
        Assert.notNull(productType, MessageUtils.getMessage("error.notfound",typeId));
        List<Item> items = itemRepo.getByTypeId(typeId);
        for(Item i : items){
            i.setStatus(0);
            itemRepo.save(i);
        }
        productTypeRepo.delete(productType);
        return responseDTO;
    }
}
