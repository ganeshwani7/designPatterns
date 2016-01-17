package dTunesStore.dataStore;

import dTunesStore.util.Results;
import dTunesStore.util.Result;
import dTunesStore.util.Logger;

import java.util.List;
import java.util.ArrayList;

public class CreateSearchWorker{
	int threadCount = 0;
	Result results;
	MusicStore musicStore;
	FileProcessor fileProcessor;

/**
 * CreateSearchWorker() : constructor 
 * Return Type : 
 */

	public CreateSearchWorker( int noOfThreads, Result results, 
						MusicStore musicStore, FileProcessor fileProcessor){
		Logger.write(4, "CreateSearchWorker's constructor is called");
		this.threadCount = noOfThreads;
		this.results = results;
		this.musicStore = musicStore;
		this.fileProcessor = fileProcessor;
	}

/**
 * searchMusicStore() : Spawns the threads to find an entry in a MusicStore, 
 * after that join all the threads
 * Return Type : void
 */
	public void searchMusicStore(){
		int count = 0;

		SearchWorker searchWorker = new SearchWorker( fileProcessor, musicStore, results);
		List<Thread> threads = new ArrayList<Thread>();

		for( count = 0; count< threadCount; ++count){
			threads.add( count, new Thread( searchWorker, "Thread "+ count) );
		}

		for( count = 0; count< threadCount; ++count){
			threads.get(count).start();
		}

		for( count = 0; count < threadCount; ++count){
			try{
				threads.get(count).join();
			}catch( InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	/**                        
	 * toString : 
	 * Return Type : String
	 */                  
	 public String toString(){
		return  "CreateSearchWorker"   ;
	}    
}
