package myComputerManual.dataStore;

public class AMDCPU implements  Component{
	final int figures = 1;
	final int totalLength = 2;
	final String description = "AMDCPU better than Intel CPU, 4GHz, 1 million FLOPS";
	final String glossary = "AMDCPU";

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
