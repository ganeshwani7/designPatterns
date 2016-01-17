package myComputerManual.dataStore;

public class BlueRay implements  Component{
	final int figures = 1;
	final int totalLength = 4;
	final String description = "Blue Ray drive, runs worst quality disks elegantly";
	final String glossary = "Blue Ray";

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
