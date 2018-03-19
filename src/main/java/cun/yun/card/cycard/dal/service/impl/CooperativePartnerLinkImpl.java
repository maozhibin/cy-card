package cun.yun.card.cycard.dal.service.impl;

import cun.yun.card.cycard.dal.dao.CooperativePartnerLinkMapper;
import cun.yun.card.cycard.dal.dto.LinkInfoDato;
import cun.yun.card.cycard.dal.service.CooperativePartnerLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CooperativePartnerLinkImpl implements CooperativePartnerLinkService {
    @Resource
    private CooperativePartnerLinkMapper cooperativePartnerLinkMapper;

    @Override
    public List<LinkInfoDato> bankLinkList(String cooperativePartnerCode, long id, int type) {
        return cooperativePartnerLinkMapper.bankLinkList(cooperativePartnerCode,id,type);
    }
}
