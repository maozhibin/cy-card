package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}