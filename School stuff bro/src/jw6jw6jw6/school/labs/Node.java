package jw6jw6jw6.school.labs;
public class Node
{
		private int number;
		private Node next;
		
		public Node(int num, Node initNext)
		{
			number = num;
			next = initNext;
		}
		
		public int getnum()
		{
			return number;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setnum(int newnum)
		{
			number = newnum;
		}
		
		public void setNext(Node nex)
		{
			next = nex;
		}
}
