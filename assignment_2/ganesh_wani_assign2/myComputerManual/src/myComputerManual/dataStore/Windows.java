package myComputerManual.dataStore;

public class Windows implements  Component{
	final int figures = 10;
	final int totalLength = 20;
	final String description = "Windows 8.0, packaged with most advanced features!!";
	final String glossary = "Windows";

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
