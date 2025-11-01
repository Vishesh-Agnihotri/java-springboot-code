package interviews.practice;

public class LowerUpper {
	public static void main(String[] args) {
		String name = "vishesh";
		int mid = name.length() / 2; 
		String firstHalf = name.substring(0, mid).toLowerCase();
        String secondHalf = name.substring(mid).toUpperCase();
        System.out.println(firstHalf+secondHalf);
	}
}
