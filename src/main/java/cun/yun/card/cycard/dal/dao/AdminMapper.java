package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.Admin;

public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}