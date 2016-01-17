package myComputerManual.dataStore;

public class SolidDrive implements  Component{
	final int figures = 2;
	final int totalLength = 3;
	final String description = "Solid drive SanDisk, 9000MHz, Better read access";
	final String glossary = "SolidDrive";

	/**
	* Gives the description of the given component
	*/
	public String getDescription(){
		return description;
	}

	/**
	* Returns the glossary associated with a component
	*/
	public String getGlossary(){
		return glossary;
	}

	/**
	* Gives total number of figures present in the component
	*/
	public int getFigureNumber(){
		return figures;
	}

	/**
	* Gives total number of figures present in the component
	*/
	public int getTotalLength(){
		return totalLength;
	}


}
