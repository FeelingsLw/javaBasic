package com.feel.masterWorker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin-pc on 2016/10/26.
 */
public class Main {

    public static void main(String[] args) {

        Master m = new Master(new Worker(), 10);
        Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
        for (int i = 1; i <= 100; i++) {
            m.submit(i);
        }
        m.execute();
        long start = System.currentTimeMillis();
        long end = 0L;
        while(true){
            if(m.isComplete()){
                end = System.currentTimeMillis();
                resultMap = m.getResultMap();
                break;
            }
        }

        long result = 0L;
        for(Map.Entry<String, Object> entry : resultMap.entrySet()){
            result += (Integer)entry.getValue();
        }

        System.out.println("耗时:" + (end - start) + " , result = " + result);


    }
}
