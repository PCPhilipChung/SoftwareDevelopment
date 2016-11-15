package Assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class validates and stores the credit card number.
 * @author Philip
 *
 */
public class CardValidation {

	/**
	 * This static class method takes a long argument and stores the digits into a List. It returns the stored values of List.
	 * @param l This long argument represents the credit card number.
	 * @return list This variable represents the List of stored credit card digits.
	 */
	public static List<Long> toDigits(long l){
		List<Long> list = new ArrayList<>();
		
		String[] array = (l + "").split("");
		
		for(String i : array){
			list.add(Long.parseLong(i));
		}
		
		return list;
	}
	
	/**
	 * This static class method takes a long argument and stores the digits into a list. It returns the stored values of List.
	 * @param l This long argument represents the credit card number.
	 * @return list This variable represents the the List of stored credit card digits.
	 */
	public static List<Long> toDigitsReverse(long l){
		List<Long> list = new ArrayList<>();
		
		String[] array = (l + "").split("");
		
		for(int i = array.length - 1; i >= 0; i--){
			list.add(Long.parseLong(array[i]));
		}
		
		return list;
	}
	/**
	 * This static class method takes a Long type List argument doubles every second digit in the list.
	 * This class method will work with tempList to store the values from the argument list.
	 * @param list This Long list argument represents the credit card digits to be parsed.
	 * @return tempList This Long list represents the the parsed list containing second digits that are doubled.
	 */
	public static List<Long> doubleSecond(List<Long> list){
		
		List<Long> tempList = new ArrayList<>();
		try{
			for(int i = list.size()-1; i >= 0 ; i--){
				
				if(i%2 < 1){
					tempList.add(list.get(i) * 2);
				}
				else{
					tempList.add(list.get(i));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return tempList;
	}
	
	/**
	 * This static class static method takes a Long list argument and adds the digits in the list.
	 * If the digit is greater than 9, then convert the digit to string elements and split them.
	 * Then enter a for loop to add each digit in the string array parsed back to type long.
	 * @param list This Long List argument represents the doubled values stored in the list.
	 * @return total This long type variable represents the sum of all digits in the list.
	 */
	public static long sumDigits(List<Long> list){
		
		long total = 0;
		
		for(long i : list){
			if(i > 9){
				String[] array = ("" + i).split("");
				for(String j : array){
					total += Long.parseLong(j);
				}
			}
			else{
				total += i;
			}
		}
		
		return total;
	}
	/**
	 * This static class method of type boolean takes a long argument.
	 * It will call the all the other methods starting from toDigits,doubleSecond, and sumDigits.
	 * After calling all methods, perform a modulus operation by 10 to see if it matches 0.
	 * If it does, the method will return a true, else it will false.
	 * If the result matches zero, then the method will return true, else it will return false.
	 * @param l This long argument represents the credit card number.
	 * @return ((sumDigits(doubleSecond(toDigits(l)))) % 10 == 0) ? true : false This is a series of methods called to determine if the credit card is valid or not.
	 */
	public static boolean isValid(long l){
		return ((sumDigits(doubleSecond(toDigits(l)))) % 10 == 0) ? true : false;
	}
	

}
