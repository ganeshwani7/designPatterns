package myComputerManual.factory;

import myComputerManual.dataStore.Component;
import myComputerManual.dataStore.*;

public class ComponentAbstractFactoryImpl implements ComponentAbstractFactory{
	
	/**
	* Takes the choice as enum of component
	* Returns : The Actaul component 
	*/
	public Component getComponent( ComponentName choice){

		switch( choice ){
			case AMDCPU:
				return new AMDCPU();
			case IntelCPU:
				return new IntelCPU();
			case DDR3RAM:
				return new DDR3RAM();
			case DDR4RAM:
				return new DDR4RAM();
			case HardDrive:
				return new HardDrive();
			case SolidState:
				return new SolidDrive();
			case IntelGraphics:
				return new IntelGraphics();
			case NvidiaGraphics:
				return new NvidiaGraphics();
			case DVD:
				return new DVD();
			case BlueRay:
				return new BlueRay();
			case LCD:
				return new LCD();
			case LED:
				return new LED();
			case Mac:
				return new Mac();
			case Windows:
				return new Windows();
			case YearSupport:
				return new YearSupport();
			case BiennialSupport:
				return new BiennialSupport();
		}
		return null;
	}
}
