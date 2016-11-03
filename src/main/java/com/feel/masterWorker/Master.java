package com.feel.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	//workQueue:存放任务的集合
	private Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	
	//存放线程的集合（每一个线程与work一一对应）
	private Map<String, Thread> threadMap = new HashMap<String, Thread>();
	
	//结果集集合
	private Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	
	public Master(Worker worker, int workerCount){
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for(int i = 0; i < workerCount; i ++){
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	
	/**
	 * 添加任务的方法
	 * @param i 实际的任务对象
	 */
	public void submit(Object i) {
		this.workQueue.add(i);
	}
	
	/**
	 * 执行方法
	 */
	public void execute(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			entry.getValue().start();
		}
	}
	
	/**
	 * 返回执行的结果集
	 */
	public Map<String, Object> getResultMap(){
		return this.resultMap;
	}
	
	/**
	 * 判断是否所有的worker都执行完毕
	 * @return
	 */
	public boolean isComplete(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	
	

}
