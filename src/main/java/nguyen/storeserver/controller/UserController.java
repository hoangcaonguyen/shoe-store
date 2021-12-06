package nguyen.storeserver.controller;

import nguyen.storeserver.dto.AuthenticationRequestDTO;
import nguyen.storeserver.dto.JWTResponseDTO;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.dto.UserDTO;
import nguyen.storeserver.entity.User;
import nguyen.storeserver.jwt.JWTTokenComponent;
import nguyen.storeserver.jwt.JWTUserDetailsService;
import nguyen.storeserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
    private AuthenticationManager authenticationManager;
    private JWTUserDetailsService jwtUserDetailsService;
    private JWTTokenComponent jwtTokenComponent;
    private BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService, AuthenticationManager authenticationManager,
                          JWTUserDetailsService jwtUserDetailsService,
                          JWTTokenComponent jwtTokenComponent,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenComponent = jwtTokenComponent;
        this.passwordEncoder = passwordEncoder;
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
    public ResponseDTO addUser(@RequestBody UserDTO userDTO) {
        ResponseDTO response = new ResponseDTO();
        encryptPassword(userDTO);
        response = userService.AddUser(userDTO);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable(name = "id") Integer id) {
        ResponseDTO response = new ResponseDTO();
        response = userService.DeleteUser(id);
        return response;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JWTResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO dto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(dto.getUsername());
        String token = jwtTokenComponent.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponseDTO(token));
    }
    private void encryptPassword(UserDTO user) {
        String rawPassword = user.getPassWord();
        if (rawPassword != null) {
            user.setPassWord(passwordEncoder.encode(rawPassword));
        }
    }
}
