package jw6jw6jw6.school.labs;
import java.math.*;
public class Lab18LL
{
	public static void main(String args[])
	{
		Node1 p = null;
		Node1 front = null;
		Node1 temp = null;
		int polysize = uni.parse(uni.ask("Enter the degree of the polynomial"));
		
		int coeff = uni.parse(uni.ask("Enter coeff for x^"+polysize));
		p= new Node1(coeff, polysize, null);
		front = p;
		temp = p;
		
		for(int x = polysize-1; x>=0; x--)
		{
		coeff = uni.parse(uni.ask("Enter coeff for x^"+x));
		p = new Node1(coeff, x, null);
		temp.setNext(p);
		temp = p;
		}
		p = front;
		while(p != null)
		{
			Node1 temp1 = p.getNext();
			System.out.print(p.getCoeff()+"X^"+p.getdegree()+(temp1 == null ? "" : "+"));
			p=p.getNext();
		}
		int x = uni.parse(uni.ask("Enter the the value of the polynomial"));
		p=front;
		double add=0.0;
		while(p != null)
		{
			add+=p.getCoeff() * Math.pow(x , p.getdegree());
			p=p.getNext();
		}
		uni.notify("The value of your polynomial is "+add);
	}
}


