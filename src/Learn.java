import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.*;

import com.java.EnumExample;

public class Learn {

	public static void main(String[] args) throws Exception {
		// ClassNotFoundException, NoSuchMethodException, SecurityException,
		// IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		
		int[] primNum = new int[] {0, 3, 1, 0, 5, 0, 8,0,7};
		
		int i=0,k=0;
		while( k< primNum.length)
		{
			if(primNum[k]!=0)
			{
				primNum[i] = primNum[k];
				i++;
			}
			k++;
		}
		k=0;
		while(k<primNum.length)
		{
			if(0< i-k-1)
			{
				primNum[primNum.length-1-k] = 0;
			}
			System.out.println("element :" +primNum[k]);

			k++;
		}

	}
}

/*

  MultiThread (Hi alternate Hello) 
  - Notify, wait, -- these 2 methods are from
  Object class itself (Hi alternate Hello) 
  - join() -- Continuous prints from this thread then only goes onto further Thread 
  Thread priority- 1 to 10
  Thread Vs Runnable Vs Callable Future, 
  FutureTask Future & CompletableFuture
  ExecutorService with Callable 
  Volatile Keyword Transient - related to
  Serialization and no relation to threads 
  Java8- Function & Bi,Tri Enum DSA
 
  Collect()
  Collections.groupingBy()
  Stream & parellelStream 
  sequential,
  reduce, 
  map,flatMap, flatMapToInt,
  filter,findAny,findFirst,
  boxed() 
  distinct() 
  sorted() 
  toList(): toSet(): toMap(): joining(): 
  averagingInt(), averagingDouble(), averagingLong()
  groupingBy(): 
  ForkJoinPool customThreadPool = new ForkJoinPool(4); 
  		is usedTo set threadSize in ParellelStream
  		
  		*/

//--> Not studying "BlockingQueue" And "PriorityBlockingQueue"

/* BinarySearch Tree element removal */


 
 


