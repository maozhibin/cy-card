package cun.yun.card.cycard.controller;

import cun.yun.card.cycard.dal.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("card")
public class ServiceController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "service/check" ,method = RequestMethod.GET)
    public Long check(){
        return System.currentTimeMillis();
    }



    /**
     *redis测试
     */
    @RequestMapping(value = "/redisTest" ,method = RequestMethod.GET)
    public void setRedis(){
        redisService.set("mao","zhibin", 10L);
    }
    @RequestMapping(value = "/getRedisTest" ,method = RequestMethod.GET)
    public Object getRedis(){
        return redisService.get("1521525370508");
    }


}
