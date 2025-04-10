package hw7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class HW7 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("******************************************************************************");
		System.out.println("**   ****   **   **** ****   **** **********   **     ****** *** * *** *     *");
		System.out.println("* *** ***** * *** **  *** *** **  ********* *** * ********** *** * *** ***** *");
		System.out.println("* ********* * *** *** *** **  *** ************* * ********** *** * * * **** **");
		System.out.println("* ********* *     *** *** * * *** **********   **    *******     * * * *** ***");
		System.out.println("* ********* * *** *** ***  ** *** ************* ***** ****** *** * * * *** ***");
		System.out.println("* *** * *** * *** *** *** *** *** ********* *** * *** ****** *** *  *  *** ***");
		System.out.println("**   ***   ** *** **   ***   ***   **     **   ***   ******* *** * *** *** ***");
		System.out.println("******************************************************************************");
		System.out.println("你想要看哪一題？\n（共5題，輸入0執行全部，其它則退出）");
		switch(sc.nextLine()) {
		case "0":
			q1();
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
			q1();
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
	
	public static void q1() {
		/* 請寫一個程式讀取Sample.txt檔案，並輸出以下訊息：
		 * 
		 *   Sample.txt檔案共有xxx個位元組，yyy個字元，zzz列資料
		 * 
		 */
		System.out.println("第一題：");
		try {
			File f = new File("C:/CJA101_Workspace/Homework-35/src/hw7/Sample.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			long bitCount = f.length();
			int charCount = 0, lineCount = 0;
			String str;
			while ((str = br.readLine()) != null) {
				charCount += str.length();
				lineCount += 1;
			}
			br.close();
			fr.close();
			System.out.println("Sample.txt檔案共有" + bitCount + "個位元組，" + charCount + "個字元，" + lineCount + "列資料。");
		} catch (IOException e){
			System.out.println("找不到檔案！");
		}
	}
	
	public static void q2() {
		/* 請寫一支程式，能夠亂數產生10個1～1000的整數，並寫入一個名為Data.txt的檔案裡
		 * （請使用append功能讓每次執行結果都能被保存起來）
		 */ 
		System.out.println("第二題：");
		try {
			File f = new File("C:/CJA101_Workspace/Homework-35/src/hw7/Data.txt");
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i=0; i<10; i++) {
				pw.print((int)(Math.random()*1000 + 1) + " ");
			}
			pw.println();
			pw.close();
			bw.close();
			fw.close();
			System.out.println("輸出成功！");
		} catch (IOException e) {
			System.out.println("failed");
		}
	}
	
	public static void q3() {
		/* 請從無到有試著完成一個方法名為copyFile，這個方法有兩個參數。
		 * 呼叫此方法時。第一個參數所代表的檔案會複製到第二個參數代表的檔案
		 */
		System.out.println("第三題：");
		File f1 = new File("C:/CJA101_Workspace/Homework-35/src/hw7/Data.txt");
		File f2 = new File("C:/CJA101_Workspace/Homework-35/src/hw7/Data_copy.txt");
		copyFile(f1, f2);
	}
	public static void copyFile(File file1, File file2) {
		try {
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			String str;
			while ((str = br.readLine()) != null) {
				pw.println(str);
			}
			br.close();
			fr.close();
			pw.close();
			bw.close();
			fw.close();
			System.out.println("輸出成功！");
		} catch (IOException e) {
			System.out.println("FAILED!");
		}
	}
	
	public static void q4() throws Exception {
		/* 請寫一支程式，利用老師提供的Dog與Cat類別分別產生兩個物件，寫到C:\data\Object.ser裡。
		 * 注意物件寫入需注意的事項，若C:\內沒有data資料夾，請用程式新增這個資料夾
		 */
		System.out.println("第四題：");
		String dir = "C:/data";
		File f = new File(dir);
		if (!f.isDirectory()) {
			f.mkdir();
		}
		
		Animal[] animals = new Animal[4];
		animals[0] = new Cat("Neko");
		animals[1] = new Cat("Oken");
		animals[2] = new Dog("Inu");
		animals[3] = new Dog("Uni");
		animals[0].speak();
		animals[1].speak();
		animals[2].speak();
		animals[3].speak();
		
		FileOutputStream fos = new FileOutputStream(dir + "/Object.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < animals.length; i++)
			oos.writeObject(animals[i]);
		oos.close();
		fos.close();
	}
	
	public static void q5() throws Exception {
		/* 承上題，請寫一個程式，能讀取Object.ser這四個物件，並執行speak()方法觀察結果如何
		 *    （請利用多型簡化本題的程式設計）
		 */
		System.out.println("第五題：");
		String dir = "C:/data/Object.ser";
		File f = new File(dir);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			System.out.println(f.getName() + "檔案內容如下: ");
			System.out.println("--------------------");
			while (true) {
				((Animal) ois.readObject()).speak();
				System.out.println("--------------------");
			}
		} catch (FileNotFoundException fe) {
			System.out.println("系統找不到指定的檔案。（請確認是否已先執行過第四題！）");
		} catch (EOFException e) {
			System.out.println("資料讀取完畢！");
		}
		if (ois != null) {
			ois.close();
		}
		if (fis != null) {
			fis.close();
		}
	}
}

class Animal implements Serializable {
	private String name;
	
	public Animal() {}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void speak() {
		System.out.println("This is Animal " + name + " speaking!");
	}
}

