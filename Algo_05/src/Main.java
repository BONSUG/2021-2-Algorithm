import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {


	public static boolean Multiplication_problem(String[] arr) {
		
		boolean M[][] = new boolean[arr.length+1][arr.length+1];
		if(arr.length==1) {
			if(arr[0].equals("a"))
				return true;
			else return false;
		}
			
		else {				
				for(int k=0;k<=arr.length;k++) {
					if(k==0) M[0][0]=false;
					else { 
						if(arr[k-1].equals("a")) {
							M[0][k]=M[k][0]=true;
						}
						else M[0][k]=M[k][0]=false;
						}
				}
			
				for(int i=1;i<=arr.length;i++) {
					for(int j=1;j<=arr.length;j++) {
						if (i==j) {
							M[i][j]=M[0][i];							
						}
						else if(j<i) {
							if((M[0][j]==false)&&(M[j+1][i]==true)) {
								M[i][j]=true;
							}
							else M[i][j]=false;
						}
						else {
							if((M[i][j-1]==false)&&(M[0][j]==true)) {
								M[i][j]=true;
							}
							else M[i][j]=false;
						}
					}
				}
		}
				if(M[arr.length][1]==true||M[1][arr.length]==true)
					return true;
				else return false;
	}

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		int arr_cnt=0;
		int[] arr;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			String[] line2 = br.readLine().split(""); 
			arr_cnt = line2.length;

			System.out.println(Multiplication_problem(line2));
			
		}
		
		br.close();
	}
}