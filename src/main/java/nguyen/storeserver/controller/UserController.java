package nguyen.storeserver.controller;

import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.UserDTO.CreateUsesDTO;
import nguyen.storeserver.entity.User;
import nguyen.storeserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/id")
    public Optional<User> findUserById(@RequestParam Integer id) {
        return userService.findUserById(id);
    }
    @GetMapping(value = "/name")
    public List<User> findUserByName(@RequestParam String fullName) {
        return userService.findUserByFullName(fullName);
    }
    @GetMapping(value = "/gender")
    public List<User> findUserByGender(@RequestParam String gender) {
        return userService.findUserByGender(gender);
    }
    @GetMapping(value = "/address")
    public List<User> findUserByAddress(@RequestParam String address) {
        return userService.findUserByAddress(address);
    }
    @GetMapping(value = "/phonenumber")
    public User findUserByPhoneNumber(@RequestParam String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }
    @GetMapping(value = "/email")
    public User findUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }
    @GetMapping(value = "/role")
    public List<User> findUserByRole(@RequestParam String role) {
        return userService.findUserByRole(role);
    }
    @GetMapping(value = "/store")
    public List<User> findUserByStore(@RequestParam String store) {
        return userService.findUserByStore(store);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addUser(@RequestBody CreateUsesDTO createUsesDTO) {
        ResponseDTO response = new ResponseDTO();
        response = userService.AddUser(createUsesDTO);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable(name = "id") Integer id) {
        ResponseDTO response = new ResponseDTO();
        response = userService.DeleteUser(id);
        return response;
    }
}
