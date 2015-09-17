package com.tomkasp.chapter01threadmanager.demo06_join;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

        DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader, "DataSourceThread");
		thread1.start();

		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
		thread2.start();

		try {
            //Main thread has been suspended
			thread1.join();
			System.out.println("Main has been released by thread DataSourcesLoader==========================================");
			thread2.join();
            System.out.println("Main has been released by thread NetworkConnectionsLoader==========================================");
        } catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
	
	/**
	 	Begining data sources loading: Sat Apr 27 16:55:52 CST 2013
		Begining network connections loading: Sat Apr 27 16:55:52 CST 2013
		Data sources loading has finished: Sat Apr 27 16:55:57 CST 2013
		Network connections loading has finished: Sat Apr 27 16:55:59 CST 2013
		Main: Configuration has been loaded: Sat Apr 27 16:55:59 CST 2013
		
		Begining data sources loading: Sat Apr			27 17:21:10 CST 2013
		Begining network connections loading: Sat Apr		27 17:21:10 CST 2013
		Data sources loading has finished: Sat Apr		27 17:21:15 CST 2013
		Network connections loading has finished: Sat Apr	27 17:21:17 CST 2013
		Main: Configuration has been loaded: Sat Apr 27 17:21:17 CST 2013
	 */
}
