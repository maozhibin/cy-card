package cun.yun.card.cycard.dal.service.impl;

import cun.yun.card.cycard.dal.dao.ApplayUserInfoMapper;
import cun.yun.card.cycard.dal.model.ApplayUserInfo;
import cun.yun.card.cycard.dal.service.ApplayUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplayUserInfoServiceImpl implements ApplayUserInfoService {
    @Resource
    private ApplayUserInfoMapper applayUserInfoMapper;
    @Override
    public int insertSelect(ApplayUserInfo applayUserInfo) {
        return applayUserInfoMapper.insertSelective(applayUserInfo);
    }
}
