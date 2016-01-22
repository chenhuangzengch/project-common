package net.xuele.common.dto;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zhongjian.xu on 2015/6/1 0008.
 */
public class MenuNode implements Serializable {
    private static final long serialVersionUID = 5934552248634016204L;
    private boolean isCurrent;
    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 下一级菜单
     */
    private List<MenuNode> nextLevel;

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public List<MenuNode> getNextLevel() {
        return nextLevel;
    }


    public void setNextLevel(List<MenuNode> nextLevel) {
        this.nextLevel = nextLevel;
    }

    /**
     * 获取[M_RESOURCES]的属性资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置[M_RESOURCES]的属性资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取[M_RESOURCES]的属性资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置[M_RESOURCES]的属性资源地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

}
