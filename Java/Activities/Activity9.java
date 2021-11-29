package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	
	public static void main(String[] args)
	{
		List<String> myList =new ArrayList<>();
		myList.add("Joe");
		myList.add("MEg");
		myList.add("Beth");
		myList.add("Amy");
		myList.add("removable");
		for(int i=0;i<5;i++)
		{
			System.out.println(myList.get(i));
		}
		
		System.out.println(myList.get(2));
		boolean check=(myList.contains("Joe"));
		
		System.out.println(myList.size());
		myList.remove("removable");
		System.out.println(myList);
				
	}

}
