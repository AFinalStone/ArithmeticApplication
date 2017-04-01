package com.shi.androidstudy.arithmetic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by  on 2017/4/1 10:35
 */

public class Md5Util {


    //获取文件的Md5
    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    //获取文字的MD5
    public static String getMd5ByText(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    public String getMd5ByApar(File file){
        FileInputStream fis= null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
//        IOUtils.closeQuietly(fis);
//        System.out.println("MD5:"+md5);
        return null;
    }
//    public static void main(String[] args) throws IOException {
//
//        String path = "E:\\commons-codec-1.9-bin.zip";
//
//        String v = getMd5ByFile(new File(path));
//        System.out.println("MD5:" + v.toUpperCase());
//
//            FileInputStream fis= new FileInputStream(path);
//            String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
//            IOUtils.closeQuietly(fis);
//            System.out.println("MD5:"+md5);
//
//        System.out.println("MD5:"+DigestUtils.md5Hex("WANGQIUYUN"));
//    }

}
