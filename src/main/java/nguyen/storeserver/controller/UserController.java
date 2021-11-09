package nguyen.storeserver.controller;

import nguyen.storeserver.comon.Const;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping(value = "/hello")
    public String hello(@RequestParam String hello){
        Assert.isTrue(!Const.chuoi.equals(hello), "k duoc rong");
        return hello;
    }

}
