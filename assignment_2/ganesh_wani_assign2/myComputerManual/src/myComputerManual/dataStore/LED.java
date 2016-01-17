package myComputerManual.dataStore;

public class LED implements  Component{
	final int figures = 3;
	final int totalLength = 5;
	final String description = "LED, 100 * 100 iN, Best display ever!!";
	final String glossary = "LED";

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
