package net.xuele.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * 权限验证投票管理器
 * zhihuan.cai 新建于 2015/7/15 0015.
 */
public class XueleAccessDecisionManager implements AccessDecisionManager {

    private static final Logger logger = LoggerFactory.getLogger(XueleAccessDecisionManager.class);

    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        logger.debug(object.toString());
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ca.getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限访问");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}