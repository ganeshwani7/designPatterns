
package dTunesStore.dataStore;

import dTunesStore.util.Logger;
import dTunesStore.util.Results;

import java.util.Hashtable;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;


public class MusicStore {
	Hashtable<String, MusicInfo> musicRecords = 
		new Hashtable<String, MusicInfo>( 600 );

/**
 * displayData() : Displays all the data of a music store
 * Return Type : void
 */
	public void displayData(){
		Set<MusicInfo> records = new 
		HashSet<MusicInfo>	( musicRecords.values() );
		int count = 0;
		for( MusicInfo musicInfo : records){
			Logger.write(1, musicInfo.toString());
//			System.out.println( musicInfo + "\n");
		}
		records = null;
	}

/**
 * getRecord() : Accepts any one of three entities of the song entry and 
 * return the 
 * MusicInfo object of corresponding entry
 */
	public MusicInfo getRecord( String content){
		return musicRecords.get( content);
	}

	public Hashtable<String, MusicInfo> getMusicRecords(){
		return musicRecords;
	}
/*
	public String toString(){
		Set<MusicInfo> records = new HashSet<MusicInfo> ( musicRecords.values() );
		int count = 0;
		for( MusicInfo musicInfo : records){
			Logger.write(1, musicInfo.toString());
		}
	}
*/

} // end class MusicStore

