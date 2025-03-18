package hw3;

import java.util.Scanner;

public class HW3 {
	public static void main(String[] args) {
		System.out.println("******************************************************************************");
		System.out.println("**   ****   **   **** ****   **** **********   **     ****** *** * *** **   **");
		System.out.println("* *** ***** * *** **  *** *** **  ********* *** * ********** *** * *** * *** *");
		System.out.println("* ********* * *** *** *** **  *** ************* * ********** *** * * * ***** *");
		System.out.println("* ********* *     *** *** * * *** **********   **    *******     * * * ***  **");
		System.out.println("* ********* * *** *** ***  ** *** ************* ***** ****** *** * * * ***** *");
		System.out.println("* *** * *** * *** *** *** *** *** ********* *** * *** ****** *** *  *  * *** *");
		System.out.println("**   ***   ** *** **   ***   ***   **     **   ***   ******* *** * *** **   **");
		System.out.println("******************************************************************************");
//		1. 請設計一隻程式，使用者輸入三個數字後，輸出結果會為正三角形、等腰三角形、其它三角形或不是三角形，如圖示結果：
//		
//				請輸入三個整數：		請輸入三個整數：		請輸入三個整數：		請輸入三個整數：
//				5 5 5				5 8 5				5 6 7				0 0 0
//				正三角形				等腰三角形			其它三角形			不是三角形
//		
//		（提示：Scanner，三角形成立條件，判斷式if else）
//		（進階功能：加入直角三角形的判斷）
		System.out.println("第一題：");
		Scanner sc = new Scanner(System.in);
//		建立一個array來儲存我們輸入的三角形三邊。
		int[] edgeArray = new int[3];
//		輸入三角形的三邊。
		System.out.println("請輸入三個整數：");
		for (int i=0; i<edgeArray.length; i++) {
//			檢查輸入的值是否為數字，不是的話就重新輸入到是數字為止。
			while (!sc.hasNextInt()) {
				System.out.println("It's not an integer!");
				sc.next();
			}
			edgeArray[i] = sc.nextInt();
		}
//		* 先判斷是不是三角形，是的話才要討論是哪一種三角形
		if (edgeArray[0] + edgeArray[1] <= edgeArray[2] || edgeArray[1] + edgeArray[2] <= edgeArray[0] || edgeArray[2] + edgeArray[0] <= edgeArray[1]) {
			System.out.println("不是三角形");
		}
		else {
//			* 正三角形的條件最多，需要三邊等長。
//			* 再來是等腰三角形，只需要兩邊等長。
//			* 進階挑戰－－直角三角形：
//			  直角三角形不一定等腰，而題目並不需要確認是不是等腰直角三角形，因此把順位擺在等腰三角形後面。
//			* 剩下的就是其它三角形。
			if (edgeArray[0]==edgeArray[1] && edgeArray[1]==edgeArray[2]) {
				System.out.println("正三角形");
			}
			else if (edgeArray[0]==edgeArray[1] || edgeArray[1]==edgeArray[2] || edgeArray[0]==edgeArray[2]) {
				System.out.println("等腰三角形");
			}
			else if (edgeArray[0]*edgeArray[0] + edgeArray[1]*edgeArray[1] == edgeArray[2]*edgeArray[2]
					|| edgeArray[1]*edgeArray[1] + edgeArray[2]*edgeArray[2] == edgeArray[0]*edgeArray[0]
					|| edgeArray[2]*edgeArray[2] + edgeArray[0]*edgeArray[0] == edgeArray[1]*edgeArray[1]) {
				System.out.println("直角三角形");
			}
			else {
				System.out.println("其它三角形");
			}
		}
		System.out.println("---------------------------------------------------------------------------");
		
//		2. 請設計一隻程式，會亂數產生一個0～9的數字，然後可以玩猜數字遊戲，猜錯會顯示錯誤訊息，猜對則顯示正確訊息，如圖示結果：
//		
//				開始猜數字吧！
//				5
//				猜錯囉
//				8
//				猜錯囉
//				3
//				猜錯囉
//				9
//				猜錯囉
//				2
//				猜錯囉
//				7
//				猜錯囉
//				6
//				猜錯囉
//				1
//				答對了！答案就是1
//		
//		   （提示：Scanner，亂數方法，無窮迴圈）
//		   （進階功能：產生0～100亂數，每次猜就會提示你是大於還是小於正確答案）
		System.out.println("第二題：");
		System.out.println("開始猜數字吧！（0～9）");
		int ans = (int)(Math.random() * 9) + 1;
		int guess;
		while (true) {
			if (sc.hasNextInt()) {
				guess = sc.nextInt();
				if (guess<0 || guess>9) {
					System.out.println("請輸入0～9之間的數字：");
					sc.nextLine();
					continue;
				}
				if (guess==ans) {
					System.out.println("答對了！答案就是" + ans);
					break;
				}
				else {
					System.out.println("答錯囉");
				}
			}
			else {
				System.out.println("請輸入0～9之間的數字：");
				sc.nextLine();
//				注：當hasNextInt()返回false，Scanner並不會自動重新判斷新輸入的內容，因此我們需要使用nextLine()清除錯誤輸入，確保能夠重新輸入。
			}
		}
		System.out.println("恭喜你獲得了參加進階挑戰的機會！請問你是否要挑戰呢？\n是(Y)/否(其它)");
		String wantJoin = sc.next();
		if (wantJoin.equals("Y") || wantJoin.equals("y")) {
			int minNum=0, maxNum=100;
			int ans2 = (int)(Math.random() * 100) + 1;
			int guess2;
			System.out.println("請輸入" + minNum + "～" + maxNum + "之間的數字：");
			while (true) {
				if (sc.hasNextInt()) {
					guess2 = sc.nextInt();
					if (guess2<minNum || guess2>maxNum) {
						System.out.println("請輸入" + minNum + "～" + maxNum + "之間的數字：");
						sc.nextLine();
						continue;
					}
					if (guess2==ans2) {
						System.out.println("答對了！答案就是" + ans2);
						break;
					}
					else if (guess2>ans2) {
						System.out.println("大於正確答案");
						maxNum = guess2;
					}
					else {
						System.out.println("小於正確答案");
						minNum = guess2;
					}
				}
				else {
					System.out.println("請輸入" + minNum + "～" + maxNum + "之間的數字：");
					sc.nextLine(); // 注：當hasNextInt()返回false，Scanner並不會自動重新判斷新輸入的內容，因此我們需要使用nextLine()清除錯誤輸入，確保能夠重新輸入。
				}
			}
		}
		
		System.out.println("---------------------------------------------------------------------------");
//		3. 阿文很喜歡簽大樂透（1～49），但他是個善變的人，上次討厭數字是4，但這次他想要依心情決定討厭哪個數字，請您設計一隻程式，
//		   讓阿文可以輸入他不想要的數字（1～9），畫面會顯示他可以選擇的號碼與總數，如圖：
//		
//		        阿文...請輸入你討厭哪個數字？
//		        3
//		        1	2	4	5	6	7
//		        8	9	10	11	12	14
//		        15	16	17	18	19	20
//		        21	22	24	25	26	27
//		        28	29	40	41	42	44
//		        45	46	47	48	49	總共有35數字可選
//		
//		   （提示：Scanner）
//		   （進階挑戰：輸入不要的數字後，直接亂數印出6個號碼且不得重複）
		System.out.println("第三題：");
		System.out.println("阿文...請輸入你討厭哪個數字？");
		int num = sc.nextInt();
		while (num<1 || num>9) {
			System.out.println("請輸入1～9之間的數字：");
			num = sc.nextInt();
		}
		int lottary_num_count = 0;
		for (int i=1; i<= 49; i++) {
			if (i/10!=num && i%10!=num) {
				System.out.print(i + "\t");
				if (++lottary_num_count%6==0) {
					System.out.println();
				}
//				lottary_num_count++;
			}
		}
		System.out.println("總共有" + lottary_num_count + "個數字可選");
		System.out.println("阿文...現在我有一個更方便的功能，可以直接幫你從中隨機選出6個號碼！\n請問你是否要試試看這個新功能呢？\n是(Y)/否(其它)");
		String wantTry = sc.next();
		if (wantTry.equals("Y") || wantTry.equals("y")) {
			System.out.println("阿文...請再輸入一次你討厭哪個數字？");
			int num2 = sc.nextInt();
//			檢查數字是否介於1～9之間
			while (num2<1 || num2>9) {
				System.out.println("請輸入1～9之間的數字：");
				num2 = sc.nextInt();
			}
			System.out.println("以下是符合你喜好的六個號碼：");
//			儲存已經選出幾個符合條件的號碼個數
			int lottary_num_count2 = 0;
//			建立一個array，用以儲存已選出的號碼，用於檢驗選出來的數是否已經選過
			int[] lottary_num_list = new int[6];
			
			do {
//				隨機抽號碼
				int lottary_num = (int)(Math.random() * 49) + 1;
//				判定是否符合阿文的條件，不符合就重新選號碼（使用continue進入下一次的do...while...迴圈）
				if (lottary_num%10==num2 || lottary_num/10==num2) {
					continue;
				}
//				用以記錄數字是否重覆（每次迴圈都會重置為false）
				boolean duplicate = false;
				int i;
				for (i=0; i<lottary_num_count2;i++) {
					if (lottary_num == lottary_num_list[i]) {
						duplicate = true;
						break;
					};
				}
//				如果選取的數字重覆了，就重新選號碼（使用continue進入下一次的do...while...迴圈）
				if (duplicate) {
					continue;
				}
//				前面的i最高可能會跑到6，而我們只需要到0～5
				if (i<lottary_num_list.length) {
//					儲存合格的號碼，給下次迴圈時檢查用
					lottary_num_list[i] = lottary_num;
//					儲存完之後印出來
					System.out.print(lottary_num_list[i] + "\t");
				}
//				選出來的個數++
				lottary_num_count2++;
			} while (lottary_num_count2<6);
			System.out.println();
		}
		sc.close();
		System.out.println("---------------------------------------------------------------------------");
	}
}
