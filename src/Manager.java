import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

	private List<Worker> worker;

	public Manager() {

	}
	//Manager类的初始化
	public Manager(String name, int age, int salary, String department) {
			super(name,age,salary,department);
	}

	// 管理人员可以查询本部门员工的基本信息，跨部门查询提示权限不足，提示“Access Denied!”
	public String inquire(Worker e) {
		String  Workerdepartment = e.getDepartment();
		if(Workerdepartment.equals(this.department)==false){
			return ("Access Denied!");
		}
		else{
			return super.show();
		}

	}

	// 管理人员给自己的队伍添加工作人员，同一部门的工作人员可以添加，并返回true，不同部门的工作人员无法添加，返回false
	public boolean lead(Worker e) {
		String Workerdepartment = e.getDepartment();
		if(Workerdepartment.equals(this.department)==false){
			return false;
		}
		else{
			worker.add(e);
			return true;
		}
	}

	// 打印自己队伍的人员姓名，没有打印“Empty”
	public String print() {
		if(worker.isEmpty()) {
			System.out.println("Empty");
		}
		else{
			for(Worker worker : this.worker){
				System.out.println(worker.getName());
			}
		}
		return null;
	}

	/*public static void main(String[] args) {
		Manager m = new Manager("a",19,10000,"Editor");
		Worker p = new Worker("p",21,8000,"Programmer");
		System.out.println(m.inquire(p));
	}*/
}