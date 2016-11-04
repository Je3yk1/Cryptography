package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, FileNotFoundException {
        /*
        Krypto crypto = new Krypto();
        String iv = "b00e5b6be9c381d84e0d2c5f1fd903db";
        String key = "fd269dde129cf159af66900799a668be1b13d148381310d4433ed8d99efe0c20";
        String cipherText = "HczsIJgXTonpNz0sTBRRF96UDWkNenYOcpqOAyBlwr/Beepr5F1JT+nUQ5zxvym/S9KaQz9cR6Py5zy1fou4h9esAOoEKXEAN2JfZ0Fh6ay+yUrVYuixcARf3Gh2XCj2dlXbR0msU20KaL76YFc7jg==";

        crypto.test(iv, key, cipherText);
        */
        Tasks task = new Tasks();

        String keyPart1 = "d343c1fd7d4b9699da28924a09740994ff22506d15290c086c7dea7a";
        String iV1 = "3fb6887a3b4bea9f115e1570157b94da";
        String cipher1 = "ZZAcKx8YHWYiZC7GvUk+xU2oja/LoMiqTLSSOTzcfaYgo3PtPnbgn5JJvTfKnGb1FBElltzIg68cPEANxe9ZS3YUGdNjJTwxVNFlxfQV3l99qeqlU97y0P9GS0qr4HuCuwexuwYdDJ+VaIO33oXhJA==";
        task.zad1(keyPart1,iV1,cipher1);


    }
}
