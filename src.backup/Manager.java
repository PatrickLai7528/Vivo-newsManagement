import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

	private List<Worker> worker;

	public Manager() {

	}
	//Manager类�?��?��?��??
	public Manager(String name, int age, int salary, String department) {
			super(name,age,salary,department);
	}

	// 管�?�人??�可以查询本?��?��??�工??�基?��信息，跨?��?��?��询�?�示??��?��?�足，�?�示?�Access Denied!??
	public String inquire(Worker e) {
		String Workerdepartment = e.getDepartment();
		if(Workerdepartment.equals(this.department)==false){
			return ("Access Denied!");
		}
		else{
			return super.show();
		}
	}

	// 管�?�人??��?�自己�?��?��?�添??�工作人??��?��?��??��?��??�工作人??�可以添??��?�并返�?�true，�?��?�部?��??�工作人??��?��?�添??��?��?��?�false
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

	// ??�印?��己�?��?��?�人??��?��?��?�没??��?�印?�Empty??
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
