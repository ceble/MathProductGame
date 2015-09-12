import java.math.*;
import java.util.Random;

public class RandomizeQuestion {
	private int num1, num2, answer;
	
	public String getRandomizeProduct(){
		Random rand = new Random();
		num1 = rand.nextInt(10) +1;
		num2 = rand.nextInt(10) +1;
		answer = num1 * num2;
		
		return Integer.toString(num1) + " * " + Integer.toString(num2);
	}
	
	public int getNum1(){
		return num1;
	}
	
	public int getNum2(){
		return num2;
	}
	
	public int getAnswer(){
		return answer;
	}

}
