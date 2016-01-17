package myComputerManual.dataStore;

public class DDR3RAM implements  Component{
	final int figures = 2;
	final int totalLength = 3;
	final String description = "DDR3 RAM with 8 memory banks, 2000Mhz, 24MB L1 cache";
	final String glossary = "DDR3RAM";

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
