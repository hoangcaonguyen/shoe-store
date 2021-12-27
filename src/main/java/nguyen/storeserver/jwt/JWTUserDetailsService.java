package nguyen.storeserver.jwt;
//
//import nguyen.storeserver.entity.Role;
//import nguyen.storeserver.entity.User;
//import nguyen.storeserver.service.RoleService;
//import nguyen.storeserver.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class JWTUserDetailsService implements UserDetailsService {
//
//	private UserService userService;
//	private RoleService roleService;
//
//	public JWTUserDetailsService(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		try {
//			User user = userService.findUserByUserName(username);
//			Optional<Role> role = roleService.findRoleById(user.getRoleId());
////			return new UserDetails() {}
//			return JWTUserDetailsFactory.create(user, role.get());
//		} catch (Exception e) {
//			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username), e);
//		}
//	}
//}
public class JWTUserDetailsService{

}
