import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void PrintConnCom(int v, int[][] e) {
		int[] arr= new int[v];
		for(int l=0;l<v;l++)
			arr[l]=l;
		
		for(int i=0;i<e.length;i++) {
			int l =e[i][0];
			int r=e[i][1];
			if(l<r)
				arr[r]=l;
			else
				arr[l]=r;
		}
		int[][] temp= new int[v][v];
		for(int e1=0;e1<v;e1++) {
			int idx=1;
			
			if(arr[e1]==e1) {
				temp[e1][idx++]=e1;
				for(int n=e1+1;n<v;n++){
					if(arr[n]==e1) {
						temp[e1][idx++]=n;
						for(int nn=0;nn<v;nn++) {
							if(n==arr[nn])
								temp[e1][idx++]=nn;
						}
					}
				}
			}

			temp[e1][0]=idx;
			
		}
		for(int t=0;t<v;t++) {
			if(temp[t][0]!=1) {
				for(int id=1;id<temp[t][0]-1;id++) {
					System.out.print(temp[t][id]+", ");
				}
				System.out.println(temp[t][temp[t][0]-1]);
			}
			
		}
	}
	
	

	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			int line2 =Integer.parseInt(br.readLine());
			int line3 =Integer.parseInt(br.readLine());
			int[][] edges = new int[line3][2];
			for(int j =0;j<line3;j++) {
				String[] eline = br.readLine().split(" ");
				int[] arr = new int[3];
				arr= Arrays.stream(eline).mapToInt(Integer::parseInt).toArray();
				edges[j][0]=arr[0];
				edges[j][1]=arr[1];
			}
			PrintConnCom(line2, edges);
			if(i==0)
				System.out.println();
		}

		br.close();
		
	}
}