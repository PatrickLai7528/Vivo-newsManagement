import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

	private List<Worker> worker;

	public Manager() {
		this.worker = new ArrayList<Worker>();
	}

	// Manager类的初始化
	public Manager(String name, int age, int salary, String department) {
		super(name, age, salary, department);
		this.worker = new ArrayList<Worker>();
	}

	// 管理人员可以查询本部门员工的基本信息，跨部门查询提示权限不足，提示“Access Denied!”
	public String inquire(Worker e) {
		String workerdepartment = e.getDepartment();
		if (!workerdepartment.equals(this.department)) {
			throw new IllegalArgumentException("Access denied!");
		} else {
			return e.show();
		}

	}

	// 管理人员给自己的队伍添加工作人员，同一部门的工作人员可以添加，并返回true，不同部门的工作人员无法添加，返回false
	public boolean lead(Worker e) {
		String workerdepartment = e.getDepartment();
		if (!workerdepartment.equals(this.department)) {
			return false;
		} else {
			worker.add(e);
			return true;
		}
	}

	// 打印自己队伍的人员姓名，没有打印“Empty”
	public String print() {
		if (worker.isEmpty()) {
			return "Empty";
		} else {
			// Statement for a\n - p1\n - p2
			String res = "Statement for " + this.name + "\n";
			for (int i = 0; i < this.worker.size(); i++) {
				Worker w = this.worker.get(i);
				res += " - " + w.getName();
				if (i != this.worker.size() - 1)
					res += "\n";
			}
			return res;
		}
	}

	/*
	 * public static void main(String[] args) { Manager m = new
	 * Manager("a",19,10000,"Editor"); Worker p = new
	 * Worker("p",21,8000,"Programmer"); System.out.println(m.inquire(p)); }
	 */
}
