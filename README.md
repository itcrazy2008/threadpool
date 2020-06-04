做个简单的笔记：
理解线程池（池化技术）的一些基本概念和原理
以及利用这些ThreadPool的原理也可以实现一些监控


* Executors 可以new不同类型的线程池
* ExecutorService.execute(Runnable)
* 共同的特点 ThreadPoolExecutor
  * newSingleThreadExecutor
  * newCachedThreadPool
  * newFixedThreadPool
* 线程怎么实现复用
  * 如果有任务就处理，如果没没任务就阻塞（生产者消费者）
  * 阻塞队列（有多种阻塞队列，有不同的选择）
  * 线程池中的线程执行的是task任务的run方法，而不是去执行task任务的start方法启动线程，否则无法管理
* 线程池在构建的时候，它并没有初始化核心线程（延迟加载）
* 线程池的Worker调用take（能阻塞）方法（不断的从阻塞队列获取数据）
* 高3位表达线程池的状态，低29位表达线程数量（32位）
* 线程怎么回收（只要让run方法执行结束）
* 拒绝的策略可以自己实现
* 线程池监控（自己继承ThreadPoolExecutor并实现里面的beforeXXX,afterXXX方法）
* FutureTask 是Runnable, Future的结合体，其实就是生产者消费者模型
* Callable
  * Callable 可以在任务结束的时候提供一个返回值，Runnable 无法提供这个功能
  * Callable 的 call 方法分可以抛出异常，而 Runnable 的 run 方法不能抛出异常。