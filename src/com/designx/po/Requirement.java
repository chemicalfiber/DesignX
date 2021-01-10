package com.designx.po;

import java.util.Date;

/*
用户需求实体类
 */
public class Requirement {
    private Integer requirementId;  // 需求ID
    private Integer committer;      // 提交者ID
    private String content;         // 内容
    private Date  orderDate;        // 提交日期
    private Date deliveryDate;      // 期望交货日期
    private Integer status;         // 需求进行状态
    private String type;            // 需求网站类型

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getCommitter() {
        return committer;
    }

    public void setCommitter(Integer committer) {
        this.committer = committer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
