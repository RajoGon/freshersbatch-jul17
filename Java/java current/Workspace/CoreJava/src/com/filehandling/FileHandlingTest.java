package com.filehandling;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;



public class FileHandlingTest {

	public static void main(String[] args) throws Exception {
	//1.	Write an application to read all the contents from one file & insert them into another file.
		File file = new File("C:/Users/gon_r/Desktop/Hello.txt"); 
		FileInputStream fis = new FileInputStream(file); 
		FileInputStream fiss = new FileInputStream(file); 
		StringBuilder sb = new StringBuilder(""); 
		int i = 0; 
		do { 
			i = fis.read(); 
			if(i != -1) 
				sb.append((char)i);
			}while(i != -1); 
		
		File file2 = new File("abc.txt"); 
		FileInputStream fis2 = new FileInputStream(file2); 
		FileOutputStream fos = new FileOutputStream(file2); 
		fos.write(sb.toString().getBytes()); 
		fos.flush(); 
		fos.close();
	//2.	Write an application that prints the details of all files situated inside a specified directory. The file details should include file name, size, date, file permissions, directory or file etc.
		File file3 = new File("abc.txt"); 
		 Path path = Paths.get("abc.txt");
		    BasicFileAttributes attr= null;
		    try {
		    attr = Files.readAttributes(path, BasicFileAttributes.class);


		    } catch (IOException e) {
		    System.out.println("oops error! " + e.getMessage());
		    }
		
		
		
		
		
		System.out.println("Name of file, "+file3.getName()+" Size of file, "+file3.getTotalSpace()+" and if it is a file, "+file3.isFile()+" created on, "+attr.creationTime()+" and can file be read? "+file3.canRead()+" and can we write? "+file3.canWrite() );			
	//4.	Write an application to read the contents of 3 files using sequence input stream.
		SequenceInputStream sis = new SequenceInputStream(fiss,fis2); 
		int x;  
		while((x=sis.read())!=-1){
			System.out.print((char)x);  
			}  
		sis.close(); 
		
		
	}
	
	

}
