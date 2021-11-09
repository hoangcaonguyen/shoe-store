package nguyen.storeserver.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsesDTO {
    private String UserName;
    private String PassWord;
    private String FullName;
    private enum Gender{Nam,Nu,Other};
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String Role;
    private String Store;
}
