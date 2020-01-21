package ghg;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

  public void run(){
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    synchronized (Flipkart.inventory){
    	while(true) {
    	if(Flipkart.end==10)
    	{
    		System.out.println("All Consumers Are Gone");
    		break;}
    	
    	String str=Flipkart.fruits[ThreadLocalRandom.current().nextInt(0, 4)];
    	int val=Flipkart.inventory.get(str);
  
    	if(val==10)
    	{
    	try {
			Flipkart.inventory.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	else {
    	Flipkart.inventory.put(str, val+1);
    	System.out.println(Thread.currentThread().getName()+ " has produced "+ str+" "+Flipkart.inventory.get(str));
		Flipkart.inventory.notify();
    	}
    	}
    	}
    }
  }

