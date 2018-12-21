package org.nagarro.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread started");
		// If we Execute(Starts) more tasks than the size of the threadpool, it will wait until the task gets finished and the one
		// in the queue of submitted task list will get picked up.
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new LoopTask());
		executorService.execute(new LoopTask());
		executorService.execute(new LoopTask());
		
		// Executing(Starting) 3 more task which is more than the aforementioned fixedthreadpool size , i.e 3
		executorService.execute(new LoopTask());
		executorService.execute(new LoopTask());
		executorService.execute(new LoopTask());
		System.out.println("Main thread ended");
		
		executorService.shutdown();
		
		// If we execute after shutting down the executor service, it will throw runtime exception, i.e rejectedExecution
		//
		executorService.execute(new LoopTask());
	}

}
