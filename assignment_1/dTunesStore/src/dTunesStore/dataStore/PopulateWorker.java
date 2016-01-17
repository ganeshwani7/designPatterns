

package dTunesStore.dataStore;

import dTunesStore.util.Logger;
import dTunesStore.util.Results;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Hashtable;

public class PopulateWorker {
	String fileName;
	MusicStore musicStore;

    // Constructor takes a handle to the FileStream or the name of the file 

    //  helper class that reads from the dataFile and populates
    // the MusicStore

 /**
  * populateWorker() function which populates the MusicStore with songs entries
  * Return Type : Constructor( Basically returns an object)
  */ 

	public PopulateWorker( String inFileName, MusicStore musicStore){
		Logger.write(4, "PopulateWorker's constructor is called");
		fileName = inFileName;
		this.musicStore = musicStore;
	}

/**
  * readData() function which reads the entries from a file and populate the 
  * MusicStore
  * Return Type : void
  */ 


	public void readData( ){
		String str, delims = "[ ]+";
		String[] tokens;

		Hashtable<String, MusicInfo>musicRecords= musicStore.getMusicRecords();

		try{
			BufferedReader in = new BufferedReader( new FileReader( fileName )); 
			while( (str = in.readLine()) != null){ 
//				System.out.println( "String content is " + str +"\n");
				tokens = str.split( delims );

				MusicInfo musicInfo = new MusicInfo();
				setMusicInfo(musicInfo, tokens);

				int i = 0;
				for( i =0; i< 3; i++){
					musicRecords.put( tokens[i], musicInfo);
				}
			}
			in.close(); 
		}catch( FileNotFoundException e){ 
			System.out.println( "Couldn't open the file"); 
			e.printStackTrace(); 
		}catch( IOException ie){ 
			ie.printStackTrace(); 
		}		  
	}

/**
  * setMusicInfo() : Populate the MusicInfo with a record
  * Return Type : void
  */ 
	private void setMusicInfo( MusicInfo musicInfo ,String []tokens){
		musicInfo.setSongName (tokens[0]);
		musicInfo.setAlbumName(tokens[1]);
		musicInfo.setSingerName (tokens[2]);
	}

} // end class PopulateWorker

