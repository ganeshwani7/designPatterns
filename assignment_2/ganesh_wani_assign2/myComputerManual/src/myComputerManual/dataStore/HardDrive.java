package myComputerManual.dataStore;

public class HardDrive implements  Component{
	final int figures = 1;
	final int totalLength = 3;
	final String description = "Hard drive SanDisk, 4500MHz, SATA";
	final String glossary = "HardDrive";

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
