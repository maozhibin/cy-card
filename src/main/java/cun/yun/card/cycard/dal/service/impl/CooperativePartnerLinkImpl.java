package cun.yun.card.cycard.dal.service.impl;

import cun.yun.card.cycard.dal.dao.CooperativePartnerLinkMapper;
import cun.yun.card.cycard.dal.dto.BankLinkInfoDato;
import cun.yun.card.cycard.dal.dto.BondLinkInfoDato;
import cun.yun.card.cycard.dal.dto.LoanLinkInfoDato;
import cun.yun.card.cycard.dal.service.CooperativePartnerLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CooperativePartnerLinkImpl implements CooperativePartnerLinkService {
    @Resource
    private CooperativePartnerLinkMapper cooperativePartnerLinkMapper;

    @Override
    public List<BankLinkInfoDato> bankLinkList(String cooperativePartnerCode, long id, int type) {
        return cooperativePartnerLinkMapper.bankLinkList(cooperativePartnerCode,id,type);
    }

    @Override
    public List<LoanLinkInfoDato> loanLinkList(String cooperativePartnerCode, long id, int type) {
        return cooperativePartnerLinkMapper.loanLinkList(cooperativePartnerCode,id,type);
    }

    @Override
    public List<BondLinkInfoDato> bondLinkList(String cooperativePartnerCode, long id, int type) {
        return cooperativePartnerLinkMapper.bondLinkList(cooperativePartnerCode,id,type);
    }
}
