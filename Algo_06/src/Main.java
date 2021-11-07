import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static int Minimum(int cnt, int[] p) {
		int[][] M = new int[cnt+1][cnt+1];
		int[][] S = new int[cnt+1][cnt+1];
		if(cnt<=2) return 0;
		for(int i=0;i<=cnt;i++) {
			M[0][i]=0;
			M[i][0]=0;
			M[i][i]=1;
		}

		for(int l=2;l<=cnt;l++) {
			for(int i=1;i<=cnt-l+1;i++) {
				int j=i+l-1;
				int temp=0;
				int pcnt=0;
				if(i==j) 
					continue;
				else {
					M[i][j]=999;

					for(int pi=i-1;((pi+1)<=j)&&(pi<p.length);pi++) {
						temp=0;
						if(j-i+1==2)
							M[i][j]=2;
						if((p[pi]==1)&&(pi+1!=j)) {
							pcnt++;
							if(((pi+1-i+1)==1)&&(j-(pi+1))>1) {
								temp=M[pi+2][j]+1;
								if((S[pi+2][j]!=0)&&(S[pi+2][j]>=pi+1))
									temp+=M[pi+2][j];
							}
							else if(((pi+1-i+1)>1)&&(j-(pi+1))==1) {
								temp=M[i][pi+1]+1;
								if((S[i][pi+1]!=0)&&(S[i][pi+1]<=pi+2))
									temp+=M[i][pi+1];
							}
							else if(((pi+1-i+1)==1)&&(j-(pi+1))==1)
								temp=2;
							else if(((pi+1-i+1)>1)&&(j-(pi+1))>1) {
								temp=j-i+1;
								if((S[i][pi+1]!=0)&&(S[i][pi+1]<=pi+2))
									temp+=M[i][pi+1];
								if((S[pi+2][j]!=0)&&(S[pi+2][j]>=pi+1))
									temp+=M[pi+2][j];
							}
								
							
							if(M[i][j]>=temp) {
								M[i][j]=temp;
								S[i][j]=pi+1;
							}
						}
						else if(((pi)==j-1)&&pcnt==0) {
								M[i][j]=j-i+1;
							break;
						}
						else if(((pi)==p.length-1)&&pcnt==0) {
							M[i][j]=j-i+1;
							break;
						}
						else continue;
					
					}
				}
			}
		}
		
		return M[1][cnt];
	}

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		int arr_cnt=0;
		
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			String[] line2 = br.readLine().split("");
			arr_cnt = line2.length;
			String[] line3 = br.readLine().split("");
			int[] arr = new int[arr_cnt];
			arr= Arrays.stream(line3).mapToInt(Integer::parseInt).toArray();

			System.out.println(Minimum(arr_cnt, arr));
		}
		br.close();
		
	}
}