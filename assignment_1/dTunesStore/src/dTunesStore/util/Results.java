
package dTunesStore.util;

import dTunesStore.dataStore.MusicInfo;
import java.util.List;
import java.util.ArrayList;

public class Results implements Result{
	List<MusicInfo> searchResults;

/**
 *	Results() constructor
 */
	public Results(){
		Logger.write( 4,"Inside the Results constructor");
		searchResults = new ArrayList<MusicInfo>();
	}
	
/**
 * insert() function which takes the music info, and adds it in the 
 * searchResults
 * Return type : void
 */
	public void insert( MusicInfo  musicRecord){
		Logger.write(2, "\""+ musicRecord.toString() +"  \"is added to the Result set");
		searchResults.add( musicRecord);
	}

/**
 * displayData() function helps to displayData of the results
 * Return type : void
 */
	public void displayData(){
		Logger.write(1, "Results data is");
		for( MusicInfo musicInfo : searchResults){
			Logger.write(1, musicInfo.toString());
		}
	}

/**
 * toString : 
 * Return Type : String
 */
 public String toString(){
 	return  "Results";
 }
}
