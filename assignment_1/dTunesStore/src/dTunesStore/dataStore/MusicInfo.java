
package dTunesStore.dataStore;

import dTunesStore.util.Logger;
import dTunesStore.util.Results;


public class MusicInfo {
	String songName, albumName, singerName;

/**
 * MusicInfo() constructor
 * Return Type
 */	
	public MusicInfo(){
		Logger.write(4, "MusicInfo's constructor is called");
	}

/**
 * setSongName() 
 * Return Type : void
 */	
	public void setSongName( String inSongName){
		songName = inSongName;
	}
	
/**
 * setAlbumName() 
 * Return Type : void
 */	
	public void setAlbumName( String inAlbumName){
		albumName = inAlbumName;
	}

/**
 * setSingerName() 
 * Return Type : void
 */	
	public void setSingerName( String inSingerName){
		singerName = inSingerName;
	}


/**
 * getSongName() 
 * Return Type : String
 */	
	public String getSongName( ){
		return songName;
	}
	
/**
 * getAlbumName() 
 * Return Type : String
 */	
	public String getAlbumName( ){
		return albumName;
	}

/**
 * getSingerName() 
 * Return Type : String
 */	
	public String getSingerName( ){
		return singerName;
	}


/**
 * toString() 
 * Return Type : String
 */	
	public String toString(){
		return songName + " " + albumName + " " + singerName;
	}
} // end class MusicInfo

