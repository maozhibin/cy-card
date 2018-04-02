package cun.yun.card.cycard.dal.dao;

import cun.yun.card.cycard.dal.dto.BankLinkInfoDato;
import cun.yun.card.cycard.dal.dto.BondLinkInfoDato;
import cun.yun.card.cycard.dal.dto.LoanLinkInfoDato;
import cun.yun.card.cycard.dal.model.CooperativePartnerLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperativePartnerLinkMapper {
    int insert(CooperativePartnerLink record);

    int insertSelective(CooperativePartnerLink record);

    CooperativePartnerLink selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CooperativePartnerLink record);

    int updateByPrimaryKey(CooperativePartnerLink record);

    List<BankLinkInfoDato> bankLinkList(@Param("cooperativePartnerCode") String cooperativePartnerCode, @Param("id")long id, @Param("type")int type);

    List<LoanLinkInfoDato> loanLinkList(@Param("cooperativePartnerCode") String cooperativePartnerCode, @Param("id")long id, @Param("type")int type);

    List<BondLinkInfoDato> bondLinkList(@Param("cooperativePartnerCode") String cooperativePartnerCode, @Param("id")long id, @Param("type")int type);
}