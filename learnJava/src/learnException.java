package learnJava.src;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class learnException {
    public static void main(String[] args) {
        Student stu = new Student("waxuan", 23, 90);
        System.out.println(stu.getName()); 
        try {
            byte[] bs = toGBK("中文");
            System.out.println(Arrays.toString(bs));
            
        } catch (UnsupportedEncodingException e) {
            //TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
        }

   


    }

    static byte[] toGBK(String s) 
    throws UnsupportedEncodingException {
            return s.getBytes("GBK");
    }

    
}
