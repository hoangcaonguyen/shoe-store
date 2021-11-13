package nguyen.storeserver.controller;

import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.ProductType;
import nguyen.storeserver.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/producttype")
public class ProductTypeController {
    private ProductTypeService productTypeService;
    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }
    @GetMapping(value = "/id")
    public Optional<ProductType> findProductTypeById(@RequestParam Integer typeId) {
        return productTypeService.findProductTypeById(typeId);
    }
    @GetMapping(value = "/name")
    public ProductType findProductTypeByName(@RequestParam String typeName) {
        return productTypeService.findProductTypeByName(typeName);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addProductType(@RequestBody String typeName){
        ResponseDTO response = new ResponseDTO();
        response = productTypeService.AddProductType(typeName);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteProductType(@PathVariable(name = "id")Integer typeId){
        ResponseDTO response = new ResponseDTO();
        response = productTypeService.DeleteProductType(typeId);
        return response;
    }
}
