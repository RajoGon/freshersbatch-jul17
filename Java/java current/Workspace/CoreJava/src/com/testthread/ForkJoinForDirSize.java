package com.testthread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinForDirSize {
	static Future<Long> totalDirSize;
	static Long result;
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		totalDirSize = forkJoinPool.submit(new SizeOfDirTask(new File("C:/Users/gon_r/Desktop/oxygen")));
		System.out.println("*****************************************************Without future Directory size: \n\n\n" + result);
		try {
			result = totalDirSize.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Directory size: " + result);
		forkJoinPool.shutdown();
		System.out.println("Steal count: " + forkJoinPool.getStealCount());
		System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
	}

}

class SizeOfDirTask extends RecursiveTask<Long> {

	File rootDir;
	
	public SizeOfDirTask(File rootDir) {
		this.rootDir = rootDir;	
	}
	
	@Override
	protected Long compute() {
		System.out.println("Computing sise of " + rootDir.getAbsolutePath());
		if(this.rootDir.isFile())
			return rootDir.length();
		
		File childrenFiles[] = rootDir.listFiles();
		List<SizeOfDirTask> tasks = new ArrayList<SizeOfDirTask>();
		
		for(File file: childrenFiles) {
			SizeOfDirTask sizeOfDirTask = new SizeOfDirTask(file);
			sizeOfDirTask.fork();
			tasks.add(sizeOfDirTask);
		}
		long totalDirSize = 0;
		for(SizeOfDirTask sizeOfDirTask: tasks) {
			totalDirSize = totalDirSize + sizeOfDirTask.join();
		}
		return totalDirSize;
	}
	
}