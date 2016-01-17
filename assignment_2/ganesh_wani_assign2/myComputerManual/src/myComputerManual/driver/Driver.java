package myComputerManual.driver;

import java.util.Vector;
import myComputerManual.util.UserMenu;
import myComputerManual.util.UserManual;
import myComputerManual.util.Logger;
import myComputerManual.dataStore.ComponentName;
import myComputerManual.dataStore.Component;
import myComputerManual.factory.ComponentAbstractFactory;
import myComputerManual.factory.ComponentAbstractFactoryImpl;
import myComputerManual.factory.ComponentFactoryMethod;
import myComputerManual.factory.ComponentFactoryMethodImpl;

public class Driver{
	
	/**
	* Main method
	*Returns void
	*/
	public static void main( String []args){
		if( args.length != 1){
			System.out.println("Please enter value for debugger between 0 and 3");
			System.exit(1);
		}
		//Check for the null parameters
		if( !args[0].matches("[0-9]+") ){
			System.out.println(" Please enter the valid arguments");
			System.exit(1);
		}

		Logger logger = Logger.getInstance();
		logger.setLoggerValue( Integer.parseInt( args[0]));

		UserMenu userManual = new UserMenu();
		Vector<ComponentName> componentList = null;
		componentList =	userManual.acceptInput();
//		System.out.println("Component list is as follows");
//		System.out.println( componentList);

		ComponentAbstractFactory componentFactory = new ComponentAbstractFactoryImpl();

		ComponentFactoryMethod componentFactoryMethod = new 
			ComponentFactoryMethodImpl( componentFactory );

		Vector<Component> realComponents = componentFactoryMethod.createManual( componentList);
		//System.out.println(realComponents);
	
		print( realComponents);
	}

	/**
	* Calls the user manual object to show manual based on the choices
	* Return type: void
	*/
	public static void print( Vector<Component> realComponents){
		UserManual userManual = new UserManual( realComponents);
		userManual.printManual();
	}
}
