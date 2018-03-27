package cun.yun.card.cycard.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class ApplayUserInfo {
    private Long id;

    private String name;

    private String mobile;

    private String idCard;

    private Integer type;

    private Integer status;

    private Long linkId;

    private Long cooperativePartnerId;

    private BigDecimal price;

    private Integer isEmploy;

    private Date updatedTime;

    @Override
    public String toString() {
        return "ApplayUserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", linkId=" + linkId +
                ", cooperativePartnerId=" + cooperativePartnerId +
                ", price=" + price +
                ", isEmploy=" + isEmploy +
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

    private Date createTime;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Long getCooperativePartnerId() {
        return cooperativePartnerId;
    }

    public void setCooperativePartnerId(Long cooperativePartnerId) {
        this.cooperativePartnerId = cooperativePartnerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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