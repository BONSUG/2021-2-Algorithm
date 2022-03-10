import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void Minimum(int cnt, int[] s) {
		int[] arr=Arrays.copyOf(s, s.length);
		int i=0;
		int[] sorted=new int[cnt];
		while(i<cnt) {
			int min=999;
			int id=-1;
			for(int j=0;j<cnt;j++) {
				if(min>arr[j]) {
					min=arr[j];
					id=j;
				}
				}
			sorted[i]=min;
			arr[id]=999;
			i++;
		}
		
		int min_len=0;
		int sum=0;
		for(int k=0;k<cnt-1;k++) {
			if(k==0) {
				min_len=sorted[k];
				sum=min_len;
			}
			else {
				int temp=min_len+sorted[k];
				sum+=temp;
				min_len=temp;
			}
			}
		System.out.println(sum);
		for(int j=0;j<cnt;j++)
			if(j==cnt-1)
				System.out.print(sorted[j]);
			else
				System.out.print(sorted[j]+",");
		System.out.println();

	}
	
	

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			int line2 =Integer.parseInt(br.readLine());
			String[] line3 = br.readLine().split(",");
			int[] arr = new int[line2];
			arr= Arrays.stream(line3).mapToInt(Integer::parseInt).toArray();

			Minimum(line2, arr);
		}
		br.close();
		
	}
}