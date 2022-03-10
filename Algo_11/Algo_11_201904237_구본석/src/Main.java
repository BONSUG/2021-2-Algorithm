import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Edge{
	int v,w,weight;
	boolean selected;
	
	Edge(int v1,int w1,int weight1){
		this.v=v1;	this.w=w1; this.weight=weight1;
		this.selected=false;
	}
}

public class Main {
	
	static void merge(int left, int mid,int right,Edge[] list, Edge[] sorted) {
		int l=left,m=mid+1,s=left;
		
		while(l<=mid&&m<=right) {
			if(list[l].weight<=list[m].weight) {
				sorted[s++]=list[l++]; 
			}
			else {
				sorted[s++]=list[m++];
			}
		}
		if(l>mid) {
			for(int i = m;i<=right;i++) {
				sorted[s++]=list[i];
			}
		}
		else
			for(int i = l;i<=mid;i++) {
			sorted[s++]=list[i];
		}
		for(int j=left;j<=right;j++) {
			list[j]=sorted[j];			
		}
	}
	static void merge_sort(int left, int right,Edge[] list, Edge[] sorted) {
		int m;
		if(left<right) {
			m=(right+left)/2;
			merge_sort(left, m,list,sorted);
			merge_sort(m+1, right,list,sorted);
			merge(left,m,right,list,sorted);
		}
	}
	//두 집합의 합집합 구함
	static void weightedunion(Edge u, int[] union) {
		int v=collapsingfind_set(u.v, union);
		int w=collapsingfind_set(u.w, union);
		
		if((u.v!=u.w)&&((union[v]!=union[w]))) {
			union[w]=v;
			u.selected=true;
		}
		
	}
	//한 원소가 속한 집합 구함
	static int collapsingfind_set(int v, int[] union) {
		int i=v;
		for(;union[i]!=i;)
		{
			i=union[i];	
		}
		return i;
		
	}
	
	static void kruscal(Edge[] list, int v_cnt){
		
		Edge[] elist=list;
		Edge[] sorted=new Edge[elist.length];
		merge_sort(0, elist.length-1, elist, sorted);
		
		int[] union=new int[v_cnt];
		for(int i=0;i<v_cnt;i++)
			union[i]=i;
		for(int j=0;j<sorted.length;j++) {
			weightedunion(sorted[j],union);
			
		}
		int sum=0;
		for(int j=0;j<sorted.length;j++)
			if(sorted[j].selected==true) {
				System.out.println(sorted[j].v+" "+sorted[j].w);
				sum+=sorted[j].weight;
			}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) throws IOException {
		int cnt=0;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line1 = br.readLine();
		cnt = Integer.parseInt(line1);
		
		for(int i =0;i<cnt;i++) {
			
			int line2 =Integer.parseInt(br.readLine());//v
			int line3 =Integer.parseInt(br.readLine());//e
			Edge[] list = new Edge[line3];
			for(int j =0;j<line3;j++) {
				String[] eline = br.readLine().split(" ");
				int[] arr = new int[3];
				arr= Arrays.stream(eline).mapToInt(Integer::parseInt).toArray();
				Edge e =new Edge(arr[0],arr[1],arr[2]);
				list[j]=e;
			}
			kruscal(list,line2);

		}

		br.close();
		
	}
}