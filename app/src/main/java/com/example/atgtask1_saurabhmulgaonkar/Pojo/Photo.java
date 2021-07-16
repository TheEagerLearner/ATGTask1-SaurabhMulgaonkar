package com.example.atgtask1_saurabhmulgaonkar.Pojo;

public class Photo {

    private String id;
    private String owner;
    private String secret;
    private String server;
    private Integer farm;
    private String title;
    private Integer ispublic;
    private Integer isfriend;
    private Integer isfamily;
    private String urlS;
    private Integer heightS;
    private Integer widthS;

    public Photo(String id, String owner, String secret, String server, Integer farm, String title, Integer ispublic, Integer isfriend, Integer isfamily, String urlS, Integer heightS, Integer widthS) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
        this.urlS = urlS;
        this.heightS = heightS;
        this.widthS = widthS;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    public String getServer() {
        return server;
    }

    public Integer getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public String getUrl() {
        return urlS;
    }

    public Integer getHeight() {
        return heightS;
    }

    public Integer getWidth() {
        return widthS;
    }
}
