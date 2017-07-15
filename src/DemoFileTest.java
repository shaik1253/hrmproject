import java.io.File;
import java.io.IOException;


public class DemoFileTest 
{

	public static void main(String[] args) throws IOException 
	{
	
		//Creating a New Text File
		/*
		File f=new File("c:\\myfile.txt");
		f.createNewFile();
		*/
		
		
		//Creating Folder
		/*File f=new File("c:\\MyFolder");
		f.mkdir();
		*/
		
		//Deleting File
		/*
		File f=new File("c:\\myfile.txt");
		f.delete();
		*/
		
		//Deleting Folder
		File f=new File("c:\\MyFolder");
		f.delete();
		
		
		
	}

}
