package schooldata.student;


public class Student implements Comparable<Student> {
	
	String  firstName,
	lastName,
	address,
	city,
	state;


int stid;
long recordnum = 0;

public Student () 

{
	firstName = " ";
	address = " ";
	city = " ";
	state = " ";
	stid = 0;
	
	
}

public Student (String nm, String lm, String adr, String town, String st, int id)
{
	firstName = nm;
	
	lastName = lm;

	address = adr;

	city = town;

	state = st;

	stid = id;

// end of constructor	
}	

public Student (String nm, String lm, String adr, String town, String st, int id, long record)
{
	firstName = nm;

	lastName = lm;
	
	address = adr;

	city = town;

	state = st;

	stid = id;
	
	recordnum = record;

// end of constructor	
}	
	

public void setName (String nm)
{
	
	firstName = nm;
}

public String getName ()
{
	
	return firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setAddress (String addr)
{
	
	address = addr;
	
}

public String getAddress()
{
	return address;
}

public void setCity(String town)
{
	
	city = town;
}

public String getCity()
{
	return city;
}

public void setState (String st)
{
	
	state = st;
}
	
public String getState()
{
	return state;
}

public void setID (int id)
{
	
	stid = id;
}
	
public int getID ()
{
	return stid;
}

public void setRecordnum (long record)
{
	recordnum = record;
}

public long getRecordnum ()
{
	return recordnum;
}

public void studentDisplay()
{
	System.out.println("Student ID: ");
	System.out.println(stid);
	System.out.println("Student Name: ");
	System.out.println(firstName);
	System.out.println("Address: ");
	System.out.println(address);
	System.out.println("City: ");
	System.out.println(city);
	System.out.println("State: ");
	System.out.println(state);
	
}
	
public String toString()
{
	return "Student ID: " + stid + "\t" + "First Name: " + firstName + "\t" + 
			"Last Name: " + lastName + "\t" + "Address: " + address + "\t" + 
			"City: " + city + "\t" + "State: " + state ;
	
}

@Override
public int compareTo(Student o) {
	int equals;
	equals = this.lastName.compareToIgnoreCase(o.lastName);
	if (equals == 0)
	{
		equals = this.firstName.compareToIgnoreCase(o.firstName);
		if (equals == 0)
		{
			if (this.stid > o.stid)
			{
				equals = 1;
			}
			else {
				equals = -1;
			}
			
		}
	}
	
	return equals;
}

@Override
public boolean equals(Object obj) {
	if (obj == this)
	{
		return true;
	}
	
	if (!(obj instanceof Student))
	{
		return false;
	}
	
	Student x = (Student) obj;
	
	return this.stid == x.getID();
}


	
	
	
	
	
// end of class
}
