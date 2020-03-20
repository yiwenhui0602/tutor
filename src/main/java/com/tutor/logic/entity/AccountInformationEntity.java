package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:07
 */
@Entity
@Table(name = "account_information", schema = "school", catalog = "")
public class AccountInformationEntity {
    private int accountId;
    private String accountNunmer;
    private Integer accountType;
    private String accountPassword;

    @Id
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "account_nunmer")
    public String getAccountNunmer() {
        return accountNunmer;
    }

    public void setAccountNunmer(String accountNunmer) {
        this.accountNunmer = accountNunmer;
    }

    @Basic
    @Column(name = "account_type")
    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "account_password")
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInformationEntity that = (AccountInformationEntity) o;
        return accountId == that.accountId &&
                Objects.equals(accountNunmer, that.accountNunmer) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(accountPassword, that.accountPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNunmer, accountType, accountPassword);
    }
}
