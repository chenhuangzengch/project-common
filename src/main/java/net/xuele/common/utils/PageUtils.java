package net.xuele.common.utils;

import net.xuele.common.page.Page;
import net.xuele.common.page.PageRequest;
import net.xuele.common.page.PageResponse;

/**
 * 分页工具类
 * zhihuan.cai 新建于 2015/6/2 0002.
 */
public final class PageUtils {
    private PageUtils() {

    }


    public static final Page buildPage(PageRequest pageRequest) {
        Page page = new Page();
        page.setStart(pageRequest.getStart());
        page.setEnd(pageRequest.getEnd());
        page.setPageSize(pageRequest.getPageSize());
        page.setPage(pageRequest.getPage());
        return page;
    }

    public static final void buldPageResponse(PageRequest pageRequest,PageResponse pageResponse){
        pageResponse.setPage(pageRequest.getPage());
        pageResponse.setPageSize(pageRequest.getPageSize());
    }
}

