package com.chinaopensource.apiserver.common.util.encryption;

import com.chinaopensource.apiserver.common.constant.EncryptionEnum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  

/**
 * MD5 和   sha加密
 * 
 * @author lqw
 * 2017年3月18日 下午4:10:20
 */
public class EncryptionUtil {  

    /** 
     * 由于MD5 与SHA-1均是从MD4 发展而来，它们的结构和强度等特性有很多相似之处 
     * SHA-1与MD5 的最大区别在于其摘要比MD5 摘要长 32 比特（1byte=8bit，相当于长4byte，转换16进制后比MD5多8个字符）。  
     * 对于强行攻击，：MD5 是2128 数量级的操作，SHA-1 是2160数量级的操作。 
     * 对于相同摘要的两个报文的难度：MD5是 264 是数量级的操作，SHA-1 是280 数量级的操作。 
     * 因而，SHA-1 对强行攻击的强度更大。 但由于SHA-1 的循环步骤比MD5 多（80:64）且要处理的缓存大（160 比特:128 比特），SHA-1 的运行速度比MD5 慢。 
     *  
     * @param source 需要加密的字符串 
     * @param encryptionEnum 枚举类 加密类型 （MD5 和 SHA）
     * @return 
     */  
    public static String getHash(String source, EncryptionEnum encryptionEnum) {
        StringBuilder sb = new StringBuilder();  
        MessageDigest md5;  
        try {  
            md5 = MessageDigest.getInstance(encryptionEnum.getType());
            md5.update(source.getBytes());  
            for (byte b : md5.digest()) {  
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出  
            }  
            return sb.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  

}  