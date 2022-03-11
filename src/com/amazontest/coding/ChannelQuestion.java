package com.amazontest.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChannelQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listTest = Arrays.asList(1,45,90,47,56);
		maximumChannelQuality(listTest, 2);

	}
	
	
public static long maximumChannelQuality(List<Integer> packets, int channels) {
	
	int size = packets.size();
	if(size==channels)
	{
		
	}
	else
	{
		packets.forEach(i -> System.out.println(i));


		Collections.sort(packets);
		packets.forEach(i -> System.out.println(i));
	}
	return channels;

}


}
