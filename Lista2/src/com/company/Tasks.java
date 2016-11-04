package com.company;

import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConstants;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * Created by jedrzej_zawojski on 02.11.16.
 */
public class Tasks {
    private Krypto crypto;


    public Tasks() throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
        crypto = new Krypto();
    }

    void zad1(String keyPart, String iV, String ciph) throws FileNotFoundException, UnsupportedEncodingException {
        crypto.setIv(iV);
        crypto.ivParams[0] = crypto.ivParam;

        crypto.cipherBytes[0] = DatatypeConverter.parseBase64Binary(ciph);
        crypto.cipherBytes[0] = Arrays.copyOfRange(crypto.cipherBytes[0],0,16);

        String plain = null;
        long tStart = System.currentTimeMillis();
        String name = "task1";
        PrintWriter writer = new PrintWriter(name+".txt",crypto.getCharset().toString());

        for(int n0 = 8; n0< 16; n0++) {
            for(int n1 = 0; n1 < 16; n1++) {
                for(int n2 = 0; n2 < 16; n2++) {
                    for(int n3 = 0; n3 < 16; n3++) {
                        for(int n4 = 0; n4 < 16; n4++) {
                            for(int n5 = 0; n5 < 16; n5++) {
                                for(int n6 = 0; n6 < 16; n6++) {
                                    for (int n7 = 0; n7 < 16; n7++) {
                                        //System.out.println(n0+" "+n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6+" "+n7);

                                        String testKey =
                                                Integer.toHexString(n0) + Integer.toHexString(n1)
                                                + Integer.toHexString(n2) + Integer.toHexString(n3)
                                                + Integer.toHexString(n4) + Integer.toHexString(n5)
                                                + Integer.toHexString(n6) + Integer.toHexString(n7)
                                                + keyPart;
                                        plain = crypto.decrypt(testKey,0);

                                        if (plain.length() == 0) {
                                            System.out.println("error");

                                        } else {
                                            int k = 0;
                                            for (int i = 0; i < plain.length(); i++) {
                                                char a = plain.charAt(i);
                                                if (Character.isLetterOrDigit(a) || a == ' ' || a == '\n' || a == '.' || a == ',' || a == '?' || a == '!'
                                                        || a == '"' || a == '+' || a == '-' || a == '*' || a == '/' || a == '=' || a == '(' || a == ')'
                                                        || a == '@' || a == '<' || a == '>' || a == ':' || a == ';' || a == '#' || a == '{' || a == '}'
                                                        || a == '[' || a == ']' || a == '~' || a == '`' || a == '\'') {
                                                    k++;
                                                }

                                            }
                                            if (k == plain.length()) {
                                                System.out.println("Key founded");
                                                writer.println(testKey);
                                                writer.println("Text: " + plain);
                                                writer.println("time: " + ((System.currentTimeMillis() - tStart) / 1000.0) + " sek");
                                                writer.flush();
                                            }
                                        }
                                    }
                                    }
                                }
                            }
                        }
                    }
                    System.out.print((100.0 / 16 * (n0)) + (100.0 / 256 * (n1 + 1)) + "%\t---\t");
                    System.out.println(((System.currentTimeMillis() - tStart) / 1000.0) + " sek");
                }
            }
            writer.close();
        }
    }

