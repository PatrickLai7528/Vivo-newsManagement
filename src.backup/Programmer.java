import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Pattern;

public class Programmer extends Worker {
	public String language;
	public String type;

	public Programmer() {
	}

	// Programmer类�?��?��?��??
	public Programmer(String name, int age, int salary, String language,
			String type) {
		super(name, age, salary, "Programmer");
		this.language = language;
		this.age = age;
		this.type = type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// ??�照规�?�计算�?��?��?��?��??
	public String getBonus(int overtime) throws Exception {
		switch (this.type) {
		case "Develop":
			return this.getBonus(overtime, 100, 500, 0.2);
		case "Test":
			return this.getBonus(overtime, 150, 1000, 0.15);
		case "UI":
			return this.getBonus(overtime, 50, 300, 0.25);
		default:
			throw new Exception();
		}
	}

	private String getBonus(int overtime, int bonusPerEach, int max,
			double radio) {
		if(overtime > max) throw new IllegalArgumentException("Overtime illegal!");
		int overBonus = Math.min(overtime * bonusPerEach, max);
		double salary = this.salary * radio;
		DecimalFormat df = new DecimalFormat("0,000.00");
//		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
//		symbols.setDecimalSeparator(',');
//		symbols.setGroupingSeparator(' ');
//		df.setDecimalFormatSymbols(symbols);
		return df.format(overBonus + salary);
	}

	// 展示?��?��信息
	public String show() {
		String resString = "My name is " + this.name + " ; age : " + this.age
				+ " ; language : " + this.language + " ; salary : "
				+ this.salary + ".";
		return resString;
	}

	/**
	 * 信息??��??
	 * 
	 * 为�?��?�护?��?��??��?��?��?�系统�?要�?�用?��?��??��?�邮箱�?��?�起?��?? 对�?�入??�邮箱�?�电话号??��?��?��?��?��?? commnet
	 * ?��?��?���?个邮箱地??，�?�可?��?���?个电话号??��??
	 *
	 * 1. ?��子邮�? ?��箱格式为 str1@str2
	 * ?��子邮箱�?��?�称str1?���?个长度大�?2.并�?��?��?��?�含大�?��?��?��?��?�数字�?��?�符串�?��?�称str1??�紧?��符号@
	 * ????�是?��箱�??��??��?�务?��str2,str2中可?��??�含多个. 如qq.com smail.nju.edu.cn�? ?��箱地???��??��?��?��?��?个正确�?�示例为:
	 * str1@smail.nju.edu.cn 为�?��?��?�电子邮箱�?��???��?�str1??�str2中�?��?��?��?�须被转?��??��?��?��?��??
	 * 并�?��?�称str1??�第�?个�?��?��???��?个�?��?�中?��??��???��?�由 5 �? '*' �??��?? 如�?�邮箱中?��??��?��?��?�符??�格式�?�正确�?��?��?��?�illegal
	 * 
	 * 示�?��??
	 * 
	 * comment: "Qm@Qq.com"
	 * 
	 * return: "q*****m@qq.com"
	 *
	 * 2. ?��话号??? ?��话号??�是�?串�?�括?���? 0-9，以??? {'+', '-', '(', ')', ' '} 这�?�个字符??��?�符串�??
	 * 你可以�?�设?��话号??��?�含 10 ?�� 13 个数字�?? ?��话号??��?��???? 10 个数字�?��?�本?��?��??��?�在这�?��?��?�数字�?��?�国??�号??��??
	 * ?��??�号??�是?��?��?��?��?�们?��?��?��????? 4 个数字并??��?��???�其他数字�?? ?��?��?��??��?�格式�?�并且�?? "***-***-1111" 这样?��示�??
	 * 为�?��?��?��?�国??�号??��?�电话号??��?��?? "+111 111 111 1111"，�?�们�? "+***-***-***-1111"
	 * ??�格式来?��示�?�在?��?��?��??��?�面??? '+' ?�� ??�第�?�? '-' ?��仅�?�电话号??�中??�含?��??�号??�时存在?? 例�?��?��?�? 12 位�?�电话号??��?��?�以
	 * "+**-" �?头�?��?�显示�?? 注�?��?��?? "("�?")"�?" " 这样??��?�相干�?��?�符以�?��?�符??��?�述?��式�?��?��?��?��?�号??��?��?�号?��应�?�被??�除?? 示�??1:
	 * 
	 * comment: "1(234)567-890"
	 * 
	 * return: "***-***-7890"
	 * 
	 * 示�??2:
	 * 
	 * comment: "86-(10)12345678"
	 * 
	 * return: "+**-***-***-5678"
	 * 
	 * @param comment
	 */
	public String hideUserinfo(String comment) {
		if (comment.contains("@")) {
			return this.hideUserEmail(comment);
		} else {
			return this.hideUserPhone(comment);
		}
	}

	private String hideUserEmail(String email) {
		String[] spilted = email.split("@");

		// @前 的長度必須大於 @後 的長度
		if (spilted[0].length() <= 2
				|| spilted[0].length() <= spilted[1].length())
			return "illegal";

		String pattern1 = "/[A-Z]|[a-z]|[0-9]+/g";
		if (!Pattern.matches(pattern1, spilted[0]))
			return "illegal";

		String pattern2 = "/([A-Z]\\.|[a-z]\\.)*([A-Z]|[a-z]*){1}/g";
		if (!Pattern.matches(pattern2, email))
			return "illegal";

		// 轉換成小寫
		spilted[0] = spilted[0].toLowerCase();
		spilted[1] = spilted[1].toLowerCase();

		return spilted[0].charAt(0) + "*****"
				+ spilted[0].charAt(spilted[0].length() - 1) + "@"
				+ spilted[1].toLowerCase();

	}

	private String hideUserPhone(String phone) {
		if (phone.length() > 10) {
			String stars = "";
			for (int i = 10; i < phone.length(); i++) {
				stars += "*";
			}
			return "+" + stars + "-***-***-"
					+ phone.substring(phone.length() - 4, phone.length());
		} else {
			return "***-***-"
					+ phone.substring(phone.length() - 4, phone.length());
		}
	}

}
