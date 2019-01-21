package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 설명
아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

제한사항
N은 1 이상 9 이하입니다.
number는 1 이상 32,000 이하입니다.
수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
최솟값이 8보다 크면 -1을 return 합니다.
입출력 예
N	number	return
5	12	4
2	11
 * @author Justin
 *
 */
public class ExpressN {
	
	Map<String, Integer> memo = new HashMap<>();
	Map<String, String> expressMemo = new HashMap<>();
	List<Integer> calcMemoList = new ArrayList<>();
	
	public static void main(String[] args){
		ExpressN en = new ExpressN();
		System.out.println(en.solution(5, 12));
	}
	
	public int solution(int N, int number){
		
		int count = 1;
		
		if( N == number ){
			return count;
		}
		
		count ++;
		
		// 초기 값 세팅
		int calc = N + N;
		String key = String.valueOf(calc);
		
		if(calc != number){
			memo.put(key, count);
			calcMemoList.add(calc);
			expressMemo.put(key+",+", String.valueOf(N) + "+" + String.valueOf(N));
		} else {
			return count;
		}
		
		calc = N - N;
		key = String.valueOf(calc);
		
		if(calc != number){
			memo.put(key, count);
			calcMemoList.add(calc);
			expressMemo.put(key+",-", String.valueOf(N) + "-" + String.valueOf(N));
		} else {
			return -1;
		}
		
		calc = N * N;
		key = String.valueOf(calc);
		
		if(calc != number){
			memo.put(key, count);
			calcMemoList.add(calc);
			expressMemo.put(key+",*", String.valueOf(N) + "*" + String.valueOf(N));
		} else {
			return count;
		}
		
		calc = N / N;
		key = String.valueOf(calc);
		
		if(calc != number){
			memo.put(key, count);
			calcMemoList.add(calc);
			expressMemo.put(key+",/", String.valueOf(N) + "/" + String.valueOf(N));
		} else {
			return count;
		}
		
		calc = Integer.parseInt(String.valueOf(N) + String.valueOf(N));
		key = String.valueOf(calc);
		
		if(calc != number){
			memo.put(key, count);
			calcMemoList.add(calc);
			expressMemo.put(key+",double", String.valueOf(N) + String.valueOf(N));
		} else {
			return count;
		}
		
		while(count < 9){
			
			for(int i=0; i < calcMemoList.size(); i++){
				int memo_calc = calcMemoList.get(i);
				
				// sum + N
				calc = memo_calc + N;
				if(calc == number){
					count++;
					break;
				} else {
					key = String.valueOf(calc);
					if(!memo.containsKey(key)){
						memo.put(key, count+1);
						if(!calcMemoList.contains(calc)){
							calcMemoList.add(calc);	
						}
						expressMemo.put(key+",double", String.valueOf(N) + String.valueOf(N));
					} else {
						if(calcMemoList.contains(calc)){
							calcMemoList.remove(calc);	
						}
					}
				}
			}
		}
		
		System.out.println("memo>>"+memo.toString());
		System.out.println("expressMemo>>"+expressMemo.toString());
		return count;
	}
	
}
