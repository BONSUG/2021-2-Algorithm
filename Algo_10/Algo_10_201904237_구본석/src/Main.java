import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
public class Main {
	static int v_cnt1=0; //for search
 	static int v_cnt2=0; //for cycle
 	static String str="";

	public static void call_DFS(int v, int[][] e, int elen) {
		str="";
		v_cnt2=0;
		int[] visited = new int[v];
		v_cnt1=1;
		visited[0]=1;
		str+="0 ";
		DFS1(0,v,e,visited,elen);
		if(v_cnt2==0)
			System.out.println(str);
		else 
			System.out.println("cycle 존재");
	}
	
	public static int check_cycle(int v, int[][] e, int elen) {
		str="";
		v_cnt2=0;
		int[] visited = new int[v];
		v_cnt1=1;
		visited[0]=1;
		str+="0 ";
		DFS1(0,v,e,visited,elen);
		if(v_cnt2==0)
			return 0;
		else return 1;
		}
	
	
	public static void DFS1(int i,int v, int[][] e, int[] vi,int elen) {
		int now=-1;
		for(int j=0;j<elen;j++) {
			if(i==e[j][0]&&(vi[e[j][1]]==0)) { 				
				now=e[j][1];
				break;
			}
			if(i==e[j][0]&&vi[e[j][0]]>0&&vi[e[j][1]]>0&&vi[e[j][0]]>vi[e[j][1]])
				v_cnt2++;
		}
		if(now!=-1) {
			vi[now]=v_cnt1+1;
			if(v_cnt1!=v) {
				str+=(now+" ");
				v_cnt1++;
			}
			else{
				str+=(now);
				v_cnt1++;
			}
			if(v_cnt1!=v+1) {
				DFS1(now,v,e,vi,elen);
			}
		}
		else if(now==-1&&v_cnt1!=v)
			DFS1(i-1,v,e,vi,elen);
	}
	
	public static void call_Topology(int v, int[][] e, int elen) {
		int x=check_cycle(v,e,elen);
		if(x==0) {
			str="";
			v_cnt1=1;
			Stack<Integer> s=new Stack<>();
			int[] visited = new int[v];
			TS(0,v,e,visited,elen,s);
			System.out.println(str);
			}
		else 
			System.out.println("cycle 존재");
	}
	
	public static void TS(int i,int v, int[][] e, int[] vi,int elen, Stack<Integer> s) {
		for(int j=0;j<elen;j++) {
			if(e[j][1]==i)
				return;
		}
		str+=i+" ";
		vi[i]=v_cnt1;
		v_cnt1++;
		for(int j1=0;j1<elen;j1++) {
			if(e[j1][0]==i&&vi[e[j1][1]]==0) {
				s.push(e[j1][1]);
				e[j1][0]=-1;
				e[j1][1]=-1;
			}
		}
		if(s.empty())
			return;
		else {
			int x=s.pop();
			for(;;) {
				TS(x,v,e,vi,elen,s);
				if(!s.empty())
					x=s.pop();
				else break;
			}
		}

			
		}
		
	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			int line2 =Integer.parseInt(br.readLine());//v
			int line3 =Integer.parseInt(br.readLine());//e
			int[][] edges = new int[line3][2];
			for(int j =0;j<line3;j++) {
				String[] eline = br.readLine().split(" ");
				int[] arr = new int[2];
				arr= Arrays.stream(eline).mapToInt(Integer::parseInt).toArray();
				edges[j][0]=arr[0];
				edges[j][1]=arr[1];
			}
			
			call_DFS(line2, edges,line3);
			call_Topology(line2, edges,line3);
		}

		br.close();
		
	}
}