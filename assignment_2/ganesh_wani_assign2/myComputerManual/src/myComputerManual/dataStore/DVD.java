package myComputerManual.dataStore;

public class DVD implements  Component{
	final int figures = 2;
	final int totalLength = 4;
	final String description = "DVD drive, runs worst quality disks elegantly";
	final String glossary = "DVD";

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
