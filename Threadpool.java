import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Processor implements Runnable {
	private int number;
	public Processor(int number)
	{
	    this.number=number;
	}
	public void run()
	{
		System.out.println(number);
	}
}

public class Main{
	public static void main(String[] args)
	{
		ExecutorService executor=Executors.newFixedThreadPool(5);//create a pool of 5 threads using executor framework 
		for (int i = 1; i <=10; i++) 
		{
		    Runnable p=new Processor(i);//create a instance
		    executor.execute(p);//it will execute the instance(task) by giving it to any one of the thread in thread pool 
		}
		executor.shutdown();//shutdown the pool i.e;no other tasks can be executed by this thread pool
	}
}
