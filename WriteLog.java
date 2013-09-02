package com.egarduno.Banking;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*__________________________________

	Emilio Garduno
	08/14/2013
	Banking Transactions
__________________________________*/

public class WriteLog {
	private String path;
	private PrintWriter writer;//built in tool for writing a file
	
	public WriteLog(String path) throws IOException{
		this.path=path;
		createFile();
	}
	
	private void createFile() throws IOException{//'throw' sends any error message to the class that calls this method(File Not Found)
		FileWriter outFile = new FileWriter(path, true);//true - appends to the write file / false - overwrites it no matter what
		writer = new PrintWriter(outFile);
	}
	
	public void addText(String content){
		writer.println(content);
	}
	
	public void closeFile(){//if you don't close the file you can never read it, it's stuck in "in-use"
		writer.close();
	}

}
