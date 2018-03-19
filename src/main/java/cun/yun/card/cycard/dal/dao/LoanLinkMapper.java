package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.LoanLink;

public interface LoanLinkMapper {
    int insert(LoanLink record);

    int insertSelective(LoanLink record);

    LoanLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanLink record);

    int updateByPrimaryKey(LoanLink record);
}