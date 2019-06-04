package schooldata.department;


public class Department implements Comparable<Department> {
	private String departmentName;
	private int departmentHead;
	private int departmentNum;
	
	public Department(String departmentName, int departmentHead, int departmentNum)
	{
		this.departmentHead = departmentHead;
		this.departmentName = departmentName;
		this.departmentNum = departmentNum;
	}

	public int getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartment(int departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
		{
			return true;
		}
		
		if (!(obj instanceof Department))
		{
			return false;
		}
		
		Department x = (Department) obj;
		
		return this.departmentName == x.getDepartmentName();
	}

	@Override
	public String toString() {
		
		String output = String.format("Department Name: %-25s \t Department Head:  %-25s \t Department ID:  %-10s", departmentName, departmentHead, departmentNum);
		
		return output;
	}

	@Override
	public int compareTo(Department o) {
		int equals;
		
	if (this.departmentName.compareToIgnoreCase(o.getDepartmentName()) == 0)
	{
		
		if (this.departmentNum > o.departmentNum)
		{
			equals = 1;
		}
	
		else {
			equals = -1;
		}
	}
	
	else {
		equals = this.departmentName.compareTo(o.getDepartmentName());
	}
	return equals;
	}
	
	

}
