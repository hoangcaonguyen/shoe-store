package nguyen.storeserver.controller;

import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Status;
import nguyen.storeserver.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/status")
public class StatusController {
    private StatusService statusService;
    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    @GetMapping
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }
    @GetMapping(value = "/id")
    public Optional<Status> findStatusById(@RequestParam Integer statusId) {
        return statusService.findStatusById(statusId);
    }
    @GetMapping(value = "/name")
    public Status findStatusByName(@RequestParam String statusName) {
        return statusService.findStatusByName(statusName);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addStatus(@RequestBody String statusName){
        ResponseDTO response = new ResponseDTO();
        response = statusService.AddStatus(statusName);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO DeleteStatus(@PathVariable(name = "id")Integer statusId){
        ResponseDTO response = new ResponseDTO();
        response = statusService.DeleteStatus(statusId);
        return response;
    }
}
