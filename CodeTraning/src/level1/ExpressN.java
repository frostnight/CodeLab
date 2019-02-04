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
	
	Map<Integer, Integer> tierMap = new HashMap<>();
	Map<Integer, String> operatorMap = new HashMap<>();
	List<Integer> calcList = new ArrayList<>();
	int tier = 1;
	
	public static void main(String[] args){
		ExpressN en = new ExpressN();
		System.out.println(en.solution(5, 12));
	}
	
	public int solution(int N, int number){
		
		int result = -1;
		int temp_calc = 0;
		List<Integer> tempList = null;
		
		if(N == number){
			return tier;
		}
		
		calcList.add(N);
		tier++;
		
		while(true){
			if(tier == 9){
				break;
			}
			
			int listSize = calcList.size();
			tempList = new ArrayList<>();
			
			for(int i=0; i < listSize; i++){
				int calc = calcList.get(i);
				
				temp_calc = calc + N;
				// number와 비교
				if(temp_calc == number){
					return tier;
				}
				tempList = checkMemo(tempList, temp_calc);
				
				temp_calc = calc * N;
				// number와 비교
				if(temp_calc == number){
					return tier;
				}
				tempList = checkMemo(tempList, temp_calc);
				
				temp_calc = calc / N;
				// number와 비교
				if(temp_calc == number){
					return tier;
				}
				tempList = checkMemo(tempList, temp_calc);
				
				temp_calc = calc - N;
				// number와 비교
				if(temp_calc == number){
					return tier;
				}
				tempList = checkMemo(tempList, temp_calc);
				
				if(tier == 2){
					temp_calc = calc * 11;
				} else {
					temp_calc = calc;
				}
			}
			
			
			tier++;
		}
		
		return result;
	}
	
	private List<Integer> checkMemo(List<Integer> tempList, int temp_calc){
		if(!tierMap.containsKey(temp_calc)){
			tierMap.put(temp_calc, tier);
			tempList.add(temp_calc);
		}
		return tempList;
	}
}
