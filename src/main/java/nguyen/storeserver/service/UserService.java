package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.UserDTO.CreateUsesDTO;
import nguyen.storeserver.entity.User;
import nguyen.storeserver.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User findUserById(Integer id) {
        return userRepo.getById(id);
    }
    public User findUserByFullName(String fullName) {
        return userRepo.getByFullName(fullName);
    }
    public List<User> findUserByGender(String gender) {
        return userRepo.getByGender(gender);
    }
    public List<User> findUserByAddress(String address) {
        return userRepo.getByAddress(address);
    }
    public User findUserByPhoneNumber(String phoneNumber){
        return userRepo.getByPhoneNumber(phoneNumber);
    }
    public User findUserByEmail(String email){
        return userRepo.getByEmail(email);
    }
    public List<User> findUserByRole(String role){
        return userRepo.findByRoles(role);
    }
    public List<User> findUserByStore(String store){
        return userRepo.findByStore(store);
    }
    @Transactional
    public ResponseDTO AddUser(CreateUsesDTO createUsesDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{

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
            return responseDTO;
        }catch (IllegalArgumentException e){
            responseDTO.setCode(1);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }
    }
}
