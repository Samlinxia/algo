import java.io.*;
import java.io.FileReader;


class FileHelper{
	private final static String outputFile = "output.txt";
	
	//forbid call instance of this class
	private FileHelper()
	{}
	
	public static String readFileToString(String fileName) throws IOException
	{
		//read input files by lines
		BufferedReader in = new BufferedReader( new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		try {
		while( (s = in.readLine()) != null)
		{
			sb.append(s + '\n');
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		in.close();
	
	return sb.toString();
		
	}	
	
	public static void write(String s) throws IOException
	{
		if(!fileFound(outputFile))
			createFile(outputFile);   //if output filename is not found, create a new file
		PrintWriter out = new PrintWriter(
		new BufferedWriter(new FileWriter(outputFile)));
		try{
			out.println(s);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			out.close();
		}
		
		
		
	}
	
	public static boolean fileFound(String fileName) throws IOException	
	{
		try{
			File filePath = new File(fileName);
			if(filePath.exists())
				return true;
			return false;
		}
		catch(Exception e){
			System.out.println("Can't open file");   
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean createFile(String fileName)
	{
		try{
			File path = new File(fileName);
			path.createNewFile();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/*public static char readCharFromString(String fileName)
	{
		char tempChar;
		StringReader sr = new StringReader(readFileToString(fileName));
		while((tempChar = sr.read()) != -1)
		{
			
		}
	}
	*/
	/*
	public static void writeFile() throws IOException
	{
		
	}
	
	public String read2(File file){  //使用缓冲区，从缓冲区中读取字符，大大减少通过底层的I/O操作   
        try {   
            FileInputStream fis = new FileInputStream(file);   
            BufferedInputStream bis = new BufferedInputStream(fis);   
            int cnt =0;   
            int b;   
            while((b=bis.read())!=-1){   
                if(b=='\n')   
                cnt++; //记录行数   
            }   
            bis.close(); //不用关闭fileinputstream   
            System.out.println("line count:"+cnt);   
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
	}
	//read block every time, store in buffer.  more efficient
	 public String read3(File file){   
        try {   
            FileInputStream fis = new FileInputStream(file);   
            byte[] buffer = new byte[1024];   
            int cnt =0;   
            int n; 					//number of byte readed once 
            while((n=fis.read(buffer))!=-1){   
                for(int i = 0;i<n;i++){   
                    if(buffer[i]=='\n')cnt++;   
                }   
            }   
            fis.close();   
            System.out.println("line count:"+cnt);   
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
	*/

}