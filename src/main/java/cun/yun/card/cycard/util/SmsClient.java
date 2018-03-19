package cun.yun.card.cycard.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

/**
 * 短信工具类
 *
 * @author	zhangyq
 * @create	2017年12月13日
 */
public class SmsClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsClient.class);

	/** 网易云信地址 */
	private static final String SMS_INFORMATION_TEMPLATE_API = "https://api.netease.im/sms/sendtemplate.action";
	private static final String SMS_AUTH_CODE_TEMPLATE_API = "https://api.netease.im/sms/sendcode.action";
	/** 网易云信AppKey */
	private static final String SMS_APP_KEY = "b54a2087b0bc42d9e07a9c30462f103c";
	/** 网易云信AppSecret */
	private static final String SMS_APP_SECRET = "97b317aa8aa9";

	private static final String NULL = "null";

	private SmsClient() {
	}

//	/**
//	 * 发送通知短信
//	 */
//	public static String sendInformationMessage(String[] phoneNum, Integer templateId, String[] params) {
//		Map<String, Object> paramMap = Maps.newHashMap();
//		String phoneList = new Gson().toJson(phoneNum);
//		paramMap.put("mobiles", phoneList);
//		paramMap.put("params", new Gson().toJson(params));
//		return sendTemplateMessage(SMS_INFORMATION_TEMPLATE_API, phoneList, templateId, paramMap);
//	}
//
//	/**
//	 * 发送验证码短信
//	 */
//	public static String sendAuthCodeMessage(String phone, Integer templateId, String params) {
//		Map<String, Object> paramMap = Maps.newHashMap();
//		paramMap.put("mobile", phone);
//		paramMap.put("authCode", params);
//		return sendTemplateMessage(SMS_AUTH_CODE_TEMPLATE_API, phone, templateId, paramMap);
//	}
//
//	/**
//	 * 发送短信
//	 */
//	private static String sendTemplateMessage(String url, String phoneNum, Integer templateId,
//			Map<String, Object> paramMap) {
//		if (StringUtils.isBlank(phoneNum) || NULL.equals(phoneNum)) {
//			LOGGER.warn("调用网易云信接口phone=null");
//			return null;
//		}
//		paramMap.put("templateid", templateId);
//		String responseBody = sendPost(url, paramMap);
//
//		LOGGER.info("调用网易短信接口发送结果:模板id:【{}】,手机号:【{}】.返回状态信息:【{}】", templateId, phoneNum, responseBody);
//		return responseBody;
//	}
//
//	/**
//	 * post请求网易云信
//	 */
//	private static String sendPost(String url, Map<String, Object> params) {
//		Map<String, String> headers = Maps.newHashMap();
//		String curTime = String.valueOf(System.currentTimeMillis());
//		String nonce = UUID.randomUUID().toString();
//		String checkSum = CheckSumBuilder.getCheckSum(SMS_APP_SECRET, nonce, curTime);
//		headers.put("AppKey", SMS_APP_KEY);
//		headers.put("CurTime", curTime);
//		headers.put("Nonce", nonce);
//		headers.put("CheckSum", checkSum);
//		headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//		return OkHttpUtils.doFormPost(url, params, Headers.of(headers));
//	}

}
