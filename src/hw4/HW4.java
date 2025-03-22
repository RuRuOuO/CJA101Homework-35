package hw4;

import java.util.Scanner;

public class HW4 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("你想要看哪一題？\n（共6題，輸入0執行全部，其它則退出）");
		switch(sc.nextLine()) {
		case "0":
			q1();
			System.out.println("========================================");
			q2(sc);
			System.out.println("========================================");
			q3();
			System.out.println("========================================");
			q4(sc);
			System.out.println("========================================");
			q5(sc);
			System.out.println("========================================");
			q6();
			break;
		case "1":
			q1();
			break;
		case "2":
			q2(sc);
			break;
		case "3":
			q3();
			break;
		case "4":
			break;
		case "5":
			q5(sc);
			break;
		case "6":
			q6();
			break;
		}
		sc.close();
		System.out.println("========================================");
		System.out.println("程式執行結束。");
	}
	public static void q1() {
		System.out.println("第一題：");
//		有個一維陣列如下：
//		{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//		請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//		（提示：陣列，length屬性）
		int[] array_q1 = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
		int mean = arrayMean(array_q1);
		System.out.println("平均值：" + mean);
		
		System.out.print("大於平均值的元素：");
		for (int num : array_q1) {
			if (num > mean)
				System.out.print(num + " ");
		}
		System.out.println();
	}
	static int arrayMean(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum / arr.length;
	}
	
	public static void q2(Scanner sc) {
		System.out.println("第二題：");
//		請建立一個字串，經過程式執行後，輸入結果是反過來的
//		例如String s = "Hello World"，執行結果即為dlroW olleH
//		（提示：String方法，陣列）
		System.out.print("請輸入一些字：");
		String s = sc.nextLine();
		char[] s_array = s.toCharArray();
		int n = s_array.length;
		for (int i=0; i<n/2; i++) {
			char temp = s_array[i];
			s_array[i] = s_array[n-i-1];
			s_array[n-i-1] = temp;
		}
		System.out.println("反過來長這樣：" + String.valueOf(s_array));
	}
	
	public static void q3() {
		System.out.println("第三題：");
//		有個字串陣列如下（八大行星）：
//		{"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"}
//		請用程式計算出這陣列裡面共有多少個母音（a, e, i, o, u）
//		（提示：字元比對，String方法）
		String[] planets = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
		int count = 0;
		for (String planet : planets) {
			for (char c : planet.toCharArray()) {
				if ("aeiou".indexOf(c) != -1) {
					count++;
				}
			}
		}
		System.out.println("總共有" + count + "個母音。");
	}
	public static void q4(Scanner sc) {
		System.out.println("第四題：");
//		阿文上班時忘了帶錢包，想要向同事借錢，和他交情比較好的同事共有 5 個，其員工編號與身上現金列表如下：
//		
//			｜員工編號｜25  	｜32		｜8		｜19		｜27		｜
//			｜－－－－｜－－	｜－－－	｜－－－	｜－－－	｜－－－	｜
//			｜身上現金｜2500	｜800	｜500	｜1000	｜1200	｜
//		
//		請設計一個程式，可以讓小華輸入欲借的金額後，便會顯示哪些員工編號的同事有錢可借他；
//		並且統計有錢可借的總人數：例如輸入 1000 就顯示「有錢可借的員工編號： 25 19 27 共 3 人!」
//		（提示：Scanner，二維陣列）
		int[][] empMoney = {
				{25, 35, 8, 19, 27},
				{2500, 800, 500, 1000, 1200}
		};
		System.out.println("阿文，你想要向同事借多少錢？");
		int money = sc.nextInt();
		int count = 0;
		System.out.print("有錢可借的員工編號：");
		for (int i=0; i<empMoney[0].length; i++) {
			if (empMoney[1][i]>=money) {
				System.out.print(empMoney[0][i] + " ");
				count++;
			}
		}
		if (count>0) {
			System.out.println("共" + count + "人！");
		}
		else {
			System.out.println("沒有人！借太多啦！");
		}
	}
	
	public static void q5(Scanner sc) {
		System.out.println("第五題：");
//		請設計由鍵盤輸入三個整數，分別代表西元yyyy年，mm月，dd日，執行後會顯示是該年的第幾天。
//		例：輸入 1984 9 8 三個號碼後，程式會顯示「輸入的日期為該年第252天」
//		（提示1：Scanner，陣列）
//		（提示2：需將閏年條件加入）
//		（提示3：擋下錯誤輸入：例如月份輸入為2，則日期不該超過29）
		System.out.println("請輸入西元年月日，中間以空格隔開（例如：1912 1 1）：");
		int[] date = new int[3];
		// 有任何格式錯誤時就會重新執行
		while (true) {
			// 逐項檢查輸入的內容是不是數字
			while (true) {
				if (sc.hasNextInt()) {
					date[0] = sc.nextInt();
					if (sc.hasNextInt()) {
						date[1] = sc.nextInt();
						if (sc.hasNextInt()) {
							date[2] = sc.nextInt();
							break;
						}
					}
				}
				System.out.println("輸入的內容包含非數字！");
				System.out.println("請重新輸入西元年月日，中間以空格隔開（例如：1912 1 1）：");
				sc.nextLine();
			}
			// 檢查日期是否存在
			if (existDate(date[0], date[1], date[2])) {
				System.out.println("輸入的日期為該年第" + countDay(date[0], date[1], date[2]) + "天。");
				break;
			}
			else {
				System.out.println("輸入的日期不存在！");
				System.out.println("請重新輸入西元年月日，中間以空格隔開（例如：1912 1 1）：");
				sc.nextLine();
			}
		}
	}
	// 檢查日期是否存在
	static boolean existDate(int year, int month, int day) {
		// 最寬的條件：月份介於1～12、日期>=1
		if (month>12 || month<1 || day<1) {
			return false;
		}
		// 次寬的條件：根據月份，檢查日期是否不超過28、29、30、31
		if (month == 2) {
			if (isLeapYear(year)) {
				if (day > 29)
					return false;
			}
			else {
				if (day > 28)
					return false;
			}
		}
		else {
			int[] month30 = {4, 6, 9, 11};
			boolean inMonth30 = false;
			for (int m : month30) {
	            if (m == month) {
	                inMonth30 = true;
	                break;
	            }
	        }
			if (inMonth30) {
				if (day > 30)
					return false;
			}
			else {
				if (day > 31)
					return false;
			}
		}
		// 最窄的條件：特殊案例－－不存在的日期（1582年10月5日～10月14日）
		if (year == 1582 && month == 10 && day<15 && day>4) {
			System.out.println("你遇到了特殊的例外！\n詳情請搜尋「1582年10月」。");
			return false;
		}
		return true;
	}
	static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	static int countDay(int year, int month, int day) {
		int count = 0;
		switch (month) {
		case 12:
			count += 30;
		case 11:
			if (year==1582) {
				count += 21;
			}
			else {
				count += 31;
			}
		case 10:
			count += 30;
		case 9:
			count += 31;
		case 8:
			count += 31;
		case 7:
			count += 30;
		case 6:
			count += 31;
		case 5:
			count += 30;
		case 4:
			count += 31;
		case 3:
			if (isLeapYear(year)) {
				count += 29;
			}
			else {
				count += 28;
			}
		case 2:
			count += 31;
		}
		if (year==1582 && month>=10 && day>=15) {
			count += day - 10;
		}
		else {
			count += day;
		}
		return count;
	}
	
	public static void q6() {
		System.out.println("第六題：");
//		班上有8位同學，他們進行了6次考試結果如下：
//			
//			｜		｜1號	｜2號	｜3號	｜4號	｜5號	｜6號	｜7號	｜8號	｜
//			｜－－－	｜－－－	｜－－－	｜－－－	｜－－－	｜－－－	｜－－－	｜－－－	｜－－－	｜
//			｜1考	｜10		｜35		｜40		｜100	｜90		｜85		｜75		｜70		｜
//			｜2考	｜37		｜75		｜77		｜89		｜64		｜75		｜70		｜95		｜
//			｜3考	｜100	｜70		｜79		｜90		｜75		｜70		｜79		｜90		｜
//			｜4考	｜77		｜95		｜70		｜89		｜60		｜75		｜85		｜89		｜
//			｜5考	｜98		｜70		｜89		｜90		｜75		｜90		｜89		｜90		｜
//			｜6考	｜90		｜80		｜100	｜75		｜50		｜20		｜99		｜75		｜
//		
//		請算出每位同學考最高分的次數。
//		（提示：二維陣列）
		int[][] scores = {
				{10, 35, 40, 100, 90, 85, 75, 70},
				{37, 75, 77, 89, 64, 75, 70, 95},
				{100, 70, 79, 90, 75, 70, 79, 90},
				{77, 95, 70, 89, 60, 75, 85, 89},
				{98, 70, 89, 90, 75, 90, 89, 90},
				{90, 80, 100, 75, 50, 20, 99, 75}
		};
		int[] highestScoreCount = new int[8];
		for (int i=0; i<scores.length; i++) {
			int whoGetsHighestScore = 0;
			for (int j=0; j<scores[i].length; j++) {
				if (scores[i][j]>scores[i][whoGetsHighestScore]) {
					whoGetsHighestScore = j;
				}
			}
			highestScoreCount[whoGetsHighestScore] += 1;
		}
		for (int i=0; i<highestScoreCount.length; i++) {
			System.out.println("第" + (i+1) + "位同學考" + highestScoreCount[i] + "次最高分。");
		}
	}
}
