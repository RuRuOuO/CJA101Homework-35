package hw2;

public class HW2 {
	public static void main(String[] args) {
		System.out.println("******************************************************************************");
		System.out.println("**   ****   **   **** ****   **** **********   **     ****** *** * *** **   **");
		System.out.println("* *** ***** * *** **  *** *** **  ********* *** * ********** *** * *** * *** *");
		System.out.println("* ********* * *** *** *** **  *** ************* * ********** *** * * * ***** *");
		System.out.println("* ********* *     *** *** * * *** **********   **    *******     * * * **** **");
		System.out.println("* ********* * *** *** ***  ** *** ************* ***** ****** *** * * * *** ***");
		System.out.println("* *** * *** * *** *** *** *** *** ********* *** * *** ****** *** *  *  ** ****");
		System.out.println("**   ***   ** *** **   ***   ***   **     **   ***   ******* *** * *** *     *");
		System.out.println("******************************************************************************");
//		繪圖工具：https://www.asciiart.eu/text-to-ascii-art
		
		System.out.println("課堂練習：輸出九九乘法表");
		System.out.println("一、使用for迴圈 + while迴圈：");
		for (int i=1; i<=9; i++) {
			int j=1;
			while (j<=9) {
				System.out.print(i + "*" + j + "=" + i*j + "\t");
				j+=1;
			}
			System.out.println("");
		}
		
		System.out.println("\n二、使用for迴圈 + do while迴圈：");
		for (int i=1; i<=9; i++) {
			int j=1;
			do {
				System.out.print(i + "*" + j + "=" + i*j + "\t");
				j+=1;
			} while (j<=9);
			System.out.println("");
		}
		
		System.out.println("\n三、使用while迴圈 + do while迴圈：");
		int ii=1;
		while (ii<=9) {
			int j=1;
			do {
				System.out.print(ii + "*" + j + "=" + ii*j + "\t");
				j+=1;
			} while (j<=9);
			System.out.println("");
			ii++;
		}
		System.out.println("---------------------------------------------------------------------------");
		
//		1. 請設計一隻Java程式，計算1～1000的偶數和（2+4+6+8+...+1000）
		System.out.println("第一題：");
		int sum = 0;
		for (int i=1; i<=1000; i++) {
			if (i % 2 == 0) {
				sum += i*2;
			}
		}
		System.out.println("1～1000的偶數和為" + sum + "。");
		System.out.println("---------------------------------------------------------------------------");
		
//		2. 請設計一隻Java程式，計算1~10的連乘積（1*2*3*...*10）（用for迴圈）
		System.out.println("第二題：");
		int prod1 = 1;
		for (int i=1; i<=10; i++) {
			prod1 *= i;
		}
		System.out.println("1～10的連乘積為" + prod1 + "。");
		System.out.println("---------------------------------------------------------------------------");
		
//		3. 請設計一隻Java程式，計算1~10的連乘積（1*2*3*...*10）（用while迴圈）
		System.out.println("第三題：");
		int prod2 = 1;
		int prod2_count = 1;
		while (prod2_count <= 10) {
			prod2 *= prod2_count;
			prod2_count++;
		}
		System.out.println("1～10的連乘積為" + prod2 + "。");
		System.out.println("---------------------------------------------------------------------------");
		
//		4. 請設計一隻Java程式，輸出結果為以下:
//		   1 4 9 16 25 36 49 64 81 100
		System.out.println("第四題：");
		for (int i=1; i<=10; i++) {
			System.out.print(i * i + " ");
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------------");
		
//		5. 阿文很熱衷大樂透（1～49），但他不喜歡有4的數字，不論是個位數或是十位數。請設計一隻程式，
//		   輸出結果為阿文可以選擇的數字有哪些？總共有幾個？
		System.out.println("第五題：");
		System.out.print("阿文可以選擇的數字有");
		int lottary_num_count = 0;
		for (int i=1; i<= 49; i++) {
			if (i/10!=4 && i%10!=4) {
				System.out.print(i + "，");
				lottary_num_count++;
			}
		}
		System.out.print("總共有" + lottary_num_count + "個。");
		System.out.println("---------------------------------------------------------------------------");
		
//		6. 請設計一隻Java程式，輸出結果為以下：
//		   1 2 3 4 5 6 7 8 9 10
//		   1 2 3 4 5 6 7 8 9
//		   1 2 3 4 5 6 7 8
//		   1 2 3 4 5 6 7
//		   1 2 3 4 5 6
//		   1 2 3 4 5
//		   1 2 3 4
//		   1 2 3
//		   1 2
//		   1
		System.out.println("第六題：");
		for (int i=10; i>=1; i--) {
			for (int j=1; j<=i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------");
		
//		7. 請設計一隻Java程式,輸出結果為以下:
//		   A
//		   BB
//		   CCC
//		   DDDD
//		   EEEEE
//		   FFFFFF
		System.out.println("第七題：");
		for (int i=1; i<=6; i++) {
			int j = 1;
			for (j=1; j<=i; j++) {
				System.out.print((char)(i+64));
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------");
		
		
		
		
		
	}
}
