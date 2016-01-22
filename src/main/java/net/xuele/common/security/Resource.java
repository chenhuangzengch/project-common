package net.xuele.common.security;

/**
 * Created by Administrator on 2015/7/6 0006.
 */
public class Resource {
    private String projectKey = "member";
    private String projectUrl = "http://192.168.1.106:8080/member-web";
    private String relative = "/class/index";

    /**
     * url
     *
     * @param currentProjectKey 当前项目标识
     * @param userId            当前身份对应的用户
     * @return url
     */
    public String toString(String currentProjectKey, String userId) {
        if (projectKey.equals(currentProjectKey))
            return projectUrl + relative;
        //如果另一个系统的userId一样，session不需要改，设置session中的currentProjectKey就可以，设置完跳转到after
        return projectUrl + "/identify/change?userId" + userId + "&after=" + projectUrl + relative +
                "&projectKey=" + projectKey;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }
}
