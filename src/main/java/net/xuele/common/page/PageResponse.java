package net.xuele.common.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页请求返回对象
 * Created by zhihuan.cai on 2015/6/1 0001.
 */
public class PageResponse<T> implements Serializable {


    private static final long serialVersionUID = -6213874308176673886L;
    /**
     * 总页数
     */
    private int total;

    /**
     * 当前页数
     */
    private int page;

    /**
     * 每页多少条数据
     */
    private int pageSize;
    /**
     * 总记录条数
     */
    private long records;

    /**
     * 返回对象
     */
    private List<T> rows = Collections.emptyList();

    public int getTotal() {
        if (total == 0) {
            total = (int) Math.ceil((double) getRecords() / (double) getPageSize());
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
