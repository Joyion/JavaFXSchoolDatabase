package schooldata.grade;

public class Grade implements Comparable<Grade> {

int stid,
	cnum,
	yr;
String semester;
char grade;
long recordnum;
	
	public Grade(int id, int coursenum, int year, String semet, char gr) 
	
	{
	stid = id;
	cnum = coursenum;
	yr = year;
	semester = semet;
	grade = gr;

	}
	
	public Grade(int id, int coursenum, int year, String semet, char gr, long record) 
	
	{
	stid = id;
	cnum = coursenum;
	yr = year;
	semester = semet;
	grade = gr;
	recordnum = record;

	}
	
	public void  setid(int id)
	{
		stid = id;
	}
	
	public int getid()
	{
		return stid;
	}
	

	public void setcnum(int coursenum)
	{
		cnum = coursenum;
	}
	
	public int getcnum()
	{
		return cnum;
	}

	public void setyear(int year)
	{
		yr = year;
	}
	
	public int getyear()
	{
		return yr;
	}
	
	public void setsemester(String semest)
	{
		semester = semest;
	}
	
	public String getsemester()
	{
		return semester;
	}
	
	public void setgrade(char gr)
	{
		grade = gr;
	}
	
	public char getgrade()
	{
		return grade;
	}
	
	public void gradeDisplay()
	{
		System.out.println("Course Number: ");
		System.out.println(cnum);
		System.out.println("Semester: ");
		System.out.println(semester);
		System.out.println("Year: ");
		System.out.println(yr);
		System.out.println("Grade: ");
		System.out.println(grade);
	}
	
	public void setRecord(long record)
	{
		recordnum = record;
	}
	
	public long getRecord()
	{
		return recordnum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
		{
			return true;
		}
		
		if(!(obj instanceof Grade))
		{
			return false;
		}
		
		Grade x = (Grade) obj;
		
		if (this.stid == x.getid() && this.cnum == x.getcnum() && 
				this.grade == x.grade &&
				(this.semester.compareToIgnoreCase(x.getsemester()) == 0) )
		{
			return true;
		}
		
		else {
			return false;
		}
		
	}

	@Override
	public String toString() {
		
		return String.format("Student ID: %-10s \t Course ID:  %-10s \t Grade:  %-5s \t Semester:  %-10s \t Year: %-5s \t", stid, cnum, grade, yr, semester);

	}

	@Override
	public int compareTo(Grade o) {
		int equals;
		if(this.grade == o.getgrade())
		{
			if (this.stid > o.getid())
			{
				equals = 1;
			}
			else {
				equals = -1;
			}
		}
		
		else {
				if (this.grade > o.getgrade())
					{
						equals = -1;
					}
				else {
					equals = 1;
				}
		}
		
		return equals;
	}
}
