package cun.yun.card.cycard.dal.model;

import java.util.Date;

public class ClickLink {
    private Long id;

    private Long cooperativePartnerId;

    private Long linkId;

    private Integer type;

    private Date updatedTime;
    private Date createTime;

    @Override
    public String toString() {
        return "ClickLink{" +
                "id=" + id +
                ", cooperativePartnerId=" + cooperativePartnerId +
                ", linkId=" + linkId +
                ", type=" + type +
                ", updatedTime=" + updatedTime +
                ", createTime=" + createTime +
                '}';
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {

        return createTime;
    }

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

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}