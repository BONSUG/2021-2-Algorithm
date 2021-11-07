import java.util.Arrays;
public class Merge_sort{
	
	int inverse_cnt;
	int[] list;
	int[] sorted;
	
	Merge_sort(int[] arr){
		inverse_cnt=0;
		list = Arrays.copyOf(arr, arr.length);
		sorted=new int[list.length];
	}
	void merge(int left, int mid,int right) {
		int l=left,m=mid+1,s=left;
		
		while(l<=mid&&m<=right) {
			if(list[l]<=list[m]) {
				sorted[s++]=list[l++]; 
			}
			else {
				sorted[s++]=list[m++];
				inverse_cnt+=mid+1-l;
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
	
	void merge_sort(int left, int right) {
		int m;
		if(left<right) {
			m=(right+left)/2;
			merge_sort(left, m);
			merge_sort(m+1, right);
			merge(left,m,right);
		}
		
	}
	}