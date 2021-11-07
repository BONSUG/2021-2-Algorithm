import java.util.Arrays;

public class Maximal_Point {
	
	int[][] list;
	
	Maximal_Point(int[][] arr){
		list = Arrays.copyOf(arr, arr.length);
	}
	
	void Get_Point(int left,int right) {
		int l=left;
		while(l<=right) {
			for(int i=left;i<=right;i++) {
				if(i==l) continue;
				if((list[l][0]<=list[i][0])&&(list[l][1]<=list[i][1])) {
					list[l][0]=0;
					list[l][1]=0;
					
				}
			}
			l++;
		}
	}
		

	void Cut(int start, int end,int size) {
		int m;
		
		if(size>1) {
			m=(size)/2;
			Cut(start, m/2-1,m);
			Cut(m/2, m,m);
			Cut(m+1, 3*m/2-1,m);
			Cut(3*m/2, end,m);
			Get_Point(start,end);
	}

}
}