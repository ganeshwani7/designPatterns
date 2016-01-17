package myComputerManual.dataStore;

public class BiennialSupport implements  Component{
	final int figures = 3;
	final int totalLength = 4;
	final String description = "Supports your laptop now for 2 years with this support plan";
	final String glossary = "BiennialSupport";

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
