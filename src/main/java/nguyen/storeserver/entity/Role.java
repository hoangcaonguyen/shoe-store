package nguyen.storeserver.entity;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Role")
public class Role /*implements GrantedAuthority*/ {
    @Id
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;

//    @Override
//    public String getAuthority() {
//        return null;
//    }
}
