package net.xuele.common.security;

import net.xuele.common.dto.ClassInfoDTO;
import net.xuele.common.dto.MenuNode;
import net.xuele.common.dto.RelativeDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * zhihuan.cai 新建于 2015/6/8 0008.
 */
public class UserSession implements Serializable, UserDetails {


    private static final long serialVersionUID = 6209268240636531085L;

    //~ Instance fields ================================================================================================
    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    //  can't edit


    /**
     * 用户ID
     */
    private String userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 头像
     */
    private String icon;
    /**
     * 用户状态,[0,离校;1,有效;2,未初始化;]
     */
    private Integer status;
    /**
     * 身份类型,引用d_identity
     */
    private String identityId;

    /**
     * 身份描述:用于切换视图.
     */
    private String identityDescription;

    /**
     * 资金账号ID
     */
    private String accountId;

    /**
     * 所属班级id
     */
    private String classId;

    /**
     * 所属学校名称
     */
    private String schoolName;

    /**
     * 主授课本
     */
    private String bookId;
    /**
     * 主授课本
     */
    private String bookName;
    /**
     * 主授科目Id
     */
    private String subjectId;
    /**
     * 学校职务ID（引用m_position字典)
     */
    private String positionId;

    /**
     * 学校职务名称
     */
    private String positionName;
    /**
     * 地区编号
     */
    private String area;
    /**
     * 地区编号名称
     */
    private String areaName;
    /**
     * 老师授课班级
     */
    private List<ClassInfoDTO> teacherClass;
    /**
     * 一级和二级菜单资源
     */
    private List<MenuNode> resource;

    private Menu menu;
    /**
     * 相关角色
     */
    private List<RelativeDTO> roles;

    /**
     * 年级 1,2
     */
    private Integer gradeNum;
    /**
     * 学期 1,2
     */
    private Integer semester;
    /**
     * 根据学校的学制学段信息和教书主授科目判断
     * 1：小学语数英(可以布置同步课堂)；2：初中数理化（可以布置提分宝）；3：其他
     */
    private Integer teacherPeriodType;

    /**
     * 所属教育机构ID
     */
    private String educationalId;

    /**
     * 所属教育机构
     */
    private String educationalName;
    /**
     * 教辅id
     */
    private String extraBookId;

    public String getExtraBookId() {
        return extraBookId;
    }

    public void setExtraBookId(String extraBookId) {
        this.extraBookId = extraBookId;
    }

    public String getEducationalId() {
        return educationalId;
    }

    public void setEducationalId(String educationalId) {
        this.educationalId = educationalId;
    }

    public String getEducationalName() {
        return educationalName;
    }

    public void setEducationalName(String educationalName) {
        this.educationalName = educationalName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTeacherPeriodType() {
        return teacherPeriodType;
    }

    public void setTeacherPeriodType(Integer teacherPeriodType) {
        this.teacherPeriodType = teacherPeriodType;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public List<RelativeDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RelativeDTO> roles) {
        this.roles = roles;
    }

    //~ Constructors ===================================================================================================

    public UserSession() {

    }

    public UserSession(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }


    public UserSession(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }


    // static method ------------------------
    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities =
                new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

    // equals  hashCode and toString

    /**
     * Returns {@code true} if the supplied object is a {@code User} instance with the
     * same {@code username} value.
     * <p/>
     * In other words, the objects are equal if they have the same username, representing the
     * same principal.
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof UserSession) {
            return username.equals(((UserSession) rhs).username);
        }
        return false;
    }

    /**
     * Returns the hashcode of the {@code username}.
     */
    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Username: ").append(this.username).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Enabled: ").append(this.enabled).append("; ");
        sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");

        if (!authorities.isEmpty()) {
            sb.append("Granted Authorities: ");

            boolean first = true;
            for (GrantedAuthority auth : authorities) {
                if (!first) {
                    sb.append(",");
                }
                first = false;

                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }

    //get and sets--------------

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void eraseCredentials() {
        password = null;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getIdentityDescription() {
        return identityDescription;
    }

    public void setIdentityDescription(String identityDescription) {
        this.identityDescription = identityDescription;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ClassInfoDTO> getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(List<ClassInfoDTO> teacherClass) {
        this.teacherClass = teacherClass;
    }

    public List<MenuNode> getResource() {
        return resource;
    }

    public void setResource(List<MenuNode> resource) {
        this.menu = new Menu(resource);
        this.resource = resource;
    }


}
