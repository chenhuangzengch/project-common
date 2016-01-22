package net.xuele.common.page;

/**
 * persist层分页对象
 * zhihuan.cai 新建于 2015/6/2 0002.
 */
public class Page {

    /**
     * 起始行
     */
    private long start;


    /**
     * 结束行
     */
    private long end;


    /**
     * 每页多少行
     */
    private int pageSize;



    /**
     * 当前页码
     */
    private int page;

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


}
