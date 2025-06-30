package com.Lcode.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {

    /**
     * 获得激活码
     * @return
     */
    public static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 对用户的密码进行加密
     * @param key
     * @return
     */
    public static String getMd5(String key)
    {
        if(key == null || StringUtils.isBlank(key))
        {
            return null;
        }
        else {
            return DigestUtils.md5DigestAsHex(key.getBytes());
        }
    }
}
