package myComputerManual.dataStore;

public class NvidiaGraphics implements  Component{
	final int figures = 2;
	final int totalLength = 2;
	final String description = "Nvidia, New advanced GForce graphics, 1GBytes!!";
	final String glossary = "Nvida";

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
