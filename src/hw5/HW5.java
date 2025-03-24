package hw5;

import java.util.Scanner;

public class HW5 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("******************************************************************************");
		System.out.println("**   ****   **   **** ****   **** **********   **     ****** *** * *** *     *");
		System.out.println("* *** ***** * *** **  *** *** **  ********* *** * ********** *** * *** * *****");
		System.out.println("* ********* * *** *** *** **  *** ************* * ********** *** * * * * *****");
		System.out.println("* ********* *     *** *** * * *** **********   **    *******     * * * *    **");
		System.out.println("* ********* * *** *** ***  ** *** ************* ***** ****** *** * * * ***** *");
		System.out.println("* *** * *** * *** *** *** *** *** ********* *** * *** ****** *** *  *  * *** *");
		System.out.println("**   ***   ** *** **   ***   ***   **     **   ***   ******* *** * *** **   **");
		System.out.println("******************************************************************************");
		System.out.println("你想要看哪一題？\n（共5題，輸入0執行全部，其它則退出）");
		switch(sc.nextLine()) {
		case "0":
			q1(sc);
			System.out.println("========================================");
			q2();
			System.out.println("========================================");
			q3();
			System.out.println("========================================");
			q4();
			System.out.println("========================================");
			q5();
			break;
		case "1":
			q1(sc);
			break;
		case "2":
			q2();
			break;
		case "3":
			q3();
			break;
		case "4":
			q4();
			break;
		case "5":
			q5();
			break;
		}
		sc.close();
		System.out.println("========================================");
		System.out.println("程式執行結束。");
	}
	public static void q1(Scanner sc) {
		System.out.println("第一題：");
//		請設計一個方法為starSquare(int width, int height)，當使用者鍵盤輸入寬與高時，即會印出對應的*長方形，如圖:
		
//			請輸入寬與高：
//			5 4
//			*****
//			*****
//			*****
//			*****
		int[] edges = new int[2];
		System.out.println("請輸入寬與高（中間以空格分隔）：");
		while (true) {
			// 逐項檢查輸入的內容是不是數字
			while (true) {
				if (sc.hasNextInt()) {
					edges[0] = sc.nextInt();
					if (sc.hasNextInt()) {
						edges[1] = sc.nextInt();
						break;
					}
				}
				System.out.println("輸入的內容包含非數字！");
				System.out.println("請重新輸入寬與高（中間以空格分隔）：");
				sc.nextLine();
			}
			// 檢查日期是否存在
			if (edges[0]>=0 && edges[1]>=0) {
				starSquare(edges[0], edges[1]);
				break;
			}
			else {
				System.out.println("輸入的寬與高不得小於0！");
				System.out.println("請重新輸入寬與高（中間以空格分隔）：");
				sc.nextLine();
			}
		}
		
	}
	static void starSquare(int width, int height) {
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void q2() {
		System.out.println("第二題：");
//		請設計一個方法為randAvg()，從10個0～100(含100)的整數亂數中取平均值並印出這10個亂數與平均值，如圖：
//		
//		  本次亂數結果：
//		  32 35 15 12 81 28 20 45 40 21
//		  32
		randAvg();
	}
	static void randAvg() {
		System.out.println("本次亂數結果：");
		double avg = 0;
		for (int i=0; i<10; i++) {
			int num = (int)(Math.random() * 101);
			avg += num;
			System.out.print(num + " ");
		}
		System.out.println();
		avg /= 10;
		System.out.println("平均值：" + avg);
		;
	}
	
	public static void q3() {
		System.out.println("第三題：");
//		利用Overloading，設計兩個方法int maxElement(int x[][])與double maxElement(double x[][])，
//		可以找出二維陣列的最大值並回傳，如圖：
//		
//		  int[][] intArray = {
//		          {1, 6, 3},
//		          {9, 5, 2}
//		  };
//		  double[][] doubleArray = {
//		                    {1.2, 3.5, 2.2},
//		                    {7.4, 2.1, 8.2}
//		  };
//		  Work03 w = new Work03;
//		  System.out.println(w.maxElement(intArray));    // 9
//		  System.out.println(w.maxElement(doubleArray)); // 8.2
//	      
//		 
		int[][] intArray = {
		        {1, 6, 3},
		        {9, 5, 2}
		};
		double[][] doubleArray = {
                {1.2, 3.5, 2.2},
                {7.4, 2.1, 8.2}
		};
		HW5 w = new HW5();
		System.out.println(w.maxElement(intArray));    // 9
		System.out.println(w.maxElement(doubleArray)); // 8.2
	}
	int maxElement(int x[][]) {
		int max = x[0][0];
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}
	double maxElement(double x[][]) {
		double max = x[0][0];
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}
	
	public static void q4() {
		System.out.println("第四題：");
//		請設計一個類別MyRectangle：
//		(1) 有兩個double型態的屬性為width、depth
//		(2) 有三個方法：
//			void setWidth(double width)：將收到的引數指定給width屬性
//			void setDepth(double depth)：將收到的引數指定給depth屬性
//			double getArea()：能計算該長方形的面積
//		(3) 有兩個建構子：
//			public MyRectangle()：不帶參數也無內容的建構子
//			public MyRectangle(double width, double depth)：傳入的兩個引數會指定給對應的屬性
//		請另外建立一個MyRectangleMain類別，此類別只有main方法
//		(1) 使用public MyRectangle()建構子建立物件，設定width、depth為10、20，透過getArea()印出結果
//		(2) 使用public MyRectangle(double width, double depth)建構子建立物件，設定width、depth為10、20，
//			透過getArea()印出結果
		MyRectangle r1 = new MyRectangle();
		r1.setWidth(10);
		r1.setDepth(20);
		r1.getArea();
		MyRectangle r2 = new MyRectangle(10, 20);
		r2.getArea();
	}
	public static void q5() {
		System.out.println("第五題：");
//		身為程式設計師的你，收到一個任務，要幫系統的註冊新增驗證碼的功能，請設計一個方法genAuthCode()，
//		當呼叫此方法時，會回傳一個8位數的驗證碼，此驗證碼內容包含了英文大小寫與數字的亂數組合，如圖：
//		
//		  本次隨機產生驗證碼為：
//		  GLSe3X81
//		
		genAuthCode();
	}
	static String genAuthCode() {
		String code = "";
		// 0~9: 48-57,  10個 
		// A~Z: 65-90,  26個
		// a~z: 97-121, 26個
		for (int i=0; i<8; i++) {
			int x = (int)(Math.random() * 62) + 1;
			if (x<=10) {
				code += (char)(x+47);
			}
			else if (x<=36) {
				code += (char)(x+54);
			}
			else {
				code += (char)(x+60);
			}
		}
		System.out.println("本次隨機產生驗證碼為：\n" + code);
		return code;
	}
}

class MyRectangle {
	double width, depth;
	void setWidth(double width) {
		this.width = width;
	}
	void setDepth(double depth) {
		this.depth = depth;
	}
	double getArea() {
		double area = width*depth;
		System.out.println("Area: " + area);
		return width*depth;
	}
	public MyRectangle() {
		
	}
	public MyRectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}
}
class MyRectangleMain {
	public static void main(String[] args) {
		MyRectangle r1 = new MyRectangle();
		r1.setWidth(10);
		r1.setDepth(20);
		r1.getArea();
		MyRectangle r2 = new MyRectangle(10, 20);
		r2.getArea();
		
	}
}
