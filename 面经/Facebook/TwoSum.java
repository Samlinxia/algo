import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TwoSum {

  public TwoSum() {
	 // TODO Auto-generated constructor stub
  }

  
  public static void main(String[] args) throws IOException
  {
	 	try (BufferedReader reader = 
	 		 	new BufferedReader(new FileReader("E:\\Downloads\\sum.in"));
	       BufferedWriter writer = 
	      	 new BufferedWriter(
	      	 new FileWriter("E:\\Downloads\\sum_sample_solution_java.out"));) {
      
      int numCases = Integer.parseInt(reader.readLine());
      
      for (int caseNum = 1; caseNum <= numCases; caseNum++)
      {
          String[] toks = reader.readLine().split(" ");
          int x = Integer.parseInt(toks[0]);
          int y = Integer.parseInt(toks[1]);
          int sum = x + y;
          
          writer.write("Case #" + caseNum + "\n");
          writer.write(sum + "\n");
      }
      
	 	}
      catch (FileNotFoundException | NullPointerException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
//      writer.close();
//      reader.close();
  }
}


