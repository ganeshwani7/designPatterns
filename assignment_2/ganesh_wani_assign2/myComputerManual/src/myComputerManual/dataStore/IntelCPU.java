package myComputerManual.dataStore;

public class IntelCPU implements  Component{
	final int figures = 2;
	final int totalLength = 4;
	final String description = "Intel CPU 5GHz, 2 million FLOPS";
	final String glossary = "IntelCPU";

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
