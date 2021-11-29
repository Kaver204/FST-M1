package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(123);
		hs.add(321);
		hs.add(654);
		hs.add(222);
		hs.add(1111);
		System.out.println(hs);
		System.out.println(hs.size());
		hs.remove(321);
		System.out.println(hs);
		try{
			hs.remove(3);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		boolean check=hs.contains(1111);
		System.out.println(hs);

	}

}
