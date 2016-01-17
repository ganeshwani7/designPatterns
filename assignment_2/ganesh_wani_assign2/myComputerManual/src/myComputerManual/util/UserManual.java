package myComputerManual.util;

import myComputerManual.dataStore.Component;
import java.util.Vector;

public class UserManual{
	Vector<Component>allComponents = null;
	Logger logger = Logger.getInstance();

	/**
	* Constructor which initialises the vector of components
	* Return type: none
	*/
	public UserManual( Vector<Component> allComponentsIn){
		this.allComponents = allComponentsIn;
	}
	
	/**
	* Prints the manual based upon the user choices
	* Return type: void
	*/
	public void printManual(){
/*
		int pageNumber = 1;
		String title = String.format( "Component Name" +
				" \t\t\t\t\t\t\t\t\t ...............     PageNumber\n" );
//		System.out.print( title);
//		System.out.println( "Page Number");
		logger.write( write);

		for( int i=0; i< allComponents.size(); i++){

			System.out.printf("\t %-100s",allComponents.get(i).getDescription());

//			System.out.print( "\t" +allComponents.get(i).getDescription() +
//				" \t\t\t\t\t\t ...............     ");
			System.out.println( pageNumber );
			pageNumber += allComponents.get(i).getTotalLength();
		}
*/
		printTableContent();
		printListOfFigures();
		printActualManual();
		printGlossary();
	}

	/**
	* Prints the table content
	* Return type: void
	*/
	public void printTableContent(){
		int pageNumber = 1;

		String title = String.format("\n Component Name" +
				" \t\t\t\t\t\t\t\t ...............     Page Number\n");
		logger.write(0, title);
		logger.write(4, title);

		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			body = String.format( "\t %-100s %s\n", 
				allComponents.get(i).getGlossary(), pageNumber );

//			System.out.printf( "\t %-100s ", allComponents.get(i).getGlossary() );
//			System.out.printf( "%s\n",pageNumber );
			logger.write(0, body);
			logger.write(4, body);
			pageNumber += allComponents.get(i).getTotalLength();
		}
		logger.write(0, "\n");
		logger.write(4, "\n");
//		System.out.println("");
	}

	/**
	* Prints the list of figures present 
	* Return type: void
	*/
	public void printListOfFigures(){
		int pageNumber = 1;
		String title = String.format(" List of figures " +
				" \t\t\t\t\t\t\t\t ...............     PageNumber\n");
//		System.out.printf( " List of figures " +
//				" \t\t\t\t\t\t\t\t ...............     ");
//			System.out.println( "Page Number");
		logger.write( 1, title);
		logger.write( 4, title);

		String body = null;

		for( int i=0; i< allComponents.size(); i++){
			for( int j =0; j< allComponents.get(i).getFigureNumber(); j++){

				body = String.format("\t %-100s%s\n", 
					allComponents.get(i).getGlossary() + " Figure " +(j+1),
					pageNumber + j
					);
				logger.write( 1, body);
				logger.write( 4, body);
//				System.out.printf( "\t %-100s", 
//					allComponents.get(i).getGlossary() + " Figure " +(j+1) );
//				System.out.printf( "%s\n", pageNumber+j );
			}
			pageNumber += allComponents.get(i).getTotalLength();
		}
	}


	/**
	* Prints the whole actual manual
	* Return type: void
	*/
	public void printActualManual(){
		int pageNumber = 1;
		String title = String.format("\n Component " +
				" \t\t\t\t\t\t\t\t ...............   \t  Page Number\n");
		logger.write( 2, title);
		logger.write( 4, title);

		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			body = String.format("\t%s\n\t\t%-100s%s\n",
				allComponents.get(i).getGlossary(), 
				allComponents.get(i).getDescription(), pageNumber);
			logger.write( 2, body);
			logger.write( 4, body);
			for( int j =0; j< allComponents.get(i).getFigureNumber(); j++){
				body = String.format("\t\t%-100s%s\n", 
					allComponents.get(i).getGlossary() + " Figure " +(j+1),
					pageNumber + j
					);
				logger.write( 2, body);
				logger.write( 4, body);

				//System.out.printf( "\t %-100s", 
				//	allComponents.get(i).getGlossary() + " Figure " +(j+1) );
				//System.out.printf( "%s\n", pageNumber+j );
			}
			pageNumber += allComponents.get(i).getTotalLength();
		}

	}

	/**
	* Prints the glossary of the manual
	* Return type: void
	*/
	public void printGlossary(){
		String title = String.format("\nGlossary\n");
		logger.write( 3, title);
		logger.write( 4, title);

//		System.out.println("\nGlossary");
		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			body = String.format("\t" + allComponents.get(i).getGlossary()+ "\n");
			logger.write(3, body);
			logger.write(4, body);
//			System.out.println("\t" + allComponents.get(i).getGlossary());
		}
	}
}
