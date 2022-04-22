import java.util.*;
class student{
	String name,email,dob;
	int phone;
	void setstudent(String name,String email,int phone,String dob) {
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.dob=dob;
	}
	void display() {
		System.out.println(name+"\t"+email+"\t"+phone+"\t"+dob);
	}
}
class staff extends student{
	String designation,dept;
	void setstudent(String name,String email,int phone,String dob,String designation,String dept) {
		 super.setstudent(name, email, phone, dob);
		 this.dept=dept;
		 this.designation=designation;
	}
	void display() {
		System.out.println(name+"\t"+email+"\t"+phone+"\t"+dob+"\t"+designation+"\t"+dept);
	}
}
class dept{
	String name,head;
	int emp_no;
	void setstudent(String name,String head,int emp_no) {
		 this.name=name;
		 this.head=head;
		 this.emp_no=emp_no;
	}
	void display() {
		System.out.println(name+"\t"+head+"\t"+emp_no);
	}
}
public class console {
	    public static void dispmenu(String[] options){
	        for (String option : options){
	            System.out.println(option);
	        }
	        System.out.print("Choose your option : ");
	    }
	    public static void search(ArrayList<student> students,ArrayList<staff>staffs,ArrayList<dept>depts, String search){
        	System.out.println("Students records: ");
        	System.out.println("Name\tEmail\tPhone\tDOB\t");
        	for (student student : students){
	        	if (student.name.toLowerCase().contains(search.toLowerCase()))
					student.display();
	        	else if (student.email.toLowerCase().contains(search.toLowerCase()))
					student.display();
	        	else if (student.dob.toLowerCase().contains(search.toLowerCase()))
					student.display();
	        	else if (Integer.toString(student.phone).contains(search.toLowerCase()))
					student.display();
	        }
        	System.out.println("Staffs records: ");
    		System.out.println("Name\tEmail\tPhone\tDOB\tDesignation\tdept");
	    	for (staff staff : staffs){
	        	if (staff.name.toLowerCase().contains(search.toLowerCase()))
					staff.display();
	        	else if (staff.email.toLowerCase().contains(search.toLowerCase()))
					staff.display();
	        	else if (staff.dob.toLowerCase().contains(search.toLowerCase()))
					staff.display();
	        	else if (staff.designation.toLowerCase().contains(search.toLowerCase()))
					staff.display();
	        	else if (staff.dept.toLowerCase().contains(search.toLowerCase()))
					staff.display();
	        	else if (Integer.toString(staff.phone).contains(search.toLowerCase()))
					staff.display();
	        }
    		System.out.println("Dept_Name\tDept_Head\tNo.ofemployee");
        	System.out.println("Department records: ");
	    	for (dept dept : depts){
	        	if (dept.name.toLowerCase().contains(search.toLowerCase()))
					dept.display();
	        	else if (dept.head.toLowerCase().contains(search.toLowerCase()))
					dept.display();
	        	else if (Integer.toString(dept.emp_no).contains(search.toLowerCase()))
					dept.display();
	        }
	    	System.out.println("No more Records..!!!");
	    }
	    public static void main(String[] args) {
	    	ArrayList<student> students=new ArrayList<student>();
	    	ArrayList<staff> staffs=new ArrayList<staff>();
	    	ArrayList<dept> depts=new ArrayList<dept>();
	        String[] options = {"1- Add student",
	                            "2- Add Staff",
	                            "3- Add Department",
	                            "4- Search",
	                            "5- Display information",
	                            "6-Exit"};
	        Scanner scanner = new Scanner(System.in);
	        int option = 1;
	        while (option!=6){
	            dispmenu(options);
	            try {
	                option = scanner.nextInt();
	                switch(option) {
	                case 1:
	                	student st=new student();
	                	String name,email,dob;
	                	int phone;
	                	System.out.print("Enter Name: ");
	                	name = scanner.next();
	                	System.out.print("Enter Email: ");
	                	email = scanner.next();
	                	System.out.print("Enter Phone(only number): ");
	                	phone = scanner.nextInt();
	                	System.out.print("Enter DOB: ");
	                	dob = scanner.next();
	                	st.setstudent(name,email,phone,dob);
	                	students.add(st);
	                	break;
	                case 2:
	                	staff sta=new staff();
	                	String des,dept;
	                	System.out.print("Enter Name: ");
	                	name = scanner.next();
	                	System.out.print("Enter Email: ");
	                	email = scanner.next();
	                	System.out.print("Enter Phone(only number): ");
	                	phone = scanner.nextInt();
	                	System.out.print("Enter DOB: ");
	                	dob = scanner.next();
	                	System.out.print("Enter Designation: ");
	                	des = scanner.next();
	                	System.out.print("Enter Department: ");
	                	dept = scanner.next();
	                	sta.setstudent(name,email,phone,dob,des,dept);
	                	staffs.add(sta);
	                	break;
	                case 3:
	                	dept dep=new dept();
	                	String head;
	                	int emp_no;
	                	System.out.print("Enter Dept_Name: ");
	                	name = scanner.next();
	                	System.out.print("Enter Dept_Head: ");
	                	head = scanner.next();
	                	System.out.print("Enter No. of Employee: ");
	                	emp_no = scanner.nextInt();
	                	dep.setstudent(name,head,emp_no);
	                	depts.add(dep);
	                	break;
	                case 4:
	                	System.out.print("Enter Search String: ");
	                	name = scanner.next();
	                	search(students,staffs,depts,name);
	                	break;
	                case 5:
	                	System.out.println("Students records: ");
	                	System.out.println("Name\tEmail\tPhone\tDOB\t");
	                	for(student student:students)
	                		student.display();
	                	System.out.println("Staffs records: ");
	            		System.out.println("Name\tEmail\tPhone\tDOB\tDesignation\tdept");
	                	for(staff staff:staffs)
	                		staff.display();
	            		System.out.println("Dept_Name\tDept_Head\tNo.ofemployee");
	                	System.out.println("Department records: ");
	                	for(dept de:depts)
	                		de.display();
	                	break;
	                case 6:
	                	System.exit(1);
	                }
	                
	            }
	            catch (InputMismatchException ex){
	                System.out.println("Enter proper option");
	                scanner.next();
	            }
	            catch (Exception ex){
	                System.out.println(ex+"try again");
	                scanner.next();
	            }

	        }
	    }
}
