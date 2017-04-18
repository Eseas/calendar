import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Coded by KAZIMIERAS SENVAITIS, Owip� enterprise, Vilnius, Lithuania.
// 'Our Work Is Passion'
// Began: 2015 02 13. Worked ~4h 
// Working day: 2015 02 14. Worked: ~2h
// Working day: 2015 02 17. Worked: ~2h
// Working day: 2015 02 18. Testing: ~1h

public class Kalendorius
{

	public static void main(String[] args) 
	{
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// ~~~~~ \/ ~~~~~ Dat� format� objektai ~~~~~~~ \/ ~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		SimpleDateFormat mainDateFormat = new SimpleDateFormat("yyyy MM dd");	
		SimpleDateFormat yearAndMonthFormat = new SimpleDateFormat("yyyy-MM:");
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
		// ~~~~~ \/ ~~~~~~~ Kalendori� objektai ~~~~~~~ \/ ~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		Calendar currentDate = new GregorianCalendar();
		Calendar userDate = new GregorianCalendar(0, 0, 0, 0, 0, 0);
		
		
		currentDate.set(Calendar.HOUR_OF_DAY, 0);  
	    currentDate.set(Calendar.MINUTE, 0);  
	    currentDate.set(Calendar.SECOND, 0);  
	    currentDate.set(Calendar.MILLISECOND, 0);  
		
		int dayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~ \/ ~~~~~~~~~~~ I�vedama informacija  ~~~~~~~~~~ \/ ~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
		
		System.out.print("�iandienos data: " + mainDateFormat.format( currentDate.getTime() ) );
		System.out.print("\n");
		System.out.print("Dabartin� savait�s diena: ");
			
		switch (dayOfWeek)
		{
			case 1: System.out.print("Sekmadienis");
					System.out.print("\n\n");	
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� sekmadieni� datas: ");
					break;
			case 2: System.out.print("Pirmadienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� pirmadieni� datas: ");
					break;
			case 3: System.out.print("Antradienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� antradieni� datas: ");
					break;
			case 4: System.out.print("Tre�iadienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� tre�iadieni� datas: ");
					break;
			case 5: System.out.print("Ketvirtadienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� ketvirtadieni� datas: ");
					break;
			case 6: System.out.print("Penktadienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� penktadieni� datas: ");
					break;
			case 7: System.out.print("�e�tadienis");
					System.out.print("\n\n");
					System.out.print("�veskite dat�, iki kurios norite su�inoti vis� �e�tadieni� datas: ");
					break;
		}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~ \/ ~~~~~~~~~ Vartotojo �vestis ~~~~~~~~~~ \/ ~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
		Scanner user_input = new Scanner(System.in);
		
		
		int check = 1;
		do
		{
			try
			{	   
				String userInput = user_input.nextLine();
				userDate.setTime( mainDateFormat.parse(userInput) );
				check = 0;
			}
			catch (ParseException e)
			{
				System.out.println("Deja, dat� �ved�te netinkamu formatu. Bandykite dar kart�. Formatas yyyy MM dd");
			}
		} while (1 == check);
		
		user_input.close();
	     
		System.out.print("\n");
	    System.out.print("Paie�ka bus atlikta iki: " + mainDateFormat.format( userDate.getTime() ) );
	    System.out.print("\n");
	    
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~ \/ ~~~~~~~~~ Programos loginis branduolys ~~~~~~~~~~ \/ ~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    
	    int tempMonth;
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    // ~~~~~ \/ ~~~~~~~ Dabartin� data PO vartotojo datos ~~~~~~~ \/ ~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    
	    if ( currentDate.after(userDate) || currentDate.equals(userDate) )
	    {
	    	
	    	while ( currentDate.after(userDate) || currentDate.equals(userDate) )
	    	{
	    		System.out.print( yearAndMonthFormat.format( currentDate.getTime() ) );
    			System.out.print(" ");
    			tempMonth = currentDate.get(Calendar.MONTH);
    			
    			while( tempMonth == currentDate.get(Calendar.MONTH) && ( currentDate.after(userDate) || currentDate.equals(userDate) ) )
    			{
    				System.out.print( currentDate.get(Calendar.DAY_OF_MONTH) );
    				currentDate.add( Calendar.DAY_OF_MONTH, -7 );    		
    				if ( tempMonth != currentDate.get(Calendar.MONTH) ) break;
    				if ( currentDate.before(userDate) ) break;
    				System.out.print(", ");
    			}
    			System.out.print("\n");	    		
	    	} 
	    }
	    
	    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    // ~~~~~ \/ ~~~~~~~ Dabartin� data PRIE� vartotojo datos ~~~~~~~ \/ ~~~~~~
	    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    
	    else 
	    {
    		while (currentDate.before(userDate))
    		{
    			
    			System.out.print( yearAndMonthFormat.format( currentDate.getTime() ) );
    			System.out.print(" ");
    			tempMonth = currentDate.get(Calendar.MONTH);
    			
    			while( tempMonth == currentDate.get( Calendar.MONTH ) && ( currentDate.before(userDate) || currentDate.equals(userDate) ) )
    			{
    				System.out.print( currentDate.get(Calendar.DAY_OF_MONTH) );
    				currentDate.add( Calendar.DAY_OF_MONTH, 7 );    		
    				if ( tempMonth != currentDate.get( Calendar.MONTH ) ) break;
    				if ( currentDate.after(userDate) ) break;
    				System.out.print(", ");
    				
    			}
    			System.out.print("\n");
    		} 
	    }
	   
	    
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~ \/ ~~~~~~~~~~~~~~ Programos pabaiga ~~~~~~~~~~~~~~~ \/ ~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	   
	    
	    System.out.print("\n");
	    System.out.println("Programa s�kmingai baig� darb�. ");
	    
	}	// main klas�s pabaiga
} 	// uzduotis4 klas�s pabaiga
