import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {


	public static boolean subset_sub_problem(int[] arr,int weight,int arr_cnt) {
		
		int M[][] = new int[arr_cnt+1][weight+1];
		if(weight==0)
			return true;
		else {				
				for(int i=1;i<=arr_cnt;i++) {
					for(int j=1;j<=weight;j++) {
						if(j<arr[i-1]) {
							M[i][j]=M[i-1][j];
							if(M[i][j]==weight)
								return true;
						}
						else {
							M[i][j]=(arr[i-1]+M[i-1][j-arr[i-1]])>M[i-1][j]?(arr[i-1]+M[i-1][j-arr[i-1]]):M[i-1][j];
							if(M[i][j]==weight)
								return true;	
						}
					}
				}
				
				return false;
		}
	}

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		int arr_cnt=0;
		int[] arr;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			int sum = Integer.parseInt(br.readLine());
			String[] line3 = br.readLine().split(","); 
			arr_cnt = line3.length;
			arr = new int[arr_cnt];
			arr= Arrays.stream(line3).mapToInt(Integer::parseInt).toArray();
			System.out.println(subset_sub_problem(arr,sum, arr_cnt));
			
		}
		
		br.close();
	}
}