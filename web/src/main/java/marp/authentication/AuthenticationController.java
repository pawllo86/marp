package marp.authentication;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by User on 2016-09-07.
 */
@RestController
public class AuthenticationController {

    @RequestMapping("/user")
    public Principal getUser(Principal user) {
        return user;
    }

}