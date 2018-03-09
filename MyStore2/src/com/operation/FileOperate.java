package com.operation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileOperate {
	
   
    public static void WriteFile(String content,String path){
    	
       
    	
       
        
        File file = new File(path);
        file.setWritable(true);
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file,true));
            
            
            	
            fw.write(content);
            fw.newLine();
               
            fw.flush();
            fw.close();
            //file.setWritable(false);
            System.out.println("Records written to "+path+" successfully !");
            
        } catch (IOException e) {
        	
            System.out.println("Error writing to file");
        }
    }
    
    
    //Read DateFil.txt, and load object to ArrayList<Car>
    public static ArrayList<String> ReadObject(String path){
    	
        ArrayList<String> AllObjects = new ArrayList<String>();
        
        File file = new File(path);
        
        String line;
        try {
            BufferedReader fr = new BufferedReader(new FileReader(file));
           
            while ((line = fr.readLine()) != null) {
                  
                
                String A = line;
                
                AllObjects.add(A);
               
            }
        
            
            fr.close();
            System.out.println("Success to reading "+path+" !");
            
            
        } catch (IOException e1) {
            System.out.println("Error reading file");
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("Error. Wrong number of fields");
        } catch (NumberFormatException e3) {
            System.out.println("Error. Date is not a long or id number not an integer");
        }
        return AllObjects;
    }
    
    
    public static boolean SaleObject(String content,String path)
    {
    	
    	ArrayList<String> strList= new ArrayList<String>();
    	
    	strList=ReadObject(path);
    	
    	for(int i=0;i<strList.size();i++)
        {
        	if(strList.get(i).equals(content))
        	{
        		strList.remove(i);
        		
        		//clear the file
        		File file1 =new File(path);
                file1.setWritable(true);
                try {
                    if(!file1.exists()) {
                        file1.createNewFile();
                    }
                    FileWriter fileWriter =new FileWriter(file1);
                    fileWriter.write("");
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        		
                
                
        		//write new data to the file
        		File file = new File(path);
                file.setWritable(true);
                
                try {
                    BufferedWriter fw = new BufferedWriter(new FileWriter(file,true));
                    
                    
                    	
                    for(int j=0;j<strList.size();j++)
                    {
                    	fw.write(strList.get(j));
                        fw.newLine();
                    }
                       
                    fw.flush();
                    fw.close();
                    //file.setWritable(false);
                    System.out.println("Records written to "+path+"successfully ! sale");
                    
                } catch (IOException e) {
                	
                    System.out.println("Error writing to file");
                }
        		
        		
        		return true;
        	}
        }
    	
    	
    	
    	return false;
    }
    
    
    public static void saveObjectList(ArrayList<String> strList,String path)
    {
    	
    	//clear the file
		File file1 =new File(path);
        file1.setWritable(true);
        try {
            if(!file1.exists()) {
                file1.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file1);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	//write new data to the file
		File file = new File(path);
        file.setWritable(true);
        
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file,true));
            
            
            	
            for(int j=0;j<strList.size();j++)
            {
            	fw.write(strList.get(j));
                fw.newLine();
            }
               
            fw.flush();
            fw.close();
            //file.setWritable(false);
            //System.out.println("Records written to "+path+"successfully !");
            
        } catch (IOException e) {
        	
            System.out.println("Error writing to file");
        }
    }
    
    
    
    
  
}