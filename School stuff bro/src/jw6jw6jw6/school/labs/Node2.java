package jw6jw6jw6.school.labs;
public class Node2
{
		private String value;
		private Node2 next;
		
		public Node2(String num, Node2 initNext)
		{
			value = num;
			next = initNext;
		}
		
		public String getval()
		{
			return value;
		}
		
		public Node2 getNext()
		{
			return next;
		}
		
		public void setval(String newnum)
		{
			value = newnum;
		}
		
		public void setNext(Node2 nex)
		{
			next = nex;
		}
}
