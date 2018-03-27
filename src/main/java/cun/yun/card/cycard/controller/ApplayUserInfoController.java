package cun.yun.card.cycard.controller;

import cun.yun.card.cycard.dal.dao.ClickLinkMapper;
import cun.yun.card.cycard.dal.model.ApplayUserInfo;
import cun.yun.card.cycard.dal.model.ClickLink;
import cun.yun.card.cycard.dal.service.ApplayUserInfoService;
import cun.yun.card.cycard.dal.service.RedisService;
import cun.yun.card.cycard.util.JsonResponseMsg;
import cun.yun.card.cycard.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
public class ApplayUserInfoController {

    @Resource
    private RedisService redisService;
    @Resource
    private ApplayUserInfoService applayUserInfoService;
    @Resource
    private ClickLinkMapper clickLinkMapper;
    /**
     * 用户信息保存
     */
    @RequestMapping(value = "/userSave" ,method = RequestMethod.GET)
    public JsonResponseMsg userSave(String name,String mobile,String type,String linkId,String cooperativePartnerId,String price,String smsCode,String mobilecode){
        JsonResponseMsg result = new JsonResponseMsg();
        if(StringUtils.isEmpty(name)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入用户名");
        }
        if(!Utils.checkMobile(mobile)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入手机号");
        }
        if(!NumberUtils.isNumber(type)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入链接类型");
        }
        if(!NumberUtils.isNumber(linkId)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入链接id");
        }
        if(!NumberUtils.isNumber(cooperativePartnerId)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入cooperativePartnerId");
        }
        if(StringUtils.isEmpty(smsCode)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入验证码");
        }
        if(StringUtils.isEmpty(price)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入价格");
        }

        Object smsCodeRedis = redisService.get(mobilecode);
        if(!smsCode.equals(String.valueOf(smsCodeRedis))){
            return result.fill(JsonResponseMsg.CODE_FAIL,"你输入的验证码信息不正确");
        }
        ApplayUserInfo applayUserInfo = new ApplayUserInfo();
        applayUserInfo.setName(name);
        applayUserInfo.setMobile(mobile);
        applayUserInfo.setType(NumberUtils.toInt(type));
        applayUserInfo.setLinkId(NumberUtils.toLong(linkId));
        applayUserInfo.setCooperativePartnerId(NumberUtils.toLong(cooperativePartnerId));
        applayUserInfo.setPrice(new BigDecimal(price));
        applayUserInfo.setStatus(1);
        applayUserInfo.setIsEmploy(0);
        applayUserInfo.setCreateTime(new Date());
        applayUserInfo.setUpdatedTime(new Date());
        applayUserInfoService.insertSelect(applayUserInfo);
        //保存点击信息
        ClickLink clickLink = new ClickLink();
        clickLink.setCooperativePartnerId(NumberUtils.toLong(cooperativePartnerId));
        clickLink.setLinkId(NumberUtils.toLong(linkId));
        clickLink.setType(NumberUtils.toInt(type));
        clickLink.setCreateTime(new Date());
        clickLink.setUpdatedTime(new Date());
        clickLinkMapper.insertSelective(clickLink);
        return result.fill(JsonResponseMsg.CODE_SUCCESS,"用户信息保存成功");
    }
}
