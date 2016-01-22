package net.xuele.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * zhihuan.cai 新建于 2015/8/3 0003.
 */
public class XuleleGrantedAuthority implements GrantedAuthority {


    private static final long serialVersionUID = 2309884202254678984L;

    private String role;

    public XuleleGrantedAuthority() {

    }

    public XuleleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XuleleGrantedAuthority) {
            return role.equals(((XuleleGrantedAuthority) obj).role);
        }
        return false;
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }
}
