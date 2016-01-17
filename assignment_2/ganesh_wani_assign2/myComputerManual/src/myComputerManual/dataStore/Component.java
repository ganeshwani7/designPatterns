package myComputerManual.dataStore;

public interface Component{

	/**
	* Gives total number of figures present in the component
	* return : int
	*/
	public int getFigureNumber();

	/**
	* Gives total number of figures present in the component
	* return : int
	*/
	public int getTotalLength();

	/**
	* Gives the description of the given component
	* return : String
	*/
	public String getDescription();

	/**
	* Returns the glossary associated with a component
	* return : String
	*/
	public String getGlossary();
}
