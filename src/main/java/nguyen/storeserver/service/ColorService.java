package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Color;
import nguyen.storeserver.repository.ColorRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepo colorRepo;

    public ColorService(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }
    public List<Color> getAllColors() {
        return colorRepo.findAll();
    }
    public Color findColorById(Integer colorId) {
        return colorRepo.getById(colorId);
    }
    public Color findColorByName(String colorName){
        return colorRepo.getByColorName(colorName);
    }
    @Transactional
    public ResponseDTO AddColor(String colorName){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Color color = colorRepo.getByColorName(colorName);
            Assert.isNull(color, MessageUtils.getMessage("error.notfound",colorName));
            colorRepo.save(color);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
    @Transactional
    public ResponseDTO DeleteColor(Integer colorId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Color color = colorRepo.getById(colorId);
            Assert.notNull(color, MessageUtils.getMessage("error.notfound",colorId));
            colorRepo.delete(color);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
}
