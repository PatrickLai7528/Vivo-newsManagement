import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

	private List<Worker> worker;

	public Manager() {

	}
	//Managerç±»ç?„å?å?‹å??
	public Manager(String name, int age, int salary, String department) {
			super(name,age,salary,department);
	}

	// ç®¡ç?†äºº??˜å¯ä»¥æŸ¥è¯¢æœ¬?ƒ¨?—¨??˜å·¥??„åŸº?œ¬ä¿¡æ¯ï¼Œè·¨?ƒ¨?—¨?Ÿ¥è¯¢æ?ç¤º??ƒé?ä?è¶³ï¼Œæ?ç¤º?œAccess Denied!??
	public String inquire(Worker e) {
		String Workerdepartment = e.getDepartment();
		if(Workerdepartment.equals(this.department)==false){
			return ("Access Denied!");
		}
		else{
			return super.show();
		}
	}

	// ç®¡ç?†äºº??˜ç?™è‡ªå·±ç?„é?Ÿä?æ·»?? å·¥ä½œäºº??˜ï?Œå?Œä??ƒ¨?—¨??„å·¥ä½œäºº??˜å¯ä»¥æ·»?? ï?Œå¹¶è¿”å?trueï¼Œä?å?Œéƒ¨?—¨??„å·¥ä½œäºº??˜æ? æ?•æ·»?? ï?Œè?”å?false
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

	// ??“å°?‡ªå·±é?Ÿä?ç?„äºº??˜å?“å?ï?Œæ²¡??‰æ?“å°?œEmpty??
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
