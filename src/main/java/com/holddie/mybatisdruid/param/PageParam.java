package com.holddie.mybatisdruid.param;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 分页查询Bean
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 22:25
 */
@Data
public class PageParam {

    private int beginLine;

    private Integer pageSize = 3;

    private Integer currentPage = 0;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
