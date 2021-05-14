package cn.stylefeng.guns.core.util;

import java.io.*;

public class BytesUtils {
    /**
     * 将对象转化为字节数组
     * @author lichmama
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] objectToBytes(Object object) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        byte[] bytes = baos.toByteArray();
        baos.close();
        oos.close();
        return bytes;
    }

    /**
     * 将字节数组转化为对象
     * @author lichmama
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static <T> T bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object object = ois.readObject();
        bais.close();
        ois.close();
        return (T) object;
    }

}
