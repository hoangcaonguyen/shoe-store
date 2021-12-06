package nguyen.storeserver.service;

import nguyen.storeserver.common.DataUtils;
import nguyen.storeserver.common.MessageUtils;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.UserDTO;
import nguyen.storeserver.entity.Role;
import nguyen.storeserver.entity.Store;
import nguyen.storeserver.entity.User;
import nguyen.storeserver.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final RoleService roleService;
    private final StoreService storeService;
    private final TimeKeepingService TimeKeepingService;
    private final PurchaseOrderService purchaseOrderService;
    private final SalaryService salaryService;


    public UserService(UserRepo userRepo, RoleService roleService, StoreService storeService, nguyen.storeserver.service.TimeKeepingService timeKeepingService, PurchaseOrderService purchaseOrderService, SalaryService salaryService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
        this.storeService = storeService;
        TimeKeepingService = timeKeepingService;
        this.purchaseOrderService = purchaseOrderService;
        this.salaryService = salaryService;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public Optional<User> findUserById(Integer id) {
        return userRepo.findById(id);
    }
    public User findUserByUserName(String userName) {return userRepo.findByUserName(userName);}
    public List<User> findUserByFullName(String fullName) {
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
    public ResponseDTO AddUser(UserDTO userDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        User user = new User();
        Assert.isTrue(DataUtils.notNullOrEmpty((Collection) userDTO), MessageUtils.getMessage("error.input.null", userDTO));
        Role role = roleService.findRoleByName(userDTO.getRole());
        Assert.notNull(role, MessageUtils.getMessage("error.notfound", userDTO.getRole()));
        user.setRoleId(role.getRoleId());
        Store store = storeService.findStoreByName(userDTO.getStore());
        Assert.notNull(store, MessageUtils.getMessage("error.notfound", userDTO.getStore()));
        user.setStoreId(store.getStoreId());
        Assert.notNull(role, MessageUtils.getMessage("error.notfound", userDTO.getRole()));
        User user1 = userRepo.findByUserName(userDTO.getUserName());
        Assert.isNull(user1, MessageUtils.getMessage("username.not.valid", userDTO.getUserName()));
        user1 = userRepo.findByEmail(userDTO.getEmail());
        Assert.isNull(user1, MessageUtils.getMessage("success.found ", userDTO.getEmail()));
        user1 = userRepo.findByPhoneNumber(userDTO.getPhoneNumber());
        Assert.isNull(user1, MessageUtils.getMessage("success.found ", userDTO.getPhoneNumber()));
        user.setUserName(userDTO.getUserName());
        user.setPassWord(userDTO.getPassWord());
        user.setFullName(userDTO.getFullName());
        user.setGender(userDTO.getGender());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        userRepo.save(user);
        return responseDTO;
    }
    @Transactional
    public ResponseDTO DeleteUser(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepo.getById(id);
        Assert.notNull(user, MessageUtils.getMessage("error.notfound",id));
        user.setStatus(0);
        userRepo.save(user);
        return responseDTO;
    }
}
