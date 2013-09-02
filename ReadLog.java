package com.egarduno.Banking;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*__________________________________

	Emilio Garduno
	08/14/2013
	Banking Transactions
__________________________________*/

public class ReadLog {
	private String path;
	
	public ReadLog(String path){
		this.path = path;
	}
	
	@SuppressWarnings("resource")
	public String getText() throws IOException{
		String content = "";
		FileInputStream fstream = new FileInputStream(path);//reads the file
		DataInputStream fileIn = new DataInputStream(fstream);
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(fileIn));//buffers it into memory
		String stringIn;
		
		while((stringIn = buffReader.readLine()) != null){
			content += (stringIn + "\n");
		}
		
		return content;
	}
	
}
