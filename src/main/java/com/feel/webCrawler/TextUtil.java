package com.feel.webCrawler;

/**
 * Created by admin-pc on 2016/11/3.
 */
public class TextUtil {
    public static boolean isEmpty(String url){
        if(null!=url&&!"".equals(url)){
            return false;
        }else{
            return true;
        }
    }
}