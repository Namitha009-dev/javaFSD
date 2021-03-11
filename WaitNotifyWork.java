class WaitNotifyWork
{    int totalNew;
	public static void main(String[] args) throws InterruptedException {
		Task task = new Task();
		
		Thread thread= new Thread(new Task(){

			@Override
			public void run()
			{
				// int total=0;
				// for(int i=1; i<101;i++)
		  //       {
    //              total=total+i;
           

		  //      }
		  //      System.out.println(total);
			}

		});
		thread.start();
        

        //Thread newThread= new Thread();
		Some some = new Some();

		some.doSomething(new Runnable(){
			@Override
			public void run(){
				// int total=0;
				// for(int i=1; i<101;i++)
		  //       {
    //              total=total+i;
           

		  //      }
		  //      System.out.println(total);
			}
		});
        

        Runnable runnable = new Runnable()
        {
        	@Override
			public void run(){
				// int total=0;
				// // for(int i=1; i<101;i++)
		  // //       {
    // //              total=total+i;
           

		  // //      }
		  // //      System.out.println(total);
			}
        };
        WaitNotifyWork hdsghdg= new WaitNotifyWork();
        new Thread(new Runnable()
        {
        	@Override
			public void run(){
				int total=0;
				for(int i=1; i<101;i++)
		        {
                 total=total+i;
           

		       }
		       System.out.println("Sum  " + total);
               
		       hdsghdg.totalNew= total;
		       
			}
        }).start();
         
       System.out.println("Sum saved " + hdsghdg.totalNew); 
      

		synchronized(task)
		{
            System.out.println(Thread.currentThread().getName() + " about to go waiting");
            task.wait(6000);
            System.out.println(Thread.currentThread().getName() +" just woke up" );
		}

		
	}

}
class Some
{
	void doSomething(Runnable run)
	{
        run.run();
	}
}
class Task implements Runnable{
	int total;
	public synchronized void run()
	{
		// for(int i=1; i<101;i++)
		// {
  //          total=total+i;
  //          // System.out.println(Thread.currentThread().getName() + i);

		// }
		// System.out.println(Thread.currentThread().getName() + " done its job");
  //       this.notify();
	}
}