class ThreadB extends Thread{
    int total=0;
    public void run(){
        synchronized(this)
        {
            System.out.println("child thread starts calculation!!");
            for(int i=1;i<=100;i++){
               total+=i;
            }
            System.out.println("child thread trying to give notification!!!!");
            this.notify();
        }
    }
}

public class ThreadA
{
	public static void main(String args[]) throws InterruptedException
	{
		//System.out.println("Hello World");
		ThreadB b=new ThreadB();
		b.start();
		synchronized(b)
		{
		    System.out.println("main thread trying to call wait method!!!");
	    	b.wait();
	    	System.out.println("main thread got notifiation!!");
	    	System.out.println(b.total);
		}
	}

}
