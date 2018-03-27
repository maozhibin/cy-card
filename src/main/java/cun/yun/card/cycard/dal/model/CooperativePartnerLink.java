package cun.yun.card.cycard.dal.model;

import java.util.Date;

public class CooperativePartnerLink {
    private Long id;

    private Integer sort;

    @Override
    public String toString() {
        return "CooperativePartnerLink{" +
                "id=" + id +
                ", sort=" + sort +
                ", cooperativePartnerId=" + cooperativePartnerId +
                ", url='" + url + '\'' +
                ", linkType=" + linkType +
                ", isEmploy=" + isEmploy +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {

        return sort;
    }

    private Long cooperativePartnerId;

    private String url;

    private Integer linkType;

    private Integer isEmploy;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCooperativePartnerId() {
        return cooperativePartnerId;
    }

    public void setCooperativePartnerId(Long cooperativePartnerId) {
        this.cooperativePartnerId = cooperativePartnerId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public Integer getIsEmploy() {
        return isEmploy;
    }

    public void setIsEmploy(Integer isEmploy) {
        this.isEmploy = isEmploy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}