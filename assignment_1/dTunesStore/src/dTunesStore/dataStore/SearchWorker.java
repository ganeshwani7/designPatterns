package dTunesStore.dataStore;

import dTunesStore.util.Logger;
import dTunesStore.util.Results;
import dTunesStore.util.Result;

public class SearchWorker implements Runnable {
	FileProcessor fileProcessor;
	MusicStore musicStore;
	Result results;

/**
 * SearchWorker() : Constructor
 */

    public SearchWorker( FileProcessor fileProcessor, MusicStore musicStore, 
															Result results) {
		Logger.write(4, "SearchWorker's constructor is called");
		this.fileProcessor = fileProcessor;
		this.musicStore = musicStore;
		this.results = results;
	// PLACEHOLDER
    }

	/**
	 * run() : Invoker from the start() method of the thread
	 * Return Type : void
	 */
    public void run() {
		Logger.write(3, "Run method is called");

		String str;
	// PLACEHOLDER
		while( (str = fileProcessor.readLineFromFile()) != null ){
//		System.out.println( str  + " from " + Thread.currentThread().getName() ); 
				MusicInfo musicInfo = musicStore.getRecord( str);
				if( musicInfo != null){
					synchronized( this ){
						results.insert( musicInfo);
					}
				}
		}
    } // end run(...)

} // end class SearchWorker

