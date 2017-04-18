import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Coded by KAZIMIERAS SENVAITIS, Owip™ enterprise, Vilnius, Lithuania.
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
		// ~~~~~ \/ ~~~~~ Datø formatø objektai ~~~~~~~ \/ ~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		SimpleDateFormat mainDateFormat = new SimpleDateFormat("yyyy MM dd");	
		SimpleDateFormat yearAndMonthFormat = new SimpleDateFormat("yyyy-MM:");
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
		// ~~~~~ \/ ~~~~~~~ Kalendoriø objektai ~~~~~~~ \/ ~~~~~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		Calendar currentDate = new GregorianCalendar();
		Calendar userDate = new GregorianCalendar(0, 0, 0, 0, 0, 0);
		
		
		currentDate.set(Calendar.HOUR_OF_DAY, 0);  
	    currentDate.set(Calendar.MINUTE, 0);  
	    currentDate.set(Calendar.SECOND, 0);  
	    currentDate.set(Calendar.MILLISECOND, 0);  
		
		int dayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~ \/ ~~~~~~~~~~~ Iðvedama informacija  ~~~~~~~~~~ \/ ~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
		
		System.out.print("Ðiandienos data: " + mainDateFormat.format( currentDate.getTime() ) );
		System.out.print("\n");
		System.out.print("Dabartinë savaitës diena: ");
			
		switch (dayOfWeek)
		{
			case 1: System.out.print("Sekmadienis");
					System.out.print("\n\n");	
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø sekmadieniø datas: ");
					break;
			case 2: System.out.print("Pirmadienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø pirmadieniø datas: ");
					break;
			case 3: System.out.print("Antradienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø antradieniø datas: ");
					break;
			case 4: System.out.print("Treèiadienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø treèiadieniø datas: ");
					break;
			case 5: System.out.print("Ketvirtadienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø ketvirtadieniø datas: ");
					break;
			case 6: System.out.print("Penktadienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø penktadieniø datas: ");
					break;
			case 7: System.out.print("Ðeðtadienis");
					System.out.print("\n\n");
					System.out.print("Áveskite datà, iki kurios norite suþinoti visø ðeðtadieniø datas: ");
					break;
		}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~ \/ ~~~~~~~~~ Vartotojo ávestis ~~~~~~~~~~ \/ ~~~~~~~~~~~~~~~~~
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
				System.out.println("Deja, datà ávedëte netinkamu formatu. Bandykite dar kartà. Formatas yyyy MM dd");
			}
		} while (1 == check);
		
		user_input.close();
	     
		System.out.print("\n");
	    System.out.print("Paieðka bus atlikta iki: " + mainDateFormat.format( userDate.getTime() ) );
	    System.out.print("\n");
	    
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~ \/ ~~~~~~~~~ Programos loginis branduolys ~~~~~~~~~~ \/ ~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    
	    int tempMonth;
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    // ~~~~~ \/ ~~~~~~~ Dabartinë data PO vartotojo datos ~~~~~~~ \/ ~~~~~~
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
	    // ~~~~~ \/ ~~~~~~~ Dabartinë data PRIEÐ vartotojo datos ~~~~~~~ \/ ~~~~~~
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
	    System.out.println("Programa sëkmingai baigë darbà. ");
	    
	}	// main klasës pabaiga
} 	// uzduotis4 klasës pabaiga
