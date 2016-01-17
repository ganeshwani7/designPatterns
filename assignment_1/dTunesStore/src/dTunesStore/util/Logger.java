
package dTunesStore.util;

public class Logger {
    private static int DEBUG_VALUE;

	
	/**
	 * setLoggerValue() : Takes the debug value and sets the DEBUG_VALUE
	 * return type : void
	 */
	public static void setLoggerValue( int debugValue){
		DEBUG_VALUE = debugValue;
	}

	/**
	 * setLoggerValue() : Takes the debug value and sets the DEBUG_VALUE
	 * return type : void
	 */
	public static int getLoggerValue( ){
		return DEBUG_VALUE ;
	}


	/**
	 * write() : Takes the debug value and prints the message accordingly
	 * return type : void
	 */
	public static void write( int debugValue, String message){
		if( debugValue == DEBUG_VALUE)
			System.out.println(message);
	}

    // accessor and mutator for DEBUG_VALUE

    // write(...) method 

}
