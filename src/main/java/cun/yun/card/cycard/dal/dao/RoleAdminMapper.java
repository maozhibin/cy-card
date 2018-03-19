package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.RoleAdmin;

public interface RoleAdminMapper {
    int insert(RoleAdmin record);

    int insertSelective(RoleAdmin record);

    RoleAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleAdmin record);

    int updateByPrimaryKey(RoleAdmin record);
}