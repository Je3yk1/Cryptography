package com.company;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by jedrzej_zawojski on 02.11.16.
 */
public class Krypto {
    private static final Charset CHARSET = Charset.forName("US-ASCII");
    private static final String PADDING = "NoPadding";

    String key,str;

    SecretKey aesKey;
    byte[] keyBytes;

    byte[] iv;
    Cipher cipher;
    IvParameterSpec ivParam;

    String ciph;
    String plainText;

    byte[][] cipherBytes;
    IvParameterSpec[] ivParams;

    Krypto() throws NoSuchPaddingException,NoSuchAlgorithmException,UnsupportedEncodingException,InvalidKeySpecException {
        cipher = Cipher.getInstance("AES/CBC/"+PADDING);
        cipherBytes = new byte[2][];
        ivParams = new IvParameterSpec[2];
    }

    public Charset getCharset() {
        return CHARSET;
    }
    void setIv(String iv) {
        this.iv = DatatypeConverter.parseHexBinary(iv);
        ivParam = new IvParameterSpec(this.iv);
    }

    String decrypt(String key, int nr) {
        plainText = "";
        try {
            keyBytes = DatatypeConverter.parseHexBinary(key);
            aesKey = new SecretKeySpec(keyBytes,"AES");
            cipher.init(Cipher.DECRYPT_MODE,aesKey,ivParams[nr]);
            plainText = new String(cipher.doFinal(cipherBytes[nr]), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainText;
    }

    void test(String iv,String key,String cipherText) throws InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeyException {
        SecretKey aesKey = new SecretKeySpec(DatatypeConverter.parseHexBinary(key),"AES");
        byte[] ivBytes = DatatypeConverter.parseHexBinary(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,aesKey,new IvParameterSpec(ivBytes));

        byte[] result = cipher.doFinal(DatatypeConverter.parseBase64Binary(cipherText));
        System.out.println(new String(result, "UTF-8"));
    }
}
