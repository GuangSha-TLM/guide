package com.gsxy.guide.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 向导实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:36
 */
public class Guide implements Serializable {
    private static final long serialVersionUID = -10400830850493243L;

    private Long id;
/**
     * 网址名
     */
    private String name;
/**
     * 网址链接
     */
    private String toLink;
/**
     * 创建时间
     */
    private Date createTime;
/**
     * 创建人
     */
    private Long createBy;
/**
     * 修改时间
     */
    private Date updateTime;
/**
     * 修改人
     */
    private Long updateBy;
/**
     * 状态（0：普通，1：管理）
     */
    private Integer status;
/**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer delFlag;


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

    public String getToLink() {
        return toLink;
    }

    public void setToLink(String toLink) {
        this.toLink = toLink;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}

