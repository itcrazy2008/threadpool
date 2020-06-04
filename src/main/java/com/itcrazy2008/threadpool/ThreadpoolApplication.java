package com.itcrazy2008.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadpoolApplication {

	public static void main(String[] args) {
//		//new一个有3个线程组成的线程池
//		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		//启动线程
//		executorService.execute(new ThreadDemo());
//		//停止线程池
//		executorService.shutdown();

		//使用自定义的线程池
		//new一个有3个线程组成的线程池
		ExecutorService executorService = new ThreadPoolMonitor(3,
				3,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		//启动线程
		executorService.execute(new ThreadDemo());
		executorService.execute(new ThreadDemo());
		executorService.execute(new ThreadDemo());
		executorService.execute(new ThreadDemo());
		executorService.execute(new ThreadDemo());
		executorService.execute(new ThreadDemo());

		//停止线程池
		executorService.shutdown();
	}

}
