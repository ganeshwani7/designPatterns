package myComputerManual.dataStore;

public class DDR4RAM implements  Component{
	final int figures = 3;
	final int totalLength = 5;
	final String description = "DDR4 RAM with 16 memory banks, 4000Mhz, 48MB L1 cache";
	final String glossary = "DDR4RAM";

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
