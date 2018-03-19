package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.Bank;

public interface BankMapper {
    int insert(Bank record);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKeyWithBLOBs(Bank record);

    int updateByPrimaryKey(Bank record);
}