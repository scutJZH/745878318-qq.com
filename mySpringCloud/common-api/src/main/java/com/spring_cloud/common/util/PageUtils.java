package com.spring_cloud.common.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring_cloud.common.entity.PageQuery;

public class PageUtils {
    public static final String ASCENDING_ORDER = "asc";
    public static final String DESCENDING_ORDER = "desc";

    private PageUtils() {
    }

    public static <T> Page<T> buildPage(PageQuery pageQuery) {
        Page<T> page = new Page<>();
        // 分页插件页数从1开始
        page.setCurrent(pageQuery.getPageNo() + 1);
        page.setSize(pageQuery.getPageSize());
        if (ASCENDING_ORDER.equalsIgnoreCase(pageQuery.getSortDirection())) {
            page.addOrder(OrderItem.asc(pageQuery.getSortBy()));
        } else if (DESCENDING_ORDER.equalsIgnoreCase(pageQuery.getSortDirection())) {
            page.addOrder(OrderItem.desc(pageQuery.getSortBy()));
        }
        return page;
    }
}
