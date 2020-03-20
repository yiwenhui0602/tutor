package com.tutor.logic.user;

import com.tutor.logic.entity.AccountInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountInformationEntity, Integer> {

    @Query(value = "from AccountInformationEntity where accountId=:accountId")
    public AccountInformationEntity findById(@Param("accountId") Integer accountId);

    @Query(value = "from AccountInformationEntity where accountNunmer=:accountNunmer and accountPassword=:accountPassword")
    public AccountInformationEntity findByNumberAndPassword(@Param("accountNunmer") String accountNunmer, @Param("accountPassword") String accountPassword);

    @Query(value = "from AccountInformationEntity where accountNunmer=:accountNunmer")
    public AccountInformationEntity findByNumber(@Param("accountNunmer") String accountNunmer);

}
