package com.holddie.mybatisdruid.result;

import com.holddie.mybatisdruid.param.PageParam;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回结果集
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 22:29
 */
@Data
public class Page<E> implements Serializable {

    public static final long serialVersionUID = 1L;

    private int currentPage = 1;

    private long totalPage;

    private long totalNumber;

    private List<E> list;

    public static Page NULL = new Page(0, 0, 15, new ArrayList());

    public Page() {
        super();
    }

    public Page(int beginLine, int totalNumber, int pageSize, List<E> list) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber / pageSize : totalNumber / totalPage + 1;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list) {
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber % pageParam.getPageSize() : totalNumber % pageParam.getPageSize() + 1;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
