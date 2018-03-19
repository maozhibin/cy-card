package cun.yun.card.cycard.dal.service;

import cun.yun.card.cycard.dal.dto.LinkInfoDato;

import java.util.List;

public interface CooperativePartnerLinkService {
    List<LinkInfoDato> bankLinkList(String cooperativePartnerCode, long id, int type);
}
