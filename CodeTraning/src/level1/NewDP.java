package level1;

import java.util.*;
import java.util.Map.Entry;

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
public class NewDP {

	public static void main(String[] args) {
		NewDP nDP = new NewDP();
		System.out.println("result>>"+nDP.solution(5, 87));
	}
	
	public int solution(int N, int number){
		
		int result = -1;
		int tier = 1;
		Map<Integer, Integer> tierMap = new HashMap<>();
		List<Integer> calcList = new ArrayList<>();
		List<Integer> nextCalcList = new ArrayList<>();
		int roopSize = 0;
		int calc = 0;
		int num = 0;
		
		if( N < 1 || N > 9) {
			return -1;
		}
		
		if( number < 1 || number > 32000) {
			return -1;
		}
		
		if(N == number){
			return tier;
		}
		
		StringBuffer s_buff = null;
		// N의 개수 만큼 반복
		while(true){
			
			if(tier > 8){
				result = -1;
				break;
			}
			
			roopSize = calcList.size();
			nextCalcList.clear();
			calc = 0;
			
			// 최솟값을 찾기 위한 반복 루프 시작
			for(int i=0; i < roopSize; i++){
				num = calcList.get(i);
				
				// + 연산
				calc = num + N;
				if(calc > 0 && checkMemo(tierMap, nextCalcList, number, calc, tier)) {
					result = tier;
					break;
				}
				
				// - 연산
				calc = num - N;
				if(calc > 0 && checkMemo(tierMap, nextCalcList, number, calc, tier)) {
					result = tier;
					break;
				}
				
				// * 연산
				calc = num * N;
				if(calc > 0 && checkMemo(tierMap, nextCalcList, number, calc, tier)) {
					result = tier;
					break;
				}
				
				// / 연산
				calc = num / N;
				if(calc > 0 && checkMemo(tierMap, nextCalcList, number, calc, tier)) {
					result = tier;
					break;
				}
			}
			
			// X개의 N들 문자열 합치기 TIER 당 1씩 증가			
			if(s_buff == null) s_buff = new StringBuffer();
			for(int i=0; i < tier; i++) {
				s_buff.append(String.valueOf(N));
			}
			calc = Integer.parseInt(s_buff.toString());
			nextCalcList.add(calc);
			tierMap.put(calc, tier);
			s_buff = null;
			
			System.out.println("tierMap>>"+tierMap);
			System.out.println("nextCalcList>>"+nextCalcList);
			System.out.println("calcList>>"+calcList);
			System.out.println("tier>>"+tier);
			System.out.println("===========");
			
			if(result > -1) {
				break;
			}
			
			// 계산이 끝나면 다시 최종 TIER연산값으로 리스트를 생성한다.
			calcList.clear();
			calcList.addAll(nextCalcList);
			
			tier++;
		}
		
		return result;
	}

	private boolean checkMemo(Map<Integer, Integer> tierMap, List<Integer> nextCalcList, int number, int calc, int tier) {
		boolean findCheck = false;
		
		if(calc == number) {
			findCheck = true;
		} else if(!tierMap.containsKey(calc)){
			tierMap.put(calc, tier);
			nextCalcList.add(calc);
			findCheck = false;
		}
		
		return findCheck;
	}
	
	private void tierCalculations(Map<Integer, Integer> tierMap, int tier) {
		
		Iterator<Entry<Integer, Integer>> preIterator = tierMap.entrySet().iterator();
		Iterator<Entry<Integer, Integer>> nextIterator = tierMap.entrySet().iterator();
		Entry<Integer, Integer> preSet = null;
		Entry<Integer, Integer> nextSet = null;
		int pre_tier = 2;
		int next_tier = tier - 2;
		
		while(preIterator.hasNext()) {
			if(pre_tier <= (tier-2)) {
				break;
			}
			preSet = preIterator.next();
			if(preSet.getValue() == pre_tier) {
				while(nextIterator.hasNext()) {
					if(next_tier > 1) {
						break;
					}
					nextSet = nextIterator.next();
					if(nextSet.getValue() == next_tier) {
						
					}
					next_tier--;
				}
			}
			pre_tier++;
		}
		
		for(int i=2; i <= (tier - 2); i++) {
			
			for(int j=(tier - 2); j > 1; j--) {
				
			}
		}
	}

}
