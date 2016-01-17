package myComputerManual.dataStore;

public class LCD implements  Component{
	final int figures = 1;
	final int totalLength = 4;
	final String description = "LCD, 54 * 60 iN, Good for eyes!!";
	final String glossary = "LCD";

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
