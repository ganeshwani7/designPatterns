package myComputerManual.factory;

import myComputerManual.dataStore.ComponentName;
import myComputerManual.dataStore.Component;
import java.util.Vector;

public abstract class ComponentFactoryMethod{
	/**
	* Calls the create Manual method to print the manual of purchased components
	* Return type : void
	*/
	void orderManual( Vector<ComponentName> components){
		createManual( components);
	}
	
	/**
	* 
	* Return type : Vector of components
	*/
	public abstract Vector<Component> createManual( Vector<ComponentName> components);
}
