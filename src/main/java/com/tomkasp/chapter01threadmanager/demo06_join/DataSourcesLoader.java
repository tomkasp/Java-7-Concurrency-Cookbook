package com.tomkasp.chapter01threadmanager.demo06_join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable {

	@Override
	public void run() {
		
		System.out.printf("Begining data sources loading: %s\n",new Date());
		try {
			// �ȴ�4��
//			TimeUnit.SECONDS.sleep(4);
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Data sources loading has finished: %s\n",new Date());
	}
}
