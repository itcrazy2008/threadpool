package com.itcrazy2008.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//继承ThreadPoolExecutor,实现对线程池的监控
public class ThreadPoolMonitor extends ThreadPoolExecutor {
  public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
      BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  @Override
  public boolean prestartCoreThread() {
    System.out.println("before prestartCoreThread");
    boolean result =  super.prestartCoreThread();
    System.out.println("after prestartCoreThread");
    return result;
  }

  @Override
  public int prestartAllCoreThreads() {
    System.out.println("before prestartAllCoreThreads");
    int result = super.prestartAllCoreThreads();
    System.out.println("after prestartAllCoreThreads");
    return result;
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    System.out.println("before beforeExecute threadnme:" + t.getName() );
    super.beforeExecute(t, r);
    System.out.println("after beforeExecute");
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    System.out.println("before afterExecute");
    super.afterExecute(r, t);
    System.out.println("after afterExecute");
  }
}
