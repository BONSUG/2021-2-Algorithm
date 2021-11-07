import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static int idx=0;

	
	public static void merge(int[] arr,int left,int right) {
		int l=left;
		while(l<right) {
			if((arr[l+1]<arr[l])&&(arr[idx]<arr[idx+1])){
				idx=l;
				break;
			}
			if(l==right-1&&(arr[right-1]<arr[right])){
				idx=right;
				break;
			}
			l++;
		}
	}
		


	public static void merge_sort(int[] arr,int left, int right) {
		int m;
		if(left<right) {
			m=(right+left)/2;
			merge_sort(arr,left, m);
			merge_sort(arr,m+1, right);
			merge(arr,left,right);
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
			idx=0;
			String line2 = br.readLine();
			arr_cnt = Integer.parseInt(line2);
			arr = new int[arr_cnt];
			String line = br.readLine();
			String[] arr1 = line.split(" ");
			arr= Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
			merge_sort(arr,0, arr_cnt-1);
						
			System.out.println(idx);
		}
		br.close();
	}
}