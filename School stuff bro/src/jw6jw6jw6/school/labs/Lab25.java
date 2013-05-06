package jw6jw6jw6.school.labs;

import java.util.*;
import java.io.*;

public class Lab25 
{
	static ArrayList<String> lines = new ArrayList<String>();
	static ArrayList<String> tmp = new ArrayList<String>();
	static TreeMap<Character,Integer> words = new TreeMap<Character,Integer>();
	static String input = "";
	public static void main(String args[])
	{
		long StartSystemTime = System.currentTimeMillis();
		input1();
		for(String le:lines)
		{
			if(le.length()>0)
			{
			le = le.toLowerCase();
			tmp.addAll(Arrays.asList(le.split("[\\W]+")));
			input+=le;
			}
		}
		for(int x=0;x<tmp.size();x++)
		{
			String tmp1 = tmp.get(x);
			char[] tmp2 = tmp1.toCharArray();
			for(int q=0; q<tmp1.length(); q++)
			{
				if(words.containsKey(tmp2[q]))
				{
					int temp = words.get(tmp2[q]).intValue();
					temp++;
					words.remove(tmp2[q]);
					words.put(tmp2[q], temp);
				}
				else
				{
					words.put(tmp2[q], 1);
				}
			}
		}
		Map<Character, Integer> sortedMap = sortByComparator(words);
		String word2 = "";
		Character[] list =sortedMap.keySet().toArray(new Character[1]);
//		for(int x=0;x<tmp.size();x++)
//		{
//			char[] tmp2 = tmp.get(x).toCharArray();
			char[] tmp2 = input.toCharArray();
			for(int q=0; q< tmp2.length; q++)
			{
				for(int r=0; r<list.length; r++)
				{
					if(list[r] == tmp2[q])
						if(r == list.length-1)
							word2+=list[0];
						else
							word2+=list[r+1];
				}
				if(tmp2[q] == ' ')
					word2+=' ';
				
			}
			
//		}
		long EndSystemTime = System.currentTimeMillis();
		long time = EndSystemTime - StartSystemTime;
		System.out.println(sortedMap);
		System.out.println(word2);
		System.out.println(input);
		System.out.println(time/1000f +" seconds");
//		System.out.println(words);
//		System.out.println(words.size());
	}
	
	private static Map sortByComparator(Map unsortMap) {
		 
		List list = new LinkedList(unsortMap.entrySet());
 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o2, Object o1) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	public static void input1()
	{
		BufferedReader br = null;
		 
		try 
		{
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(new File("story.txt")));
 
			while ((sCurrentLine = br.readLine()) != null)
			{
				lines.add(sCurrentLine);
			}
 
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

