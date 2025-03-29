package hw6;

public class Calculator {
	private int x, y;
	public Calculator() {
		
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) throws ArithmeticException {
		if (y>=0) {
			this.y = y;
		} else {
			throw new ArithmeticException("次方為負值，結果回傳不為整數！");
		}
	}
	public int powerXY() throws CalException {
		if (x==0 && y==0) {
			throw new CalException("0的0次方沒有意義！");
		} else {
			System.out.println(x + "的" + y + "次方等於" + (int)Math.pow(x, y) + "。");
			return (int)Math.pow(x, y);
		}
	}
}
