package com.leo;

public class DownLoadImages implements Runnable {
	//This is change test xp Leo 2015.3.23
	GetPic gp=new GetPic();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		gp.getPic();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DownLoadImages dli=new DownLoadImages();
//		Thread t=new Thread(dli);
//		t.start();
		
//		System.out.println(t.isAlive());
		while(true){
			System.out.println("activeCount: "+Thread.activeCount());
			if(Thread.activeCount()>5){
				System.out.println("线程数达到5个，将停止启动新线程");
			}else{
				Thread t=new Thread(dli);
				t.start();
				System.out.println("启动新线程: "+t.getId());
			}
			try {
				Thread.sleep(1000*6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
