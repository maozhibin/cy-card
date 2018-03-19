package cun.yun.card.cycard.util;

import java.util.UUID;

public class Utils {
    /**
     * 生成UUId
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());

    }

}
