package com.qiaoyy.tutor.user;

import com.qiaoyy.tutor.entity.AccountInformationEntity;
import com.qiaoyy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountManager {

    @Autowired
    private AccountRepository accountRepository;


    public AccountInformationEntity login(AccountInformationEntity entity) {
        AccountInformationEntity accountInformationEntity = accountRepository.findByNumber(entity.getAccountNunmer());
        if (accountInformationEntity != null) {
            // 密码md5加密
            String password = MD5Util.encodeByMD5(entity.getAccountPassword());
            if (password.equals(accountInformationEntity.getAccountPassword())) {
                return entity;
            }
            return null;
        }
        entity.setAccountPassword(MD5Util.encodeByMD5(entity.getAccountPassword()));
        // 入库
        return accountRepository.saveAndFlush(entity);
    }

}
