package cun.yun.card.cycard.controller;

import com.alibaba.fastjson.JSONObject;
import cun.yun.card.cycard.dal.service.RedisService;
import cun.yun.card.cycard.util.CodeUtil;
import cun.yun.card.cycard.util.JsonResponseMsg;
import cun.yun.card.cycard.util.SmsClient;
import cun.yun.card.cycard.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {
    @Autowired
    private RedisService redisService;

    @Value("${imageUrl}")
    private String imageUrl;
    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "/image" ,method = RequestMethod.GET)
    public JsonResponseMsg image(){
       JsonResponseMsg result = new JsonResponseMsg();
        Map<String,Object> resultMap = new HashMap<>();
        //创建文件输出流对象
        OutputStream out = null;
        try {
            Long time = System.currentTimeMillis();
            String temp="/var/www/html/";
            String tempUrl = imageUrl+time+".jpg";
            String url =tempUrl.substring(temp.length(),tempUrl.length());
            out = new FileOutputStream(tempUrl);
            Map<String,Object> map = CodeUtil.generateCodeAndPic();
            ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
            resultMap.put("image",url);
            resultMap.put("imageTime",time);
            resultMap.put("code",map.get("code"));
            out.close();
            redisService.set(String.valueOf(time),map.get("code"),180L);
        } catch (IOException e) {
            log.error("生成图片验证码错误");
            e.printStackTrace();
        }
        return  result.fill(JsonResponseMsg.CODE_SUCCESS,"生成图片验证码成功",resultMap);
    }

    /**
     * 短信验证码的下发
     */
    @RequestMapping(value = "/send" ,method = RequestMethod.GET)
    public JsonResponseMsg send(String mobile, String imageTime, String code){
        JsonResponseMsg result = new JsonResponseMsg();
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isEmpty(mobile)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入手机号");
        }
        if(!Utils.checkMobile(mobile)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"你输入的手机号有误");
        }
        if(StringUtils.isEmpty(imageTime)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"你输入的参数错误");
        }
        if(StringUtils.isEmpty(code)){
            return result.fill(JsonResponseMsg.CODE_FAIL,"请输入验证码");
        }
        Object mobileRedis =  redisService.get(mobile);
        if(mobile.equals(String.valueOf(mobileRedis))){
            return result.fill(JsonResponseMsg.CODE_FAIL,"同一手机号在一分钟之内不能多次下发验证短信");
        }
        Object codeRedisValue = redisService.get(imageTime);
        if(!(code.toUpperCase()).equals(String.valueOf(codeRedisValue).toUpperCase())){
            return result.fill(JsonResponseMsg.CODE_FAIL,"你输入的验证码错误请重新输入");
        }
        try {
           String json =  SmsClient.sendMsg(mobile);
           JSONObject jsonObject = JSONObject.parseObject(json);
           Integer jsonCode = jsonObject.getInteger("code");
           if(JsonResponseMsg.CODE_SUCCESS == jsonCode){
                redisService.set(mobile,mobile,60L);//保存发送成功的号码到redis中，有效期为一分钟，保证一个手机号在一分钟内部能同时下发验证短信
                String obj = jsonObject.getString("obj");
                redisService.set(mobile+code,obj,180L);//将验证码保存到redis中key为 手机号+code字符，有效期为3分钟
                //存储短信验证码的信息
                map.put("mobilecode",mobile+code);
                map.put("smsCode",obj);
                Long time = new Date().getTime();
                map.put("time",time);
           }else{
               return result.fill(JsonResponseMsg.CODE_FAIL,"短信接口错误");
           }
        } catch (IOException e) {
            log.error("发送短信接口错误");
            e.printStackTrace();
        }
        return  result.fill(JsonResponseMsg.CODE_SUCCESS,"验证短信下发成功",map);
    }


}
