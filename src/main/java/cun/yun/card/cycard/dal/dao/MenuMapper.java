package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.Menu;

public interface MenuMapper {
    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}