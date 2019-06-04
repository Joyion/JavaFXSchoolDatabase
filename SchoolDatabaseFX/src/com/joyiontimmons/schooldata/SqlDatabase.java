package com.joyiontimmons.schooldata;


import java.util.ArrayList;

import schooldata.course.Course;
import schooldata.department.Department;
import schooldata.enrollment.Enroll;
import schooldata.grade.Grade;
import schooldata.student.Student;
import schooldata.teacher.Teacher;

import java.sql.*;

public class SqlDatabase {
	private static SqlDatabase single = null;
	Connection conn;
	Statement stat;
	
	
	private SqlDatabase(){
	
	}
	
	public static SqlDatabase getInstance() {
		
		if (single == null)
		{
			single = new SqlDatabase();
		}
		
		return single;
	}
	
	
	
	public void start() {
//        String connectionUrl = "jdbc:sqlserver://localhost:8080;databaseName=SchoolDatabase1;user=root;password=Poohbear18";

	if (conn == null)
	{
        try {
    //    	Class.forName("com.mysql.cj.jdbc.Driver");  
        	conn = DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/SchoolDatabase1","root","Poohbear18"); 
        	System.out.println("Connected to data");
            }
       catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
	}
	
	}
	
	public void createTables() throws Exception
	{
		stat = conn.createStatement();
		String studsql = "CREATE TABLE IF NOT EXISTS Students "
				+ "(StudentID int, "
				+ "FirstName varchar(100), "
				+ "LastName varchar(100), "
				+ "Address varchar(100), "
				+ "City varchar(100), "
				+ "State varchar(2), "
				+ "PRIMARY KEY (StudentID));";
		
		String teachsql = "CREATE TABLE IF NOT EXISTS Teachers "
				+ "(TeacherID int, " 
				+ "FirstName varchar(100), "
				+ "LastName varchar(100), "
				+ "Email varchar(100), "
				+ "Phone varchar(100), "
				+ "DepartmentID int, "
				+ "PRIMARY KEY (TeacherID));";
		
		String departmentsql = "CREATE TABLE IF NOT EXISTS Departments "
				+ "(DepartmentID int, "
				+ "DepartmentName varchar(100), "
				+ "DepartmentHeadID int, "
				+ "PRIMARY KEY (DepartmentID));";
		
		String coursesql = "CREATE TABLE IF NOT EXISTS Courses "
				+ "(CourseID int, "
				+ "CouresName varchar(100), "
				+ "DepartmentID int, "
				+ "TeacherID int, "
				+ "Location varchar(100), "
				+ "PRIMARY KEY (CourseID));";
		
		String enrollsql = "CREATE TABLE IF NOT EXISTS Enrollments "
				+ "(StudentID int, "
				+ "CourseID int, "
				+ "Year int, "
				+ "Semester varchar(10), "
				+ "CONSTRAINT PK_Enrollments PRIMARY KEY (StudentID, CourseID, Year, Semester));";
		
		String enrollfk1 = "ALTER TABLE Enrollments " + 
				"ADD FOREIGN KEY (StudentID) REFERENCES Students(StudentID);";
		
		String enrollfk2 = "ALTER TABLE Enrollments " + 
				"ADD FOREIGN KEY (CourseID) REFERENCES Courses(CourseID);";
		
		
		String gradesql = "CREATE TABLE IF NOT EXISTS Grades"
				+ "(StudentID int, "
				+ "CourseID int, "
				+ "Year int, "
				+ "Semester varchar(10), "
				+ "Grade varchar(1), "
				+ "CONSTRAINT PK_Grades PRIMARY KEY (StudentID, CourseID, Year, Semester));";
		
		String gradefk1 = "ALTER TABLE Grades " + 
				"ADD FOREIGN KEY (StudentID) REFERENCES Students(StudentID);";
		
		String gradefk2 = "ALTER TABLE Grades " + 
				"ADD FOREIGN KEY (CourseID) REFERENCES Courses(CourseID);";
		
		stat.execute(studsql);
		stat.execute(teachsql);
		stat.execute(departmentsql);
		stat.execute(coursesql);
		stat.execute(enrollsql);
		stat.execute(gradesql);
		stat.execute(enrollfk1);
		stat.execute(enrollfk2);
		stat.execute(gradefk1);
		stat.execute(gradefk2);
		
	}
	
	
	
	// department methods
	Department dpt;
	
	public void addDepartment (String dptid, String name, String head) throws Exception {
		if(dptid.isEmpty() || name.isEmpty() || head.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
	
		int id = Integer.parseInt(dptid);
		int headid = Integer.parseInt(head);
		stat = conn.createStatement();
		
		String dpt = "INSERT INTO Departments "
				+ "(DepartmentID, DepartmentName, DepartmentHeadID)"
				+ "VALUES ("
				+ id + ", '"
				+ name + "', "
				+ headid + ")";
		
		stat.executeUpdate(dpt);
		
	}
	
	public Department returnDepartment(){
		
		
		return dpt;
	}
	
	public void setDepartment(Department d) {
		dpt = d;
	}
	
	public ArrayList<Department> searchDepartment(String dptid, String name) throws Exception {
		if (dptid.isEmpty() && name.isEmpty())
		{
			throw new Exception ("Please fill out at least 1 field for searching");
		}
		
		stat = conn.createStatement();
		String search;
		int id;
		ArrayList<Department> dptlist = new ArrayList<Department>();
		
		if(dptid.isEmpty())
		{
			search = "Select * FROM Departments "
					+ "WHERE DepartmentName = '" + name + "';";
		}
		
		else if (name.isEmpty())
		{
		id = Integer.parseInt(dptid);
		search = "Select * FROM Departments "
				+ "WHERE DepartmentID = " + id + ";";
		}

		else {
		id = Integer.parseInt(dptid);
		search = "Select * FROM Departments "
				+ "WHERE DepartmentID = " + id + " "
				+ "AND DepartmentName = '" + name + "';";
		}
		
		ResultSet result = stat.executeQuery(search);
		while(result.next())
		{
			int departmentid = result.getInt("DepartmentID");
			int departmenthead = result.getInt("DeparmentHeadID");
			String departmentname = result.getString("DepartmentName");
			dptlist.add(new Department(departmentname, departmenthead, departmentid));
			
		}
		
		return dptlist;
			
	}
	
	public void saveDepartment(String dptid, String name, String head, Department dept) throws Exception {
		if(dptid.isEmpty() || name.isEmpty() || head.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		
		int id = Integer.parseInt(dptid);
		int headid = Integer.parseInt(head);
		stat = conn.createStatement();
		
		String dpt = "UPDATE Departments "
				+ "SET DepartmentName = '"
				+ name + "', " 
				+ "DepartmentHeadID = " + 
				+ headid + " "
				+ "WHERE DepartmentID = " + dept.getDepartmentNum() + ";";
		
		stat.executeUpdate(dpt);
	}
	
	
	
// Methods for Students 
	Student stud;
	
	public void addStudent(String nm, String lm, String adr, String town, String st, String id) throws Exception {
		if (nm.isEmpty() || lm.isEmpty() || adr.isEmpty() || town.isEmpty() || st.isBlank() || id.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(id);
		stat = conn.createStatement();
		
		String student = "INSERT INTO Students "
				+ "(StudentID, FirstName, LastName, Address, City, State)"
				+ "VALUES ("
				+ stid + ", '"
				+ nm + "', '"
				+ lm + "', '"
				+ adr + "', '"
				+ town + "', '"
				+ st + "');";
		
		stat.executeUpdate(student);
		
	}
	
	public Student returnStudent() throws Exception {
		return stud;
	}
	
	public void setStudent(Student s) {
		stud = new Student(s.getName(), s.getLastName(), s.getAddress(), s.getCity(), s.getState(), s.getID());
	}
	
	public ArrayList<Student> searchStudents(String fname, String lname, String stid) throws Exception {
		if (fname.isEmpty() && lname.isEmpty() && stid.isEmpty())
		{
			throw new Exception ("Please include one field");
		}
		
		
		stat = conn.createStatement();
		StringBuilder search = new StringBuilder("SELECT * FROM Students Where ");
		if (!fname.isEmpty())
		{
			search.append("FirstName = '" + fname + "'");
		}
		if (!lname.isEmpty())
		{
			if(!fname.isEmpty())
			{
				search.append(" AND LastName = '" + lname + "'");
			}
			else
			{
				search.append("LastName = '" + lname + "'");
			}
		}
		
		if (!stid.isEmpty())
		{
			int id = Integer.parseInt(stid);
			if(!fname.isEmpty() || !lname.isEmpty())
			{
				search.append(" AND StudentID = " + id + " ");
			}
			
			else {
				search.append("StudentID = " + id);
			}

		}
		
		search.append(";");
		
		
		ResultSet result = stat.executeQuery(search.toString());
		ArrayList <Student> students = new ArrayList<>();
		while(result.next())
		{
			int studentid = result.getInt("StudentID");
			String firstname = result.getString("FirstName");
			String lastname = result.getString("LastName");
			String address = result.getString("Address");
			String city = result.getString("City");
			String state = result.getString("State");
			students.add(new Student(firstname, lastname, address, city, state, studentid));
		}
		
		return students;
	}
	
	

	public void saveStudent(String nm, String lm, String adr, String town, String st, String id, Student stud) throws Exception {
		if (nm.isEmpty() || lm.isEmpty() || adr.isEmpty() || town.isEmpty() || st.isEmpty()|| id.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(id);
		stat = conn.createStatement();
		
		String update = "UPDATE Students "
				+ "SET FirstName = '" + nm + "', "
				+ "LastName = '" + lm + "', "
				+ "Address = '" + adr + "', "
				+ "City = '" + town + "', "
				+ "State = '" + st + "' "
				+ "WHERE StudentID = " + stud.getID() + ";";
		
		stat.executeUpdate(update);
		
	}

	

// Teacher Methods
	Teacher teach;
	public void addTeacher(String teacherid, String deptid, String firstname, String lastname, String email, String phone ) throws Exception {
		
		if(teacherid.isEmpty() || deptid.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty() || email.isEmpty())
		{
			throw new Exception ("Please fill out all fiedls");
		}
		int tid = Integer.parseInt(teacherid);
		int dptid = Integer.parseInt(deptid);
		
		stat = conn.createStatement();
		
		String add = "INSERT INTO Teachers "
				+ "(TeacherID, FirstName, LastName, Email, Phone, DepartmentID)"
				+ "VALUES ("
				+ tid + ", '"
				+ firstname + "', '"
				+ lastname + "', '"
				+ email + "', '"
				+ phone + "', "
				+ dptid + ");";
		
		stat.executeUpdate(add);
		
		
	}
	
	public void editTeacher(String teacherid, String deptid, String firstname, String lastname, String email, String phone, Teacher teacher) throws Exception {
		
		if(teacherid.isEmpty() || deptid.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty() || email.isEmpty()) 
		{
			throw new Exception ("Please fill out all fields");
		}
		int tid = Integer.parseInt(teacherid);
		int dptid = Integer.parseInt(deptid);
		stat = conn.createStatement();
		
		String update = "UPDATE Teachers "
				+ "SET FirstName = '" + firstname + "', "
				+ "LastName = '" + lastname + "', "
				+ "Email = '" + email + "', "
				+ "Phone = '" + phone + "', "
				+ "DepartmentID = " + dptid + " "
				+ "WHERE TeacherID = " + teacher.getTeacherid() + ";";
		
		stat.executeUpdate(update);
		
	}
	
	public Teacher returnTeacher() {
		return teach;
	}
	
	public void setTeacher(Teacher t)
	{
		teach = t;
	}
	
	public ArrayList<Teacher> searchTeacher(String fname, String lname, String id) throws Exception {
		if (fname.isEmpty() && lname.isEmpty() & id.isEmpty())
		{
			throw new Exception ("Please fill out at least 1 filed for searching");
		}
				
		stat = conn.createStatement();
		
		StringBuilder search = new StringBuilder("SELECT * FROM Teachers Where ");
		if (!fname.isEmpty())
		{
			search.append("FirstName = '" + fname + "'");
		}
		if (!lname.isEmpty())
		{
			if(!fname.isEmpty())
			{
				search.append(" AND LastName = '" + lname + "'");
			}
			else
			{
				search.append("LastName = '" + lname + "'");
			}
		}
		
		if (!id.isEmpty())
		{
			int tid = Integer.parseInt(id);
			if(!fname.isEmpty() || !lname.isEmpty())
			{
				search.append(" AND TeacherID = " + tid + " ");
			}
			
			else {
				search.append("TeacherID = " + tid);
			}

		}
		
		search.append(";");
		
		
		ResultSet result = stat.executeQuery(search.toString());
		ArrayList <Teacher> teachers = new ArrayList<>();
		while(result.next())
		{
			int teacherid = result.getInt("TeacherID");
			String firstname = result.getString("FirstName");
			String lastname = result.getString("LastName");
			String email = result.getString("Email");
			String phone = result.getString("Phone");
			int departmentid = result.getInt("DepartmentID");
			teachers.add(new Teacher(teacherid, departmentid, firstname, lastname, email, phone));
		}
		
		return teachers;
		
		
		
	}
	
	
	// course methods 
	Course cour;
	public void addCourse(String place, String cname, String teacherid, String departmentid, String coursenum) throws Exception {
		if (place.isEmpty() || cname.isEmpty() || teacherid.isEmpty() || departmentid.isEmpty() || coursenum.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int tid = Integer.parseInt(teacherid);
		int dptid = Integer.parseInt(departmentid);
		int cid = Integer.parseInt(coursenum);
		
		stat = conn.createStatement();
		
		String insert = "INSERT INTO Courses "
				+ "(CourseID, DepartmentID, TeacherID, Location, CourseName)"
				+ "VALUES ("
				+ cid + ", "
				+ dptid + ", "
				+ tid + ", '"
				+ place + "', '"
				+ cname + "');";
		
		stat.executeUpdate(insert);
		
	}
	
	public void editCourse(String place, String cname, String teacherid, String departmentid, String coursenum) throws Exception {
		if (place.isEmpty() || cname.isEmpty() || teacherid.isEmpty() || departmentid.isEmpty() || coursenum.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int tid = Integer.parseInt(teacherid);
		int dptid = Integer.parseInt(departmentid);
		int cid = Integer.parseInt(coursenum);
		
		stat = conn.createStatement();
		
		String update = "UPDATE Coures "
				+ "SET TeacherID = " + tid + ", "
				+ "DepartmentID = " + dptid + ", "
				+ "Location = '" + place + "', "
				+ "CourseName = '" + cname + "' "
				+ "Where CourseID = " + cid + ";";
		
		stat.executeUpdate(update);
		
		
	}
	
	public Course returnCourse() {
		return cour;
	}
	
	public void setCourse(Course c) {
		cour = c;
	}
	
	public ArrayList<Course> searchCourses(String cname, String courseid) throws Exception {
		if (cname.isEmpty() && courseid.isEmpty())
		{
			throw new Exception("Please include Course Name or Course ID");
		}
		
		StringBuilder search = new StringBuilder("SELECT * FROM Courses WHERE ");
		
		if(!cname.isEmpty())
		{
			search.append("CourseName = '" + cname +"'");
		}
		
		if(!courseid.isEmpty())
		{
			if (!cname.isEmpty())
			{
				search.append(" AND CourseID = " + Integer.parseInt(courseid));
			}
			else {
				search.append("CourseID = " + Integer.parseInt(courseid));
			}
		}
		
		search.append(";");
		
		ResultSet result = stat.executeQuery(search.toString());
		ArrayList<Course> courses = new ArrayList<>();
		while(result.next())
		{
			String location = result.getString("Location");
			String coursename = result.getString("CourseName");
			int teacherid = result.getInt("TeacherID");
			int departmentid = result.getInt("DepartmentID");
			int cid = result.getInt("CourseID");
			
			courses.add(new Course(location, coursename, teacherid, departmentid, cid));
		}
		
		return courses;
		
	}
	
	// enrollment records
	
	Enroll enroll;
	public void addEnrollment(String studentid, String coursenum, String year, String semester) throws Exception {
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String insert = "INSERT INTO Enrollments "
				+ "(StudentID, CourseID, Year, Semester) "
				+ "Values ("
				+ stid + ", "
				+ cid + ", "
				+ year + ", '"
				+ semester + "');";
		
		stat.executeUpdate(insert);
		
		
	}

	public void editEnrollment(String studentid, String coursenum, String year, String semester, Enroll e) throws Exception {
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String update = "UPDATE Enrollments "
				+ "SET CourseID = " + cid + ", "
				+ "SET StudentID = " + stid + ", "
				+ "SET Year = " + yr + ", "
				+ "SET Semester = '" + semester + "' "
				+ "WHERE CourseID = " + e.getcnum() + " AND "
				+ "StudentID = " + e.getstid() + " AND "
				+ "Year = " + e.getyear() + " AND " 
				+ "Semester = '" + e.getsemester() + "';";
		
		stat.executeUpdate(update);
		
	}
	
	public Enroll returnEnrollment() {
		return enroll;
		
	}
	
	
	public ArrayList<Enroll> searchEnroll(String studentid, String coursenum, String year, String semester, Enroll e) throws Exception{
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String search = "Select * Enrollments WHERE "
				+ "StudentID = " + stid + " AND "
				+ "CourseID = " + cid + " AND "
				+ "Year = " + yr + " AND "
				+ "Semester = '" + semester + "';";
		
		ResultSet result = stat.executeQuery(search);
		ArrayList<Enroll> enrollments = new ArrayList<>();
		while(result.next())
		{
			int newstudentid = result.getInt("StudentID");
			int newcourseid = result.getInt("CourseID");
			int newyear = result.getInt("Year");
			String newsemester = result.getString("Semester");
			enrollments.add(new Enroll(newstudentid, newcourseid, newyear, newsemester));
		}
		
		return enrollments;
		
	}
	
	
	// grade methods
	
	Grade grade;
	
	public void addGrade(String studentid, String coursenum, String year, String semester, String grade) throws Exception {
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank() || grade.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String insert = "INSERT INTO Grades "
				+ "(StudentID, CourseID, Year, Semester, Grade) "
				+ "Values ("
				+ stid + ", "
				+ cid + ", "
				+ year + ", '"
				+ semester + "', '"
				+ grade + "');";
				
		stat.executeUpdate(insert);
	}
	public void editGrade(String studentid, String coursenum, String year, String semester, String grade, Grade g) throws Exception {
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank() || grade.isEmpty())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String update = "UPDATE Grades "
				+ "SET CourseID = " + cid + ", "
				+ "StudentID = " + stid + ", "
				+ "Year = " + yr + ", "
				+ "Semester = '" + semester + "', "
				+ "Grade = '" + grade + "' "
				+ "WHERE CourseID = " + g.getcnum()+ " AND "
				+ "StudentID = " + g.getid() + " AND "
				+ "Year = " + g.getyear() + " AND " 
				+ "Semester = '" + g.getsemester() + "';";
		
		stat.executeUpdate(update);
	}
	
	public Grade returnGrade() {
		return grade;
	}
	
	public void setGrade(Grade g)
	{
		grade = g;
	}
	
	public ArrayList<Grade> searchGrades(String studentid, String coursenum, String year, String semester) throws Exception {
		if (studentid.isEmpty() || coursenum.isEmpty() || year.isEmpty() || semester.isBlank())
		{
			throw new Exception ("Please fill out all fields");
		}
		int stid = Integer.parseInt(studentid);
		int cid = Integer.parseInt(coursenum);
		int yr = Integer.parseInt(year);
		stat = conn.createStatement();
		
		String search = "Select * Grades WHERE "
				+ "StudentID = " + stid + " AND "
				+ "CourseID = " + cid + " AND "
				+ "Year = " + yr + " AND "
				+ "Semester = '" + semester + "';";
		
		ResultSet result = stat.executeQuery(search);
		ArrayList<Grade> grades = new ArrayList<>();
		while(result.next())
		{
			int newstudentid = result.getInt("StudentID");
			int newcourseid = result.getInt("CourseID");
			int newyear = result.getInt("Year");
			String newsemester = result.getString("Semester");
			String newgrade = result.getString("Grade");
			grades.add(new Grade(newstudentid, newcourseid, newyear, newsemester, newgrade.charAt(0)));
		}
		
		return grades;
	}
	
	
	}


