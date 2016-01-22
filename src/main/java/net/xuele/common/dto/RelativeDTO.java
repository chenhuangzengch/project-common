package net.xuele.common.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongjian.xu on 2015/7/13 0013.
 */
public class RelativeDTO implements Serializable{
    private static final long serialVersionUID = 2464017858020765761L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     */
    private String realName;
    /**
     * 图标
     */
    private String icon;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 职务ID
     */
    private String positionId;
    /**
     * 职务名称
     */
    private String positionName;
    /**
     * 身份ID
     */
    private String identityId;
    /**
     * 班级列表
     */
    private List<String> classList;
    /**
     * 孩子列表
     */
    private Map<String,String> kidList;

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    public Map<String, String> getKidList() {
        return kidList;
    }

    public void setKidList(Map<String, String> kidList) {
        this.kidList = kidList;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
}
