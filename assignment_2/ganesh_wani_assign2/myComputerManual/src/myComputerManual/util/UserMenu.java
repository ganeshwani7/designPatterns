package myComputerManual.util;

import java.util.Vector;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import myComputerManual.dataStore.ComponentName;

public class UserMenu{
	
	int totalComponents = 8;
	
	private List<List<String>> tempList= null;
	private Vector<ComponentName> componentList = new Vector<ComponentName>();

	/**
	* Accepts the input from the user
	* Returns the Vector of enums based on the user choices
	*/
	public Vector<ComponentName> acceptInput(){
		initializeMenu();
		
		Scanner in = new Scanner( System.in);

		String choice = null;

		for( int i =0; i< totalComponents/2; i++){
			List<String>list = tempList.get(i);
			for( int count = 0; count < 3; count++){
				System.out.println( list.get(count));
			}
			System.out.println("");

			choice = in.nextLine();
			try{
				if( Integer.parseInt( choice) == 1){
				/**
				*	valueOf() for an enum takes a string and returns the Enum
				*	constant
				*/
					componentList.add( ComponentName.valueOf(list.get(3)));
				}
				else if( Integer.parseInt( choice) == 2){
					componentList.add( ComponentName.valueOf(list.get(4)));
				}
				else{
					System.out.println("Please enter the choice 1 or 2");
					i--;
					continue;
				}
			}catch( Exception e){
				e.printStackTrace();
				i--;
				System.out.println("Please enter the valid option");
				continue;
			}
			System.out.println("");
		}

		for( int i = totalComponents/2; i< totalComponents; i++){
		//	Scanner in = new Scanner( System.in);
			List<String>list = tempList.get(i);
			for( int count = 0; count < 4; count++){
				System.out.println( list.get(count));
			}
			System.out.println("");
			
			choice = in.nextLine();
			try{
				if( Integer.parseInt( choice) == 1){
					componentList.add( ComponentName.valueOf(list.get(4)));
				}
				else if( Integer.parseInt( choice) == 2){
					componentList.add( ComponentName.valueOf(list.get(5)));
				}
				else if( Integer.parseInt( choice) == 3){
					continue;
				}
				else{
					System.out.println("Please enter the choice 1, 2 or 3");
					i--;
					continue;
				}
			}catch( Exception e){
				e.printStackTrace();
			}

			System.out.println("");
		}


		return componentList;
	}

	/**
	* Initializes menu to take the input from the user
	* void
	*/
	private void initializeMenu(){
		tempList = new ArrayList<List<String>>(totalComponents);

		List<String>list = new ArrayList<String>(4);
		list.add("Please enter the CPU type");
		list.add("1. AMD CPU");
		list.add("2. Intel CPU");
		list.add("AMDCPU");
		list.add("IntelCPU");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the RAM type");
		list.add("1. DDR3 4000Mhz");
		list.add("2. DDR4 4000Mhz");
		list.add("DDR3RAM");
		list.add("DDR4RAM");
		tempList.add(list);
		list = null;
		
		list = new ArrayList<String>(4);
		list.add("Please enter the Disk type");
		list.add("1. Hard Disk");
		list.add("2. SSD Disk");
		list.add("HardDrive");
		list.add("SolidState");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the type of Graphics Card");
		list.add("1. Intel");
		list.add("2. Nvidia Turbo");
		list.add("IntelGraphics");
		list.add("NvidiaGraphics");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the type of Optical Drive");
		list.add("1. DVD");
		list.add("2. Blue Ray");
		list.add("3. Skip the component");
		list.add("DVD");
		list.add("BlueRay");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the Monitor type");
		list.add("1. LCD");
		list.add("2. LED");
		list.add("3. Skip the component");
		list.add("LCD");
		list.add("LED");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the Operating system to be installed");
		list.add("1. MacOSX(Yosemite)");
		list.add("2. Windows");
		list.add("3. Skip the component");
		list.add("Mac");
		list.add("Windows");
		tempList.add(list);
		list = null;

		list = new ArrayList<String>(4);
		list.add("Please enter the Year of support");
		list.add("1. 1 Year Support");
		list.add("2. 2 Year Support");
		list.add("3. Skip this step");
		list.add("YearSupport");
		list.add("BiennialSupport");
		tempList.add(list);
		list = null;

	}
}
