package com.darkhole.shiro.model;

public class Url {
    private String urlId;

    private String urlHref;

    private String urlPerms;

    private Integer urlPremsType;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId == null ? null : urlId.trim();
    }

    public String getUrlHref() {
        return urlHref;
    }

    public void setUrlHref(String urlHref) {
        this.urlHref = urlHref == null ? null : urlHref.trim();
    }

    public String getUrlPerms() {
        return urlPerms;
    }

    public void setUrlPerms(String urlPerms) {
        this.urlPerms = urlPerms == null ? null : urlPerms.trim();
    }

    public Integer getUrlPremsType() {
        return urlPremsType;
    }

    public void setUrlPremsType(Integer urlPremsType) {

        this.urlPremsType = urlPremsType;
    }
}