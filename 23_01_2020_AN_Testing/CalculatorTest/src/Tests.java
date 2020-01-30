
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Tests {
	
   @Mock
   Calculator c;

   @Test
   public void testAdd(){
      when(c.add(1010,90)).thenReturn(1100.0);
      when(c.subtract(200,190)).thenReturn(10.0);
      when(c.multiply(57.0, 3.0)).thenReturn(171.00);
      when(c.divide(2.0, 2.0)).thenReturn(1.00);
		
      Assert.assertEquals(c.add(1010, 90),1100.0,0);
      Assert.assertEquals(c.subtract(200, 190),10.0,0);
      Assert.assertEquals(c.multiply(57.0, 3.0),171.0,0);
      Assert.assertEquals(c.divide(2.0, 2.0),2.0,1);
       
      InOrder inOrder = inOrder(c);
      
      inOrder.verify(c).add(1010,90);
      inOrder.verify(c).subtract(200,190);
      inOrder.verify(c).multiply(57,3);
      inOrder.verify(c).divide(2.0, 2.0);
   }
}