package cun.yun.card.cycard.dal.service;

import cun.yun.card.cycard.dal.dto.BankLinkInfoDato;
import cun.yun.card.cycard.dal.dto.BondLinkInfoDato;
import cun.yun.card.cycard.dal.dto.LoanLinkInfoDato;

import java.util.List;

public interface CooperativePartnerLinkService {
    List<BankLinkInfoDato> bankLinkList(String cooperativePartnerCode, long id, int type);

    List<LoanLinkInfoDato> loanLinkList(String cooperativePartnerCode, long id, int type);

    List<BondLinkInfoDato> bondLinkList(String cooperativePartnerCode, long l, int i);
}
