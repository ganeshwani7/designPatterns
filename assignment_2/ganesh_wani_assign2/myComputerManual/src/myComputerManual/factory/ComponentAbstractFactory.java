package myComputerManual.factory;

import myComputerManual.dataStore.ComponentName;
import myComputerManual.dataStore.Component;

public interface ComponentAbstractFactory{
	/**
	* Returns the component for the required enum input type
	* return type: Component
	*/
	public Component getComponent(ComponentName choice);
}
