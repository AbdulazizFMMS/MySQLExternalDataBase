package com.mofidx.mysqlexternaldatabase;

public class nasheed {
    int id;
    String img;
    String desc;
    String link;

    public nasheed(int id, String img, String desc, String link) {
        this.id = id;
        this.img = img;
        this.desc = desc;
        this.link = link;
    }
    public nasheed(String img, String desc, String link) {
        this.img = img;
        this.desc = desc;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
