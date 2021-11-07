import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		String[] arr1 = line1.split(",");
		br.close();
		
		BufferedReader br2 = new BufferedReader(new FileReader(args[1]));
		String line2 = br2.readLine();
		String[] arr2 = line2.split(",");
		br2.close();
		
		int[] a1= Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
		int[] a2= Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
		
		Merge_sort m1 = new Merge_sort(a1);
		m1.merge_sort(0, a1.length-1);

		System.out.println(m1.inverse_cnt);
	}
}
