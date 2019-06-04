package schooldata.course;


public class Course implements Comparable<Course>{
	

	String location,
	cname;
int cnum, dpt, prof;
long recordnum;


// constructor
	
	public Course(String place, String coursename, int teacher, int department, int coursenum )
	{
		location = place;
		cname = coursename;
		prof = teacher;
		dpt = department;
		cnum = coursenum;

	}	
	
	public Course(String place, String coursename, int teacher, int department, int coursenum, long record )
	{
		location = place;
		cname = coursename;
		prof = teacher;
		dpt = department;
		cnum = coursenum;
		recordnum = record;
	}	
	
// constructor 
	
	public void setcid (String place)
	{
		location = place;
	}
	
	public String getLocation ()
	{
		return location;
	}
	
	public void setcname (String coursename)
	{
		cname = coursename;
	}
	
	public String getcname ()
	{
		return cname;
	}
	
	public void setprof(int teacher)
	{
		prof = teacher;
	}
	
	public int getprof()
	{
		return prof;
	}
	
	public void setdpt(int department)
	{
		dpt = department;
	}
	
	public int getdpt()
	{
		return dpt;
	}
	
	public void setcnum(int coursenum)
	{
		cnum = coursenum;
	}
	
	public int getcnum()
	{
		return cnum;
	}
	
	public void courseDisplay() 
	{
		System.out.println("Course ID: ");
		System.out.println(location);
		System.out.println("Course Name: ");
		System.out.println(cname);
		System.out.println("Professor: ");
		System.out.println(prof);
		System.out.println("Department: ");
		System.out.println(dpt);
		System.out.println("Course Number: ");
		System.out.println(cnum);
		
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
		
		if (!(obj instanceof Course))
		{
			return false;
		}
		
		Course x = (Course) obj;
		
		return this.cnum == x.getcnum();
	}

	@Override
	public String toString() {
		
		
		
		return String.format("Course ID: %-10s \t Course Name:  %-25s \t Teacher:  %-25s \t Department:  %-25s \t Location: %-25s \t", cnum, cname, prof, dpt, location);
	}

	@Override
	public int compareTo(Course o) {
		int equals;
		if (this.cname.compareToIgnoreCase(o.getcname()) == 0)
		{
			
			if (this.cnum > o.getcnum())
			{
				equals = 1;
			}
		
			else {
				equals = -1;
			}
		}
		
		else {
			equals = this.cname.compareTo(o.getcname());
		}
		return equals;
	}
	
	
	
	// end of class
}
