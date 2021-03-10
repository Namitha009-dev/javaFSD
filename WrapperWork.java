import java.util.Scanner;
class WrapperWork
{
	public static void main(String[] args) {
		Integer number= new Integer(new Scanner(System.in).nextInt());
		number++;
		System.out.println(number);
		
		String numberString= number.toString();
		System.out.println(numberString.length());
	}
}