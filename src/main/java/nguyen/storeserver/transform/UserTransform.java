package nguyen.storeserver.transform;

import nguyen.storeserver.dto.UserDTO;
import nguyen.storeserver.entity.User;
import nguyen.storeserver.service.RoleService;
import nguyen.storeserver.service.StoreService;

import java.text.DateFormat;
import java.text.ParseException;

public class UserTransform {

	private DateFormat dateFormat;
	private RoleService roleService;
	private StoreService storeService;

	public UserTransform(DateFormat dateFormat, RoleService roleService, StoreService storeService) {
		this.dateFormat = dateFormat;
		this.roleService = roleService;
		this.storeService = storeService;
	}

	public User apply(UserDTO dto) throws ParseException {
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setPassWord(dto.getPassWord());
		user.setFullName(dto.getFullName());
		user.setStatus(1);
		user.setGender(dto.getGender());
		user.setAddress(dto.getAddress());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setEmail(dto.getEmail());
		user.setRoleId(roleService.findRoleByName(dto.getRole()).getRoleId());
		user.setStoreId(storeService.findStoreByName(dto.getStore()).getStoreId());
		return user;
	}

	public UserDTO apply(User user) {
		UserDTO dto = new UserDTO();
		dto.setUserName(user.getUserName());
		dto.setPassWord(user.getPassWord());
		dto.setFullName(user.getFullName());
		dto.setGender(user.getGender());
		dto.setAddress(user.getAddress());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setEmail(user.getEmail());
		dto.setRole(roleService.findRoleById(user.getRoleId()).get().getRoleName());
		dto.setStore(storeService.findStoreById(user.getStoreId()).get().getStoreName());
		dto.setStatus(user.getStatus());
		return dto;
	}
}
