package net.xuele.common.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Administrator on 2015/6/18 0018.
 */
public class SessionUtil {
    public static UserSession getUserSession() {
        UserSession userDetails = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new AuthenticationCredentialsNotFoundException("");
        }
        userDetails = (UserSession) auth.getPrincipal();
        return userDetails;
    }
}
