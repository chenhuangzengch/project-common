package net.xuele.common.security;

import net.xuele.common.dto.MenuNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhengTao on 2015/7/15 0015.
 */
public class Menu implements java.io.Serializable {
    private static final long serialVersionUID = -8598685794085581417L;
    private List<MenuNode> list = new ArrayList<>();
    private String lastUrl;

    public String getLastUrl() {
        return lastUrl;
    }


    // 添加一个无参构造用于hessian序列化
    public Menu() {

    }

    public Menu(List<MenuNode> resourceDTOs) {
        for (MenuNode resourceDTO : resourceDTOs) {
            if (resourceDTO.getNextLevel() == null || resourceDTO.getNextLevel().isEmpty()) {
                continue;
            }
            resourceDTO.setUrl(resourceDTO.getNextLevel().get(0).getUrl());
            list.add(resourceDTO);
        }
    }

    public List<MenuNode> getList() {
        return list;
    }

    /**
     * 当前url
     *
     * @param url
     * @return
     */
    public List<MenuNode> getFirst(String url, String lastUrl) {
        resetToIsNotCurrent();
        LinkedList<MenuNode> first = new LinkedList<>();
        if (doMatch(url, first)) {
            return first;
        }
        first = new LinkedList<>();
        doMatch(lastUrl, first);
        return first;
    }

    private void resetToIsNotCurrent() {
        for (MenuNode out : list) {
            if (out.getIsCurrent()) {
                out.setIsCurrent(false);
                for (MenuNode inner : out.getNextLevel()) {
                    inner.setIsCurrent(false);
                }
                return;
            }
        }
    }

    private boolean doMatch(String url, LinkedList<MenuNode> first) {
        boolean find = false;
        out:
        for (MenuNode out : list) {
            if (find) {
                first.add(out);
                continue;
            }
            inner:
            for (MenuNode inner : out.getNextLevel()) {
                if (inner.getUrl().contains(url)) {
                    find = true;
                    inner.setIsCurrent(true);
                    out.setIsCurrent(true);
                    first.addFirst(out);
                    this.lastUrl = url;
                    continue out;
                }
            }
            first.add(out);
        }
        return find;
    }


    public List<MenuNode> getSecond() {
        for (MenuNode resourceDTO : list) {
            if (resourceDTO.getIsCurrent()) {
                return resourceDTO.getNextLevel();
            }
        }
        return list.get(0).getNextLevel();
    }
}
