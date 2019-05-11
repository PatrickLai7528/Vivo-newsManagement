
public class Worker {
	protected String name;
	protected int age;
	protected int salary;
	protected String department;

	public Worker() {

	}
	//è¦æ?‚è?›è?Œå·¥ä½œäºº??˜å?å?‹å?–ï?Œå?“å¹´é¾„å?ä??18??–å·¥èµ„ä?ä??2000?—¶ï¼Œè?›è?Œå?‚å¸¸??ç¤ºï¼Œæ?ç¤º??…å®¹??‚é?…æ?‹è?•ç”¨ä¾?
	public Worker(String name, int age, int salary, String department) {
		if(age<18 || salary<2000){
			throw new IllegalArgumentException("Worker create error");
		}
		else{
			this.name=name;
			this.age=age;
			this.salary=salary;
			this.department=department;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	//å±•ç¤º??˜å·¥??„åŸº?œ¬ä¿¡æ¯
	public String show() {
		return "My name is " + name + " ; age : " + age + " ; salary : " + salary + " ; department : " + department + ".";		//maybe wrong
	}
	
	/*public static void main(String[] args) throws Exception {
		Worker worker=new Worker("jim",20,20,"Programmer");
		System.out.println(worker.show());
	}*/
}
