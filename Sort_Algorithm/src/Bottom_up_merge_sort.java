public class Bottom_up_merge_sort {
	private void mergeSortBU(int[] arr, int n) {
		for(int sz = 1; sz < n; sz +=sz) {
			//1,2,4,8.....n
			for(int i = 0; i+sz<n; i += sz+sz) {
				//i+sz, the second part, we need garantee it exists, so i+sz<n.
				//Merge left=i, mid = i+sz-1, right=i+sz+sz-1;
				sort(arr, i, i + sz - 1, Math.min(i+sz+sz-1, n-1));
			}
		}
	}
	private void sort(int[] arr, int l, int mid, int r) {
		int[] aux = new int[r-l+1];
		for(int i = l; i <= r; i++) {
			aux[i-l] = arr[i];
		}
		int f = l;
		int s = mid + 1;
		for(int i = l; i <= r; i++) {
			if(f > mid) {
				arr[i] = aux[s-l];
				s++;
			} else if(s > r) {
				arr[i] = aux[f-l];
				f++;
			} else if(aux[f-l] > aux[s-l]) {
				arr[i] = aux[s-l];
				s++;
			} else {
				arr[i] = aux[f-l];
				f++;
			}
		}
	}
	public static void main(String[] args) {
		Bottom_up_merge_sort test = new Bottom_up_merge_sort();
		int[] arr = new int[] {1,6,7,8,2};
		test.mergeSortBU(arr, arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
