package net.xuele.common.page;


/**
 * 分页请求对象
 * Created by zhihuan.cai on 2015/6/1 0001.
 */
public abstract class PageRequest {


    public static final int DEFAULT_PAGE_SIZE = 10;


    /**
     * 请求的页码
     */
    private int page;

    /**
     * 每页多少条
     */
    private int pageSize;


    /**
     * 起始行
     */
    private long start;

    /**
     * 结束行
     */
    private long end;


    public int getPage() {
        if (page < 1) {
            page = 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStart() {
        start = (getPage() - 1) * getPageSize();
        return start;
    }


    public long getEnd() {
        end = getPage() * getPageSize();
        return end;
    }


}
