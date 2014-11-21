import java.util.ArrayList;
import java.util.List;

public class Employee {
  private String name;
  private String boss;
  private String title;
  private int year;
  boolean visited = false;

  public Employee() {

  }

  public Employee(String name, String boss, String title, int year) {
	 this.name = name;
	 this.boss = boss;
	 this.title = title;
	 this.year = year;
  }

  public Employee(String[] att) {
	 this.name = att[0];
	 this.boss = att[1];
	 this.title = att[2];
	 try {
		this.year = Integer.parseInt(att[3]);
	 } catch (NumberFormatException e) {
		this.year = 0;
	 }
  }

  public static List<Employee> fromString(String input) {
	 List<Employee> list = new ArrayList<>();
	 String[] toks = input.split("--");
	 for (String e : toks) {
		list.add(new Employee(e.split(",")));
	 }
	 return list;
  }
  
  public String format(int level) {
	 StringBuilder sb = new StringBuilder();
	 for (int i = 0; i < level; i++) {
		sb.append("-");
	 }
	 sb.append(name).append(" ").append("(").append(title)
	 		.append(")").append(" ").append(year).append("\n");
	 return sb.toString();
  }

  public String getName() {
	 return name;
  }

  public void setName(String name) {
	 this.name = name;
  }

  public String getBoss() {
	 return boss;
  }

  public void setBoss(String boss) {
	 this.boss = boss;
  }

  public String getTitle() {
	 return title;
  }

  public void setTitle(String title) {
	 this.title = title;
  }

  public int getYear() {
	 return year;
  }

  public void setYear(int year) {
	 this.year = year;
  }

  @Override
  public String toString() {
	 return "Employee [name=" + name + ", boss=" + boss + ", title=" + title
	     + ", year=" + year + "]";
  }
}