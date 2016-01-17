
package dTunesStore.driver;

import dTunesStore.util.Logger;
import dTunesStore.util.Result;
import dTunesStore.util.Results;

import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.MusicInfo;
//import dTunesStore.dataStore.SearchWorker;
import dTunesStore.dataStore.CreateSearchWorker;
import dTunesStore.dataStore.FileProcessor;

/**
 *Driver class which which contains the main function and drives the 
 * course of the whole program
 */

public class Driver {

/**
 * Main function which has the return type as void, takes command line arguments
 */
    public static void main(String args[]) {

//	System.out.println("Hello Design-Patterns students. Welcome to Assignment 1\n");
	
	parameterValidation(args);

	Logger.setLoggerValue( Integer.parseInt( args[3]));

	MusicStore musicStore = new MusicStore();

	PopulateWorker populateWorker = new PopulateWorker( args[0], musicStore);
	populateWorker.readData();

//	musicStore.displayData();

	Result results = new Results();
	FileProcessor fileProcessor = new FileProcessor( args[1]);
	CreateSearchWorker createSearchWorker = 
	new CreateSearchWorker( Integer.parseInt( args[2]), results, musicStore, fileProcessor);

	createSearchWorker.searchMusicStore();

	results.displayData();
    } // end main(...)


/**
 * parameterValidation() function which validates the command line arguments
 * Return Type : void
 */
	private static void parameterValidation( String []args){
		if( args.length != 4){
			System.err.println(" Please enter only 4 arguments : dataStoreFileName searchFileName Number_of_threads DEBUG_VALUE");
			System.exit(1);
		}

		if( Integer.parseInt(args[3]) < 0 ||  Integer.parseInt(args[3]) > 4){
			System.err.println("Invalid logger value, please enter Logger value between 0 and 4, Inclusive");
			System.exit(1);
		}

		if( Integer.parseInt(args[2]) < 0 ||  Integer.parseInt(args[2]) > 5){
			System.err.println("Invalid number of threads, please enter threads to spawn between 1 and 5, Inclusive");
			System.exit(1);
		}


	}
} // end class Driver
