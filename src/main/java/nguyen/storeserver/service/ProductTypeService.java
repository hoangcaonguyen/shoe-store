package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Color;
import nguyen.storeserver.entity.ProductType;
import nguyen.storeserver.repository.ProductTypeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeRepo productTypeRepo;

    public ProductTypeService(ProductTypeRepo productTypeRepo) {
        this.productTypeRepo = productTypeRepo;
    }
    public List<ProductType> getAllProductTypes() {
        return productTypeRepo.findAll();
    }
    public ProductType findProductTypeById(Integer typeId) {
        return productTypeRepo.getById(typeId);
    }
    public ProductType findProductTypeByName(String typeName) {
        return productTypeRepo.getByTypeName(typeName);
    }
    @Transactional
    public ResponseDTO AddProductType(String typeName){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            ProductType productType = productTypeRepo.getByTypeName(typeName);
            Assert.isNull(productType, MessageUtils.getMessage("error.notfound",typeName));
            productTypeRepo.save(productType);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
    @Transactional
    public ResponseDTO DeleteProductType(Integer typeId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            ProductType productType = productTypeRepo.getById(typeId);
            Assert.notNull(productType, MessageUtils.getMessage("error.notfound",typeId));
            productTypeRepo.delete(productType);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
}
