package moje.proj;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Fibonacci
{

	ArrayList<Integer> fibList = new ArrayList<Integer>();


	public String calculateSum()
	{
		fibList.add(0);
		fibList.add(1);
		int i = 2;
		int max = 0;
		int result = 0;
		
		while (max < 4000000) {
			fibList.add(fibList.get(i-1) + fibList.get(i-2));
			max = fibList.get(i);
			i++;
			if (max % 2 == 0)
				result += max;
		}	
		String sum;
		sum = String.valueOf(result);
		for (Integer integer : fibList)
		{
			System.out.println(integer);
		}
	
		return sum;
	}

	
	
	}


