package com.feel.masterWorker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable{

	private Queue<Object> workQueue;
	private Map<String, Object> resultMap;
	
	public void setWorkQueue(Queue workQueue){
		this.workQueue = workQueue;
	}
	
	public void setResultMap(Map resultMap){
		this.resultMap = resultMap;
	}
	
	public Object handle(Object obj){
		
		try {
			//do job 实际的处理操作
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public void run() {
		while(true){
			Object obj = this.workQueue.poll();
			if(obj == null) break;
			//执行的结果
			Object re = handle(obj);
			//执行结果承装到resultMap里
			this.resultMap.put(Integer.toString(obj.hashCode()), re);
		}
		
	}

}
