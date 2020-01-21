package ghg;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
	int consumed;
	Consumer(int consumed)
	{
		this.consumed=consumed;
	}

  public void run(){
    while(true){
      synchronized (Flipkart.inventory){
    	  String str=Flipkart.fruits[ThreadLocalRandom.current().nextInt(0, 4)];
    	  System.out.println(Thread.currentThread().getName()+" wants "+ str);
      	int val=Flipkart.inventory.get(str);
      	
      	//System.out.println(Thread.currentThread().getName()+" has been notified");
      	if(val==0)
      	{
      		try {
				Flipkart.inventory.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	}
      	else {
      		this.consumed++;
      		Flipkart.inventory.put(str,val-1);
      	    System.out.println(Thread.currentThread().getName()+ " has consumed "+ str+ " and the current quanitity of " +str+" is "+Flipkart.inventory.get(str));
      	  Flipkart.inventory.notify();
      	  // ** ADDED FUNCTIONALITY: ALL CONSUMERS CAN CONSUME ONLY TEN PRODUCTS
      	    if(this.consumed==10)
      	    {
      	    	Flipkart.end++;
      	    	System.out.println(Thread.currentThread().getName()+" has consumed TEN products and can't do anything now. he is going home");
      	    	break;
      	    	
      	    }
      	    try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	}
      }
      }
      }
  }


