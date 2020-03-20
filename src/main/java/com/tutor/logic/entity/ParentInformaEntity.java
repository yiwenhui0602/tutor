package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:08
 */
@Entity
@Table(name = "parent_informa", schema = "school", catalog = "")
public class ParentInformaEntity {
    private int parentId;
    private String parentName;
    private String parentGender;
    private String parentPhone;
    private String relationship;
    private String parentAccount;

    @Id
    @Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "parent_name")
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Basic
    @Column(name = "parent_gender")
    public String getParentGender() {
        return parentGender;
    }

    public void setParentGender(String parentGender) {
        this.parentGender = parentGender;
    }

    @Basic
    @Column(name = "parent_phone")
    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    @Basic
    @Column(name = "relationship")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Basic
    @Column(name = "parent_account")
    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentInformaEntity that = (ParentInformaEntity) o;
        return parentId == that.parentId &&
                Objects.equals(parentName, that.parentName) &&
                Objects.equals(parentGender, that.parentGender) &&
                Objects.equals(parentPhone, that.parentPhone) &&
                Objects.equals(relationship, that.relationship) &&
                Objects.equals(parentAccount, that.parentAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, parentName, parentGender, parentPhone, relationship, parentAccount);
    }
}
