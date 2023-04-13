
 interface DefaultStaticExampleInterface {
   default void show() {
      System.out.println("In Java 8- default method - DefaultStaticExampleInterface");
   }
   static void display() {
      System.out.println("DefaultStaticExampleInterface");
   }
 }
 
 abstract class DefaultStaticExampleClass  {
	 
		
		//  @Override 
		  public void show() {
		  System.out.println("In Java 8- default method - DefaultStaticExampleClass");
		  }
		 
	   static void display() {
	      System.out.println(" DefaultStaticExampleClass");
	   }
}

 class DefaultStaticExampleClazz extends DefaultStaticExampleClass implements DefaultStaticExampleInterface  {
	 
	 static void display() {
	      System.out.println(" No Relation to DefaultStaticExampleClazz");
	   }
 }
 
class DefaultStaticExample extends DefaultStaticExampleClazz{
	 
	static void display() {
	      System.out.println(" No Relation to DefaultStaticExample");
	   }
 }

 
public class DefaultExampleClass {
	public static void main(String args[]) {
    
    DefaultStaticExampleInterface.display();
    DefaultStaticExampleClass.display();
    DefaultStaticExampleClazz.display();
    DefaultStaticExample.display();
    

    DefaultStaticExampleClass defaultStaticExampleClass = new DefaultStaticExampleClazz();
    DefaultStaticExampleInterface defaultStaticExample = new DefaultStaticExampleClazz();

    System.out.println("----");

    // Call default method on Class
    defaultStaticExampleClass.show();
    defaultStaticExample.show();

    
    
   }
}