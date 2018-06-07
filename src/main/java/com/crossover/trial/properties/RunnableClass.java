package com.crossover.trial.properties;
import com.crossover.trial.properties.loader.PropertiesLoader;

public class RunnableClass implements Runnable {

	private String[] args;
	private String threadName;
	private Thread thread;
	
	public RunnableClass(String[] args,String threadName) {
		this.args=args;
		this.threadName=threadName;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running " + this.threadName);

		try {
			for(int i=3;i>0;i--) {
				System.out.println("Thread: " + this.threadName);
				PropertiesLoader loader = new PropertiesLoader();
		        loader.load(args);
		        System.out.println(loader.getProperties());
		        Thread.sleep(6000);
			}
		}
		catch(InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
		
		}
	
	public void start(){
		System.out.println("Starting " + threadName);
		if(thread==null) {
			thread=new Thread(this,threadName);
			thread.start();
		}
		
	}
	}
