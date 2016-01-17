package myComputerManual.factory;

import myComputerManual.dataStore.ComponentName;
import myComputerManual.dataStore.Component;
import myComputerManual.factory.ComponentAbstractFactory;
import myComputerManual.factory.ComponentFactoryMethod;
import java.util.Vector;


public class ComponentFactoryMethodImpl extends ComponentFactoryMethod{
	ComponentAbstractFactory componentFactory;
	
	/**
	* Constructor which initialises factory object
	* Return type : none
	*/
	public ComponentFactoryMethodImpl( ComponentAbstractFactory inFactory){
		componentFactory = inFactory;
	}

	/**
	* Create the Component from the vector of enums
	* Return type : Vector of real components
	*/
	public Vector<Component> createManual( Vector<ComponentName> components){
		Vector<Component> componentList = new Vector<Component>(4);

		for( ComponentName component : components){
			Component realComponent = componentFactory.getComponent( component);
			componentList.add( realComponent);
		}
		return componentList;
	}

}
