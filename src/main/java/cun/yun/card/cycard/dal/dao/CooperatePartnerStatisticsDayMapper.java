package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.model.CooperatePartnerStatisticsDay;

public interface CooperatePartnerStatisticsDayMapper {
    int insert(CooperatePartnerStatisticsDay record);

    int insertSelective(CooperatePartnerStatisticsDay record);

    CooperatePartnerStatisticsDay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CooperatePartnerStatisticsDay record);

    int updateByPrimaryKey(CooperatePartnerStatisticsDay record);
}