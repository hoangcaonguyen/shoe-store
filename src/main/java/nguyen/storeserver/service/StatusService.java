package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Color;
import nguyen.storeserver.entity.Status;
import nguyen.storeserver.repository.StatusRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepo statusRepo;

    public StatusService(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }
    public List<Status> getAllStatus() {
        return statusRepo.findAll();
    }
    public Status findStatusById(Integer statusId) {
        return statusRepo.getById(statusId);
    }
    public Status findStatusByName(String statusName){
        return statusRepo.getByStatusName(statusName);
    }
    @Transactional
    public ResponseDTO AddStatus(String statusName){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Status status = statusRepo.getByStatusName(statusName);
            Assert.isNull(status, MessageUtils.getMessage("error.notfound",statusName));
            statusRepo.save(status);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
    @Transactional
    public ResponseDTO DeleteStatus(Integer statusId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Status status = statusRepo.getById(statusId);
            Assert.notNull(status, MessageUtils.getMessage("error.notfound",statusId));
            statusRepo.delete(status);
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
}
