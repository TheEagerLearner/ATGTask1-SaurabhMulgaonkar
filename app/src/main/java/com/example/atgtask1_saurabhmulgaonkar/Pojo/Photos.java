package com.example.atgtask1_saurabhmulgaonkar.Pojo;

import java.util.List;

public class Photos {

    private Integer page;
    private Integer pages;
    private Integer perpage;
    private Integer total;
    private List<Photo> photo=null;

    public Photos(Integer page, Integer pages, Integer perpage, Integer total, List<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }
}
