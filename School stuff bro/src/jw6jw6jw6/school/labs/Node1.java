package jw6jw6jw6.school.labs;
public class Node1
{
		private int coeff;
		private int degree;
		private Node1 next;
		
		public Node1(int c, int d, Node1 initNext)
		{
			coeff = c;
			degree = d;
			next = initNext;
		}
		
		public int getCoeff()
		{
			return coeff;
		}
		
		public int getdegree()
		{
			return degree;
		}
		
		public Node1 getNext()
		{
			return next;
		}
		
		public void setCoeff(int newCoeff)
		{
			coeff = newCoeff;
		}
		
		public void setDegree(int deg)
		{
			degree = deg;
		}
		
		public void setNext(Node1 p)
		{
			next = p;
		}
}
