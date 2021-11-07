import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static int Minimum(int c, int k, int p) {
		int cnt=0;
		int sum=p;
		int[] coin = new int[k+1];
		for(int i=0;i<=k;i++) {
			if(i==0) {
				coin[i]=1;
				continue;
			}
			else coin[i]=c;
			
			for(int j=1;j<i;j++) {
				coin[i]*=c;
			}
		}
		
		for(int i=k;i>=0;i--) {
			int a=sum/coin[i];
			cnt+=a;
			sum=sum%coin[i];
			if(sum==0)
				break;
		}
		return cnt;
	}

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			int line2 = Integer.parseInt(br.readLine());//c
			int line3 = Integer.parseInt(br.readLine());//k
			int line4 = Integer.parseInt(br.readLine());//p
			
			System.out.println(Minimum(line2, line3, line4));
		}
		br.close();
		
	}
}