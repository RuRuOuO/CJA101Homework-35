package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HW8 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("******************************************************************************");
		System.out.println("**   ****   **   **** ****   **** **********   **     ****** *** * *** **   **");
		System.out.println("* *** ***** * *** **  *** *** **  ********* *** * ********** *** * *** * *** *");
		System.out.println("* ********* * *** *** *** **  *** ************* * ********** *** * * * * *** *");
		System.out.println("* ********* *     *** *** * * *** **********   **    *******     * * * **   **");
		System.out.println("* ********* * *** *** ***  ** *** ************* ***** ****** *** * * * * *** *");
		System.out.println("* *** * *** * *** *** *** *** *** ********* *** * *** ****** *** *  *  * *** *");
		System.out.println("**   ***   ** *** **   ***   ***   **     **   ***   ******* *** * *** **   **");
		System.out.println("******************************************************************************");
		System.out.println("你想要看哪一題？\n（共2題，輸入0執行全部，其它則退出）");
		switch(sc.nextLine()) {
		case "0":
			q1();
			System.out.println("==================================================");
			q2();
			break;
		case "1":
			q1();
			break;
		case "2":
			q2();
			break;
		}
		sc.close();
		System.out.println("==================================================");
		System.out.println("程式執行結束。");
	}
	public static void q1() {
		/* 請建立一個Collection物件並將以下資料加入：
		 *    Integer(100)、Double(3.14)、Long(21L)、Short("100")、Double(5.1)、
		 *    "Kitty"、Integer(100)、Object物件、"Snoopy"、BigInteger("1000")
		 * 1. 印出這個物件裡的所有元素（使用Iterator、傳統for與for-each迴圈）。
		 * 2. 移除不是java.lang.Number相關的物件。
		 * 3. 再次印出這個集合物件的所有元素，觀察是否已將非Number相關的物件移除成功。
		 */
		System.out.println("第一題：");
		
		Collection<Object> collection = new ArrayList();
		collection.add(new Integer(100));
		collection.add(new Double(3.14));
		collection.add(new Long(21L));
		collection.add(new Short("100"));
		collection.add(new Double(5.1));
		collection.add("Kitty");
		collection.add(new Integer(100));
		collection.add(new Object());
		collection.add("Snoopy");
		collection.add(new BigInteger("1000"));
		
		System.out.println("第1小題：");
		// 使用Iterator印出這個物件裡的所有元素：
		System.out.println("(1) 使用Iterator迴圈：");
		for (Iterator it = collection.iterator(); it.hasNext();)
			System.out.println(it.next());
		
		// 使用傳統for迴圈印出這個物件裡的所有元素：
		System.out.println("(2) 使用傳統for迴圈：");
		for (int i = 0; i < collection.size(); i++) {
			System.out.println(((ArrayList) collection).get(i)); // (因為Set不能使用傳統for迴圈，需先轉型成ArrayList)
		}
			
		// 使用for-each迴圈印出這個物件裡的所有元素：
		System.out.println("(3) 使用for-each迴圈：");
		for (Object obj : collection) {
			System.out.println(obj);
		}
		System.out.println("==================================================");
		
		System.out.println("第2小題：");
		Iterator<Object> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (!(obj instanceof Number)) {
				System.out.println(obj + "不是java.lang.Number相關的物件。");
				iterator.remove();
			}
		}
		System.out.println("==================================================");
		
		System.out.println("第3小題：");
		System.out.println("再次印出這個集合物件的所有元素：");
		for (Object obj : collection) {
			System.out.println(obj);
		}
	}
	public static void q2() {
		/* 請設計一個Train類別，並包含以下屬性：
		 * - 班次number，型別為int
		 * - 車種type，型別為String
		 * - 出發地start，型別為String
		 * - 目的地dest，型別為String
		 * - 票價price，型別為double
		 * 設計對應的getter/setter方法，並在main方法裡透過建構子產生以下7個Train的物件，放到每小題需使用的集合裡：
		 * - (202, "普悠瑪", "樹林", "花蓮", 400)
		 * - (1254, "區間", "屏東", "基隆", 700)
		 * - (118, "自強", "高雄", "台北", 500)
		 * - (1288, "區間", "新竹", "基隆", 400)
		 * - (122, "自強", "台中", "花蓮", 600)
		 * - (1222, "區間", "樹林", "七堵", 300)
		 * - (1254, "區間", "屏東", "基隆", 700)
		 * 1. 請寫一隻程式，能印出不重複的Train物件。
		 * 2. 請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出。
		 * 3. 承上，不僅能讓班次編號由大排到小印出，還可以不重複印出Train物件。
		 * （以上三題請根據使用的集合，練習各種取值寫法，如迭代器、for迴圈或for-each等。）
		 */

		System.out.println("第二題：");
		Train train[] = new Train[7];
		train[0] = new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		train[1] = new Train(1254, "區間", "屏東", "基隆", 700);
		train[2] = new Train(118, "自強", "高雄", "台北", 500);
		train[3] = new Train(1288, "區間", "新竹", "基隆", 400);
		train[4] = new Train(122, "自強", "台中", "花蓮", 600);
		train[5] = new Train(1222, "區間", "樹林", "七堵", 300);
		train[6] = new Train(1254, "區間", "屏東", "基隆", 700);
		
		System.out.println("第1小題：印出不重複的Train物件");
		Set<Train> trainHashSet = new HashSet();
		for(Train t: train) {
			trainHashSet.add(t);
		}
		Iterator objs1 = trainHashSet.iterator();
		while (objs1.hasNext()) {
			((Train) objs1.next()).getTrainDetail();
		}
		System.out.println("==================================================");
		
		System.out.println("第2,3小題：讓Train物件印出時，能以班次編號由大到小印出（重複/不重複）");
		System.out.println("（此兩小題共用程式碼，預設顯示第3小題，詳情請見註解！）");
		// 由於compareTo()方法都在同一個Train裡面，而TreeSet()要達到元素唯一性時，
		// 需要在此方法做return 0的設計，因此將此兩小題以第三小題呈現為主。
		// 如果要看第二題的結果，請使用Train類別中註解掉的compareTo()方法，
		// 並將原本的compareTo()方法給註解掉。
		Set<Train> trainTreeSet = new TreeSet();
		for(Train t: train) {
			trainTreeSet.add(t);
		}
		Iterator objs2 = trainTreeSet.iterator();
		while (objs2.hasNext()) {
//			System.out.println(objs2.next());
			((Train) objs2.next()).getTrainDetail();
		}
	}
}
class Train implements Comparable<Train>{
	/* 設計對應的getter/setter方法，並在main方法裡透過建構子產生以下7個Train的物件，放到每小題需使用的集合裡
	 */
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;
	
	public Train() {}
	
	public Train(int number, String type, String start, String dest, double price) {
		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void getTrainDetail() {
		System.out.println("班次：" + this.number
							+ " 車種：" + this.type
							+ " 出發地：" + this.start
							+ " 目的地：" + this.dest
							+ " 票價：" + this.price);
	}
	
	// 第2小題請使用這個compareTo()方法！
//	public int compareTo(Train aTrain) {
//		if (this.number < aTrain.number) {
//			return 1;
//		} else{
//			return -1;
//		}
//	}
	
	// 第3小題請使用這個compareTo()方法！
	public int compareTo(Train aTrain) {
		if (this.number < aTrain.number) {
			return 1;
		} else if (this.number > aTrain.number){
			return -1;
		} else {
			return 0;
		}
	}
	
	// p.313:
	// 自訂物件若要搭配HashSet達到唯一性，程式設計師需自行主動覆寫從Object類別繼
	// 承來的equals與hashCode方法，覆寫目的也是為了定義「什麼叫做一樣的物件」。
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && this.getClass() == obj.getClass()) {
			Train t = (Train) obj;
			if (this.number == t.number
					&& this.type.equals(t.type)
					&& this.start.equals(t.start)
					&& this.dest.equals(t.dest)
					&& this.price == t.price) {
				return true;
			}
		}
		return false;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + number;
		result = result * prime + (start == null ? 0 : start.hashCode());
		result = result * prime + (dest == null ? 0 : dest.hashCode());
		return result;
	}
}
