import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[]args)
	{
		menu();
	}
	
	public static void menu()
	{
		String sel="";
		Garage g= new Garage();
		while(!sel.equals("3")) {
			
			System.out.println("\nMENU DEL GARAGE:\n\nInserire:\n0)Per immettere un veicolo nel garage\n1)Per rimuovere un veicolo dal garage\n2)Per visualizzare il garage\n3)Per uscire dal programma");
			sel=sc.nextLine();
			
			
			switch(sel)
			{
				case "0":	System.out.println("\n0)Per immettere un'automobile\n1)Per immettere un furgone\n2)Per immettere una moto");
							
							sel=sc.nextLine();
							
							String marca="";
							String anno="";
							String cilindrata="";
							
							while(marca.equals(""))
							{
								System.out.println("Inserire marca: ");
								marca=sc.nextLine();
							}
							
							while(anno.equals(""))
							{
								System.out.println("Inserire anno: ");
								anno=sc.nextLine().replaceAll("\\D+","");
							}
							
							while(cilindrata.equals(""))
							{
								System.out.println("Inserire cilindrata: ");
								cilindrata=sc.nextLine().replaceAll("\\D+","");
							}
							
							
							if(sel.equals("0"))
							{
								g.entraV(a(marca,anno,cilindrata));
								System.out.println("\nAuto inserita correttamente");
							}
							else if(sel.equals("1"))
							{
								g.entraV(f(marca,anno,cilindrata));
								System.out.println("\nFurgone inserito correttamente");
							}
							else if(sel.equals("2"))
							{
								g.entraV(m(marca,anno,cilindrata));
								System.out.println("\nMoto inserita correttamente");
							}
							else
							{
								sel="";
								System.out.println("Numero non riconosciuto.");
							}
							break;
						
				case "1":	if(g.isFree())
							{
								System.out.println("\nIl garage è vuoto, non puoi usare questa funzione.");
							}
							else
							{
								g.stampaG();
								int n=-1;
								while(!(n>=0 && n<15))
								{
									try
									{
										System.out.println("\nSeleziona il veicolo da rimuovere: ");
										n=sc.nextInt();
										sc.nextLine();
									}
									catch(InputMismatchException e)
									{
										System.out.println("Devi inserire un numero.");
										n=-1;
										sc.nextLine();
									}
								}
								g.esceV(n);
								System.out.println("Veicolo rimosso correttamente");
							}
							break;
						
				case "2":	g.stampaG();
							break;
						
				case "3": 	System.out.println("Uscita dal programma in corso..");
							break;
							
				default:	System.out.println("Opzione non riconosciuta. Riprovare.");
							break;
			}
		}
	}
	
	public static VeicoloMotore a(String marca, String anno, String cilindrata)
	{
		/*Chiedere se creare uno "pseudo costruttore" nella classe auto,furgone,moto,ecc senza parametri
		  che esegue il menu e poi richiama il vero costruttore possa andare bene*/
		
		
		String nPorte="";
		String alimentazione="";
		
		while(!nPorte.equals("2") && !nPorte.equals("3") && !nPorte.equals("4") && !nPorte.equals("5"))
		{
			System.out.println("Inserire numero delle porte: ");
			nPorte=sc.nextLine().replaceAll("\\D+","");
		}
		
		while(!alimentazione.equals("0") || !alimentazione.equals("1"))
		{
			System.out.println("Scegliere alimentazione:\n0)Benzina\n1)Diesel");
			alimentazione=sc.nextLine();
			if(alimentazione.equals("0"))
			{
				Auto a = new Auto(marca,anno,cilindrata,nPorte,Auto.Alimentazione.Benzina);
				//scelta=false;
				return a;
			}
			else if(alimentazione.equals("1"))
			{
				Auto a = new Auto(marca,anno,cilindrata,nPorte,Auto.Alimentazione.Diesel);
				//scelta=false;
				return a;
			}
			else
			{
				System.out.println("Numero errato, riprovare.");
			}
		}
		return null;
		
	}
	
	public static VeicoloMotore f(String marca, String anno, String cilindrata)
	{
		String kg="";
		
		while(kg.equals(""))
		{
			System.out.println("Inserire la capacità del furgone in kilogrammi");
			kg=sc.nextLine().replaceAll("\\D+","");
		}
		
		Furgone f = new Furgone(marca, anno, cilindrata, kg);
		return f;
	}
	
	public static VeicoloMotore m(String marca, String anno, String cilindrata)
	{
		String tMotore="";
		
		
		//CONTROLLARE
		while(!tMotore.equals("0") || !tMotore.equals("1"))
		{
			System.out.println("Tempi del motore:\n0) 2\n1) 4");
			tMotore=sc.nextLine().replaceAll("\\D+", "");
			
			if(tMotore.equals("0"))
			{
				Moto m = new Moto(marca, anno, cilindrata, "2");
				return m;
			}
			else if(tMotore.equals("1"))
			{
				Moto m = new Moto(marca, anno, cilindrata, "4");
				return m;
			}
		}
		
		return null;
		
	}
	
}
