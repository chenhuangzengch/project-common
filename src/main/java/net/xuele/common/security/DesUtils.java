package net.xuele.common.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * 
 */
public class DesUtils {

    private final static String ALGORITHM = "DES";
    public static final String  UTF_8     = "utf-8";
    private static byte[] iv = {0, 1, 2, 3, 4, 5, 6, 7};

    /**
     */
    public final static String decrypt(String data, String key) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes(UTF_8)), key.getBytes(UTF_8)), UTF_8);
    }

    /**
     */
    public final static String decryptBase64(String data, String key) throws Exception {
        data = new String(Base64.decodeBase64(data));
        return new String(decryptByIvParameterSpec(hex2byte(data.getBytes(UTF_8)), key.getBytes(UTF_8)), UTF_8);
    }

    /**
     */
    public final static String encrypt(String data, String key) throws Exception {
        return byte2hex(encrypt(data.getBytes(UTF_8), key.getBytes(UTF_8)));
    }

    /**
     */
    public final static String encryptBase64(String data, String key) throws Exception {
        String encrypted = byte2hex(encryptByIvParameterSpec(data.getBytes(UTF_8), key.getBytes(UTF_8)));
        return Base64.encodeBase64String(encrypted.getBytes(UTF_8));
    }

    // ==============================
    /**
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    /**
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    private static byte[] encryptByIvParameterSpec(byte[] data, byte[] key) throws Exception {
        IvParameterSpec spec = new IvParameterSpec(iv);
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, spec);
        return cipher.doFinal(data);
    }

    /**
     */
    private static byte[] decryptByIvParameterSpec(byte[] data, byte[] key) throws Exception {
        IvParameterSpec spec = new IvParameterSpec(iv);
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, securekey, spec);
        return cipher.doFinal(data);
    }

    private static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) throw new IllegalArgumentException("the content must %2 =0");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) hs = hs + "0" + stmp;
            else hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        String md5Password = "xsdfasdfasdf3egfadaa";
        String str = DesUtils.encrypt("测试", md5Password);
        System.out.println("str: " + str);
        str = DesUtils.decrypt(str, md5Password);
        System.out.println("str: " + str);
    }
}
