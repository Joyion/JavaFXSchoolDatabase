package schooldata.enrollment;

public class Enroll implements Comparable<Enroll> {
	
	int stid,
		coursenum,
		year;
	String semester;
	long recordnum;
	
	
	public Enroll (int sid, int cnum, int yr, String semet) 
	{
		
		stid = sid;
		coursenum = cnum;
		year = yr;
		semester = semet;
		
	}
	
	public Enroll (int sid, int cnum, int yr, String semet, long record) 
	{
		
		stid = sid;
		coursenum = cnum;
		year = yr;
		semester = semet;
		recordnum = record;
	}
	
	public void setstid(int id)
	{
		stid = id;
	}
	
	public int getstid()
	{
		return stid;
	}
	
	public void setcnum(int cnum)
	{
		coursenum = cnum;
	}
	
	public int getcnum ()
	{
		return coursenum;
	}
	
	public void setyear(int yr)
	{
		year = yr;
	}
	
	public int getyear()
	{
		return year;
	}
	
	public void setsemester(String semet)
	{
		semester = semet;
	}
	
	public String getsemester()
	{
		return semester;
	}

	public void displayEnrollment()
	{
		System.out.println("Student ID: ");
		System.out.println(stid);
		System.out.println("Course Number: ");
		System.out.println(coursenum);
		System.out.println("Semester: ");
		System.out.println(semester);
		System.out.println("Year: ");
		System.out.println(year);
	}
	
	public void setRecord(long record) {
		
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
		
		if(!(obj instanceof Enroll))
		{
			return false;
		}
		
		Enroll x = (Enroll) obj;
		
		return (this.stid == x.getstid() && this.coursenum == x.getcnum() &&
				this.year == x.getyear() && (this.semester.compareToIgnoreCase(x.getsemester()) == 0));
				
		
	}

	@Override
	public String toString() {
	
		return 	String.format("Course ID: %-10s \t Semester:  %-25s \t Year:  %-10s \t Student ID:  %-10s", coursenum, semester, year, stid);

	}

	@Override
	public int compareTo(Enroll o) {
		int equals;
		
		if (this.year == o.getyear())
		{
			if(this.semester.compareToIgnoreCase(o.getsemester()) == 0)
			{
				if(this.coursenum == o.getcnum())
				{
					if (this.stid > o.getstid())
					{
						equals = 1;
					}
					else {
						equals = -1;
					}
				}
				
				else 
				{
					if (this.coursenum > o.getcnum())
					{
						equals = 1;
					}
					else {
						equals = -1;
					}
				}
			}
			else 	{
				equals = this.semester.compareToIgnoreCase(o.getsemester());
			}
			
		}
		
		else if (this.year > o.getyear())
		{
			equals = 1;
		}
		
		else {
			equals = -1;
		}
		
		return equals;
	}
	
	
}
