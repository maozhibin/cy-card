package cun.yun.card.cycard.controller;

import cun.yun.card.cycard.dal.dto.LinkInfoDato;
import cun.yun.card.cycard.dal.service.CooperativePartnerLinkService;
import cun.yun.card.cycard.util.JsonResponseMsg;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/cooperativePartner")
public class CooperativePartnerController {

    @Resource
    private CooperativePartnerLinkService cooperativePartnerLinkService;


    /**
     * 银行链接综合链接或者单链接信息
     * @param cooperativePartnerCode
     * @param id
     * @return
     */
    @RequestMapping(value = "linkInfo" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResponseMsg linkInfo(String cooperativePartnerCode,String id,String type){
        JsonResponseMsg result = new JsonResponseMsg();
        if(StringUtils.isEmpty(cooperativePartnerCode)|| !NumberUtils.isNumber(id)||!NumberUtils.isNumber(type)){
            return  result.fill(JsonResponseMsg.CODE_FAIL,"参数错误");
        }
        List<LinkInfoDato> linkList = cooperativePartnerLinkService.bankLinkList(cooperativePartnerCode,NumberUtils.toLong(id),NumberUtils.toInt(type));
        Map<String,Object> map = new HashMap<>();
        map.put("linkList",linkList);
        return result.fill(JsonResponseMsg.CODE_SUCCESS,"查出成功",map);
    }
    

}
