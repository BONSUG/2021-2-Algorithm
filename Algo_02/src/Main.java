import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		int arr_cnt=0;
		int[][] arr;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			String line2 = br.readLine();
			arr_cnt = Integer.parseInt(line2);
			arr = new int[arr_cnt][2];
			for(int j=0;j<arr_cnt;j++) {
				String line = br.readLine();
				String[] arr1 = line.split(" ");
				int[] a1= Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
				arr[j][0]=a1[0];
				arr[j][1]=a1[1];
			}
			Maximal_Point m1 = new Maximal_Point(arr);
			m1.Cut(0, arr_cnt-1,arr_cnt);
			for(int l=0;l<arr_cnt;l++) {
				if(m1.list[l][0]!=0&&m1.list[l][1]!=0)
					System.out.println(m1.list[l][0]+" "+m1.list[l][1]);
			}
			System.out.println();
		}
		br.close();
	}
}