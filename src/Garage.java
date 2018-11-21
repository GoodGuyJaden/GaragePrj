import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Garage 
{
	private VeicoloMotore [] garage = new VeicoloMotore [15];
	//private ArrayList<VeicoloMotore> garage = new ArrayList<VeicoloMotore>();
	
	
	public boolean entraV(VeicoloMotore v)
	{
		for (int i=0;i<garage.length;i++)
		{
			if(garage[i]==null)
			{
				garage[i]=v;
				return true;
			}
			
			else if(i==garage.length-1)
			{
				System.out.println("Nessun posto disponibile");
				return false;
			}
			 
		}
		
		return false;
	}
	
	public void esceV(int sel)
	{
		garage[sel]=null;
	}
	
	
	
	public void stampaG()
	{
		for(int i=0;i<garage.length;i++)
		{
			if(garage[i]==null)
			{
				System.out.println(i+") Libero");
			}
			else
			{
				System.out.println(i+") "+garage[i]);
			}
			
		}
	}
	
	public boolean isFree()
	{
		int n=0;
		for (int i=0;i<garage.length;i++)
		{
			if(garage[i]!=null)
			{
				return false;
			}
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Garage [garage=" + Arrays.toString(garage) + "]";
	}
	
	 /*
	
	public void entraV(VeicoloMotore v)
	{
		if(garage.size()<15)
		{
			garage.add(v);
		}
		else
		{
			System.out.println("Garage pieno.");
		}
	}
	
	public void esceV(int ind)
	{
		System.out.println(garage.get(ind)+" --> Stato: rimosso.");
		garage.remove(ind);
	}
	
	public int getN()
	{
		return garage.size();
	}

	
	
	
	public void stampaG()
	{
		for(int i=0;i<15;i++)
		{
			if(i<garage.size())
			{
				System.out.println(i+") Occupato --> " + garage.get(i));
			}
			else
			{
				System.out.println("Libero");
			}
		}
	}
	*/
	
	
	
}
