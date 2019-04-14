package com.example.wolf.entiry;

public class Pageble {
    private Integer page;

    private Integer offset;

    private Integer size;

    private String sort;

    public Pageble() {
    }

    public Pageble(Integer page, Integer size, String sort) {
        this.page = page;
        this.offset = (page-1)*size;
        this.size = size;
        this.sort = sort;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
