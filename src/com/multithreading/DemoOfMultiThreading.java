package com.multithreading;

import java.util.Scanner;

public class DemoOfMultiThreading {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Console");
		Demo d = new Demo();
		d.start();
		d.join();
		
		
		System.out.println(d.returnInt("687"));
		System.out.println(d.returnInt("687"));
		
		Demo d2 = new Demo();
		d2.start();
		

		
		System.out.println(d.returnInt("687"));
		System.out.println(d.returnInt("687"));
		
		Demo d3 = new Demo();
		d3.start();
		d3.join();


	}
}
	
	class Demo extends Thread
	{
		public void run()
		{
			for(int i=0; i< 100; i++)
			{
			System.out.println("----" + Thread.currentThread().getName());
			}
		}
		
		public int returnInt(String s)
		{
			return Integer.valueOf(s);
		}
		
	}


