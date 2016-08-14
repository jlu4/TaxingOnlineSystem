package com.inno.tax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Path {
	 String path_server = "";
	 String path = "";
	 boolean pathFlag = true;
	
	public String getPath() {

		try {
			File f = new File("/app/src/main/resources/config.ini");
			
//			File f = new File("file:/app/target/taxing-0.0.1-SNAPSHOT.war!/WEB-INF/classes/config.ini");
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String s[];
			s = bf.readLine().split("=");
				path = s[1].trim();
				//path = path_server;
				bf.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
			path = this.getClass().getResource("").getPath();
			System.out.println(path);
			path = path.substring(0, path.length() - 99);
			System.out.println("local ycy path" + path);
			File f = new File(path + "taxing/src/main/resources/config.ini");
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String s[];
			bf.readLine();
			s = bf.readLine().split("=");
				path = s[1].trim();
				//path = path_server;
				bf.close();
//			path = this.getClass().getResource("").getPath();
//			
//			path = path.substring(0, path.length() - 99);
			pathFlag = false;
			System.out.println("local :" + path);
			}catch (FileNotFoundException e1) {
				System.out.println("local config.ini not found!");
			}catch (IOException e2) {
				System.out.println("local path setting error!");
			}
		}
		return path;

	}
	public boolean getFlag(){
		try {
			//File f = new File("file:/app/target/taxing-0.0.1-SNAPSHOT.war!/WEB-INF/Config.ini");
			File f = new File("/app/Config.ini");
			
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
//			String s[];
//			s = bf.readLine().split("=");
//				path_server = s[1].trim();
//				path = path_server;
				bf.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			pathFlag = false;
//			System.out.println("local :" + path);
		}
		return pathFlag;
	}
	
	public String getHerokuPath(){
		String herokuPath = "";
		path = this.getClass().getResource("").getPath();
		return herokuPath;
	}
	

}
