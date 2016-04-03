package com.company;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by User on 03.04.2016.
 */
public class Encryprt {
    public static final String Algorythm = "AES";
    public static final String Key = "1Hbfh667adfDEJ78";

    public static String encrypt(String value) throws Exception{
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Encryprt.Algorythm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte [] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        String encryptedValue64 = new BASE64Encoder().encode(encryptedByteValue);
        return encryptedValue64;
    }
    public static String decrypt(String value) throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Encryprt.Algorythm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte [] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedValue = new String(decryptedByteValue,"utf-8");
        return decryptedValue;

    }
    private static Key generateKey() throws Exception{
        Key key = new SecretKeySpec(Encryprt.Key.getBytes(),Encryprt.Algorythm);
        return key;
    }
}
