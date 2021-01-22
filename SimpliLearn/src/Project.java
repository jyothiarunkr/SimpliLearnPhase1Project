
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.io.File;

import java.io.IOException;
import java.util.*;


 interface FileInterface {
	public abstract void showAllFiles();
	public abstract void addFile();
	public abstract void deleteFile();
	public abstract void searchFile();

}


 public class Project {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			welcomeScreen();
			try {
				menuDriven();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public static void welcomeScreen() {
			System.out.println("Application Name : LockedMe.com \n");
			System.out.println("Developed by Dr. JYOTHI N.M. \n");
		}

		public static void menuDriven() throws FileNotFoundException {
			Scanner sc = new Scanner(System.in);
			BusinessLevelOperations obj = new BusinessLevelOperations();
			int option;
			do {
			System.out.println("Enter your choice which you want to select: \n");
			System.out.println("\t1. Retrieve current Filenames in Ascending Order \n");
			System.out.println("\t2. Business-level Operation menu \n");
			System.out.println("\t3. Exit from the Application \n");
			
			option=sc.nextInt();
			switch(option) {
			case 1:
				obj.showAllFiles();
				break;
			case 2:
				int ch;
			do {
				System.out.println("Enter your choice for Business level operation");
				System.out.println("\t1. Add a file and its content to a directory");
				System.out.println("\t2. Delete a file from a directory");
				System.out.println("\t3. Searching a file and showing its content");
				System.out.println("\t4. Exit from BLO menu");
				
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					obj.addFile();
					break;
				case 2:
					obj.deleteFile();
					break;
				case 3:
				
					obj.searchFile();
					break;
				case 4:
					System.out.println("Exited from the Business Level operation...");
					System.out.println("---------------------------------\n");
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}while(ch!=4);
			break;
			case 3:
				System.out.println("Exiting from the application...");
				break;
			default:
				System.out.println("Invalid choice");
			}
			
			//System.out.println("Press 0 to continue");
			}while(option!=3);
			
		}

	}

 
 
 
 
 
		
class BusinessLevelOperations implements FileInterface{
	
	


	public void showAllFiles() {
		// creates a file object
	   System.out.println("List of Files ");
		try {
	    File file = new File("D:\\test");

	    // returns an array of all files
	    String[] fileList = file.list();

	    for(String str : fileList) {
	      System.out.println(str);
	      }
	   }	
	       catch(Exception e) {
	    	e.printStackTrace();
	        }

	}
	
 
	
 @Override
	public void addFile() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);         //object of Scanner class  
		System.out.print("Enter the file name: ");  
		String name=sc.nextLine();      
		File file = new File("D:\\test\\"+name);  //initialize File object and passing path as argument  
	boolean result;  
	try   
	{  
	result = file.createNewFile();  //creates a new file  
	if(result)      // test if successfully created a new file  
	{  
	System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
	}  
	else  
	
	{  
	System.out.println("File already exist at location: "+file.getCanonicalPath());  
	}  
	}   
	catch (IOException e)   
	{  
	e.printStackTrace();    //prints exception if any  
	}  
		
	System.out.println("Enter data for file");  
	try {
    	
	
	PrintWriter out = new PrintWriter(file);

    // Echo keyboard input out to the file.
   
	while (sc.hasNextLine())
    {
      String line = sc.nextLine();
      out.println(line);
    }
    
    System.out.println("Done");
    out.close(); 
    }
	
	catch(Exception e) {}
 }
	
			
	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file which you want to delete:");
		//sc.next();
		Scanner scan=new Scanner(System.in);
		String filename=scan.nextLine();
		File F= new File("D:\\test\\"+filename);
		if(F.delete())
			System.out.println(filename+" got Deleted");
		else
			System.out.println("File Not Found");
		
	}
	
	
	
	@Override
	public void searchFile() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file to be searched with extension.. " );
		String name = scan.next();
        
		File directory = new File("D:\\test\\"); 

		
		String[] flist = directory.list(); 
		int flag = 0; 
		if (flist == null) { 
		    System.out.println("Empty directory."); 
		} 
		else { 

		    // Linear search in the array 
		    for (int i = 0; i < flist.length; i++) { 
		        String filename = flist[i]; 
		        
		        if (filename.equalsIgnoreCase(name)) { 
		            System.out.println(filename + " found"); 
		            flag = 1; 
		       //reading contents of file
		            System.out.println("contents of file: \n");
		            try { 
		            File f= new File("D:\\test\\"+filename);
    				Scanner sc1 = new Scanner(f);
    				
    				while(sc1.hasNextLine()) {
    				System.out.println(sc1.nextLine());

    				}
		          		          		          		          		        
		        } catch(Exception e) {
		    } 
		} 
		    }//for new close
		if (flag == 0) { 
		    System.out.println("File Not Found"); 
		} 
		
		    //}//for
		}
		
	}
}
		

	
		
		




