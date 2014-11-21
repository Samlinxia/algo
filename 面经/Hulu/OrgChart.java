import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class OrgChart {
  private static final String inputPath = "E:\\Downloads\\org_chart.in";
  private static final String outputPath = "E:\\Downloads\\org_chart_solution_java.out";

  private static int numCases;
  private List<List<Employee>> employees = null;

  public OrgChart() {
	 employees = new ArrayList<>();
  }

  public static void helper(List<Employee> list, StringBuilder sb, int level, String parent) {
	 for (Employee e : list) {
		if (!e.visited && e.getBoss().equals(parent)) {
		  sb.append(e.format(level));
		  e.visited = true;
		  helper(list, sb, level + 1, e.getName());
		}
	 }
  }
  
  public void generateChart() {
	 StringBuilder sb = new StringBuilder();
	 int caseNum = 1; 
	 for (List<Employee> l : employees) {
		Collections.sort(l, new Comparator<Employee>() {
		  @Override
		  public int compare(Employee e1, Employee e2) {
			 
			 return e1.getName().compareTo(e2.getName());
		  }
		});
		sb.append("Case #" + caseNum + "\n");
		helper(l, sb, 0, "NULL"); 
		caseNum++;
	 }
	 printChart(sb.toString());
  }

  public void readFile() {
	 try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
		
		numCases = Integer.parseInt(reader.readLine());
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
		  this.employees.add(Employee.fromString(reader.readLine()));
		}

	 } catch (NullPointerException | IOException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	 }
  }

  public void printChart(String str) {
	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));) {
		  writer.write(str);
	 } catch (IOException e) {
		e.printStackTrace();
	 }
  }
  
  public void printChart() {
	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));) {
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
		  writer.write("Case #" + caseNum + "\n");
//		  writer.write(employees.get().get(0).toString());
		}
	 } catch (IOException e) {
		e.printStackTrace();
	 }
  }

  public static void main(String[] args) throws IOException {
	 OrgChart oc = new OrgChart();
	 oc.readFile();
	 oc.generateChart();
  }
}
