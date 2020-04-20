package com.spring_cloud.common.entity;


import lombok.Getter;

@Getter
public class PageQuery {
    private static final long MIN_PAGE_NO = 0L;
    private static final long MIN_PAGE_SIZE = 1L;
    private static final long DEFAULT_PAGE_NO = 0L;

    private Long pageNo;
    private Long pageSize;
    private String sortBy;
    private String sortDirection;

    public PageQuery(Long pageNo, Long pageSize, String sortBy, String sortDirection) {
        if(pageNo == null || pageNo < MIN_PAGE_NO) {
            this.pageNo = DEFAULT_PAGE_NO;
        } else {
            this.pageNo = pageNo;
        }
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }
}
