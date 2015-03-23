package com.leo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetPic {
	// 生成图片函数  
    public static  void makeImg(String imgUrl,String fileURL) {  
        try {  
  
            // 创建流  
            BufferedInputStream in = new BufferedInputStream(new URL(imgUrl)  
                    .openStream());  
  
            // 生成图片名  
            int index = imgUrl.lastIndexOf("/");  
            String sName = imgUrl.substring(index+1, imgUrl.length());  
//            System.out.println(sName);  
            // 存放地址  
            File img = new File(fileURL+sName);  
            if(img.exists()){
            	System.out.println("此文件已经下载过： "+fileURL+sName);
            	Thread.sleep(500);
            }else{
            	 BufferedOutputStream out = new BufferedOutputStream(  
                         new FileOutputStream(img));  
                 byte[] buf = new byte[2048];  
                 int length = in.read(buf);  
                 while (length != -1) {  
                     out.write(buf, 0, length);  
                     length = in.read(buf);  
                     // 生成图片  
                     

                 }  
                 
                 in.close();  
                 out.close();  
                 System.out.println("****************文件已经下载成功，保存到： "+fileURL+sName+"*******************");
                 Thread.sleep(500);
            }

        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	static Document doc;
	
	public void getPic(){
		try {
			doc = Jsoup.connect("http://www.hualvtu.com/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Element data-src = doc.select("div.data-src").first();
//		System.out.println("linkHref: "+data-src);
		Elements links = doc.select("div[data-src]");
//		System.out.println(links.size());
		
		String ImagePath=links.toString().substring(links.toString().indexOf("http"), links.toString().indexOf("jpg")+3);

//		System.out.println(ImagePath);
		makeImg(ImagePath, "C://WallPaper//");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
