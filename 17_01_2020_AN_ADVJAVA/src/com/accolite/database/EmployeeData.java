package database;

public class EmployeeData {
	
	int id, dept_id;
	String firstname,lastname,dept_name,dept_head;
	public int get_id () {
		return id;
	}
	public void set_dept_id (int dept_id) {
		this.dept_id = dept_id;
	}
	public int get_dept_id () {
		return dept_id;
	}
	public void set_id(int id) {
		this.id=id;
	}
	public void set_firstname(String firstname)
	{
		this.firstname=firstname;
	}
	public String get_firstname()
	{
		return this.firstname;
	}
	public void set_lastname(String lastname)
	{
		this.lastname=lastname;
	}
	public String get_lastname()
	{
		return this.lastname;
	}
	public void set_deptid(int dept_id)
	{
		this.dept_id=dept_id;
	}
	public int get_deptid()
	{
		return this.dept_id;
	}
	public void set_deptname(String dept_name)
	{
		this.dept_name=dept_name;
	}
	public String get_deptname()
	{
		return this.dept_name;
	}
	@Override
	public String toString() {
		return "Employee [Employee_ID=" + id + ", FirstName=" + firstname + ", LastName=" + lastname + ", Deptartment_ID=" + dept_id + ", Department_Name="
				+ dept_name + "]";
	}
	
}
