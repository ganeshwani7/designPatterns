package myComputerManual.dataStore;

public class Mac implements  Component{
	final int figures = 0;
	final int totalLength = 0;
	final String description = "Mac is self explanatory product, which user intuitavely finds itself promising!!";
	final String glossary = "Mac";

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
