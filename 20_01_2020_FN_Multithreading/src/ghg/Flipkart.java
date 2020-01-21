package ghg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Flipkart {

  public static HashMap<String,Integer> inventory = new HashMap<>();
  public static String[] fruits= {"Apple","Banana","Orange","Grapes"};
  public static int i=0;
public static int end=0; 

  public static void main(String[] args) {
	  inventory.put("Apple",0);
	  inventory.put("Banana",0);
	  inventory.put("Grapes",0);
	  inventory.put("Orange",0);
    System.out.println("I'm Flipkart");
    
    for(int i=1;i<=3;i++){
        new Thread(new Producer(), "Producer" + i).start();
      }
    for(int i=1;i<=10;i++){
      new Thread(new Consumer(0), "Consumer_" + i).start();
    }
  }

}
