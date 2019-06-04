package schooldata.teacher;

public class Teacher implements Comparable<Teacher>{
	
	private int teacherid;
	private int dptid;
	private String FirstName, LastName, Email, Phone;
	
	
	public Teacher(int teacherid, int deptid, String firstName, String lastName, String email, String phone) {
		this.teacherid = teacherid;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Phone = phone;
		dptid = deptid;
		
	}
	

	
	public int getDptid() {
		return dptid;
	}



	public void setDptid(int dptid) {
		this.dptid = dptid;
	}


	@Override
	public String toString() {
		String output = String.format("Last Name: %-25s \t First Name:  %-25s \t ID:  %-10s \t Department ID:  %-10s", LastName, FirstName, teacherid, dptid);
		
		return output;
	}



	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}

	
// compares last name, first name then id if they are equal.
	@Override
	public int compareTo(Teacher o) {
		int equals;
		
		equals = this.LastName.compareToIgnoreCase(o.getLastName());
		
		if(this.LastName.compareToIgnoreCase(o.getLastName()) == 0)
		{
			if(this.FirstName.compareToIgnoreCase(o.getFirstName()) == 0)
			{
				if (this.teacherid > o.getTeacherid())
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
	
	

}
