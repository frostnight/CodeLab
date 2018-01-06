package level2;

/**
 * reverseInt 메소드는 int형 n을 매개변수로 입력받습니다.
 * n에 나타나는 숫자를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 * n은 양의 정수입니다.
 * @author Justin
 *
 */
public class ReverseInt {
	public int reverseInt(int n){
		System.out.println("input>>"+n);
		String num = String.valueOf(n);
		String[] tempStr_arr = num.split("");
		int[] num_arr = new int[tempStr_arr.length];
		for(int i=0; i < tempStr_arr.length; i++){
			num_arr[i] = Integer.parseInt(tempStr_arr[i]);
		}
		qsort(num_arr, 0, num_arr.length - 1);
		StringBuffer s_buf = new StringBuffer();
		for(int i=0; i < num_arr.length; i++){
			s_buf.append(num_arr[i]);
		}
		return Integer.parseInt(s_buf.toString());
	}
	
	public void qsort(int[] n_arr, int s_idx, int e_idx){
		
		int pivot = n_arr[(s_idx + e_idx) / 2];
		int left = s_idx;
		int right = e_idx;
		
		do{
			while(n_arr[left] > pivot) left++;
			while(n_arr[right] < pivot) right--;
			if(left <= right){
				int temp = n_arr[left];
				n_arr[left] = n_arr[right];
				n_arr[right] = temp;
				left++;
				right--;
 			}
		}while(left <= right);
		
		if(s_idx < right) qsort(n_arr, s_idx, right);
		if(e_idx > left) qsort(n_arr, left, e_idx);
	}
	
	static String res = "";
	public static void  main(String[] args){
		//ReverseInt ri = new ReverseInt();
		//System.out.println(ri.reverseInt(118372));
		Integer.toString(118372).chars().sorted().forEach(c -> res = res + Character.valueOf((char)c));
		System.out.println(res);
	}
}
