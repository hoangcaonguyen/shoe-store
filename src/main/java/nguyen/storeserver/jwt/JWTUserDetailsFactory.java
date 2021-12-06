package nguyen.storeserver.jwt;

import nguyen.storeserver.entity.Role;
import nguyen.storeserver.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public final class JWTUserDetailsFactory {

    private JWTUserDetailsFactory() {
    }

    public static JWTUserDetails create(User user, Role role) {
        return new JWTUserDetails(
                user.getId(),
                user.getUserName(),
                user.getPassWord(),
                user.getEmail(),
                mapToGrantedAuthorities(role),
                user.getStatus() == 1 ? true : false
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }
}
