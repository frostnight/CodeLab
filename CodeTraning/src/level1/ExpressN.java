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
	
	public static void main(String[] args){
		ExpressN en = new ExpressN();
		System.out.println("result>>"+en.solution(5, 87));
	}
	
	public int solution(int N, int number){
		
		// 각 연산값들의 TIER(N의 개수)
		Map<Integer, Integer> tierMap = new HashMap<>();
		// 계산할 마지막 TIER의 연산값
		List<Integer> calcList = new ArrayList<>();
		int tier = 1;
		int result = -1;
		int temp_calc = 0;
		List<Integer> tempList = new ArrayList<>();
		int listSize = 0;
		
		if(N == number){
			return tier;
		}
		
		// 초기에 자기자신을 세팅
		calcList.add(N);
		tierMap.put(N, tier);
		tier++;
		
		while(true){
			// TIER가 8을 크면 프로세스 중지
			if(tier > 8){
				result = -1;
				break;
			}
			
			listSize = calcList.size();
			tempList.clear();
			temp_calc = 0;
			
			// 계산할 값 리스트
			for(int i=0; i < listSize; i++){
				int calc = calcList.get(i);
				
				temp_calc = commonCalculations("+", calc, N);
				if(temp_calc == number) {
					return tier;
				} else if(temp_calc > 0) {
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
				}
				
				temp_calc = commonCalculations("*", calc, N);
				if(temp_calc == number) {
					return tier;
				} else if(temp_calc > 0) {
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
				}
				
				temp_calc = commonCalculations("-", calc, N);
				if(temp_calc == number) {
					return tier;
				} else if(temp_calc > 0) {
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
				}
				
				temp_calc = commonCalculations("/", calc, N);
				if(temp_calc == number) {
					return tier;
				} else if(temp_calc > 0) {
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
				}
				
				if(tier == 2){
					// 처음 이중N값은 이렇게 처리
					temp_calc = N * 11;
					// number와 비교
					if(temp_calc == number){
						return tier;
					}
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
					
				} else {
					// 그뒤 이중N값은 똑같이 처리한다 단 N의 개수가 1개 더 많으므로 +1을 해준다.
					temp_calc = commonCalculations("+", calc, N * 11);
					if(temp_calc == number) {
						if(tier + 1 > 8) {
							return -1;
						} else {
							return tier + 1;	
						}
						
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 1, tierMap, tempList, temp_calc);
					}

					temp_calc = commonCalculations("*", calc, N * 11);
					if(temp_calc == number) {
						if(tier + 1 > 8) {
							return -1;
						} else {
							return tier + 1;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 1, tierMap, tempList, temp_calc);
					}
					
					temp_calc = commonCalculations("/", calc, N * 11);
					if(temp_calc == number) {
						if(tier + 1 > 8) {
							return -1;
						} else {
							return tier + 1;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 1, tierMap, tempList, temp_calc);
					}
					
					temp_calc = commonCalculations("-", calc, N * 11);
					if(temp_calc == number) {
						if(tier + 1 > 8) {
							return -1;
						} else {
							return tier + 1;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 1, tierMap, tempList, temp_calc);
					}
					
				}
				/*
				if(tier == 3) {
					temp_calc = N * 111;
					// number와 비교
					if(temp_calc == number){
						return tier;
					}
					tempList = checkMemo(tier, tierMap, tempList, temp_calc);
				} else if(tier > 3){
					temp_calc = commonCalculations("+", calc, N * 111);
					if(temp_calc == number) {
						if(tier + 2 > 8) {
							continue;
						} else {
							return tier + 2;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 2, tierMap, tempList, temp_calc);
					}

					temp_calc = commonCalculations("*", calc, N * 111);
					if(temp_calc == number) {
						if(tier + 2 > 8) {
							continue;
						} else {
							return tier + 2;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 2, tierMap, tempList, temp_calc);
					}
					
					temp_calc = commonCalculations("/", calc, N * 111);
					if(temp_calc == number) {
						if(tier + 2 > 8) {
							continue;
						} else {
							return tier + 2;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 2, tierMap, tempList, temp_calc);
					}
					
					temp_calc = commonCalculations("-", calc, N * 111);
					if(temp_calc == number) {
						if(tier + 2 > 8) {
							continue;
						} else {
							return tier + 2;	
						}
					} else if(temp_calc > 0) {
						tempList = checkMemo(tier + 2, tierMap, tempList, temp_calc);
					}
				}*/
				System.out.println("tier>>"+tier);
				System.out.println("calcList>>"+calcList);
				System.out.println("tempList>>"+tempList);
				System.out.println("tierMap>>"+tierMap);
				System.out.println("=======");
			}
			System.out.println("****");
			/*System.out.println(calcList);
			System.out.println(tempList);
			System.out.println(tierMap);
			System.out.println("=======");*/
			// 반복문 끝
			
			// 계산이 끝나면 다시 최종 TIER연산값으로 리스트를 생성한다.
			calcList.clear();
			calcList.addAll(tempList);
			
			tier++;
		}
		
		return result;
	}
	
	private int commonCalculations(String operator, int pre_operand, int suf_operand) {
		int temp_calc = 0;
		
		if("+".equals(operator)) {
			temp_calc = pre_operand + suf_operand;
		} else if("-".equals(operator)) {
			temp_calc = pre_operand - suf_operand;
		} else if("*".equals(operator)) {
			temp_calc = pre_operand * suf_operand;
		} else if("/".equals(operator)) {
			temp_calc = pre_operand / suf_operand;
		}
				
		return temp_calc;
	}
	
	private List<Integer> checkMemo(int tier, Map<Integer, Integer> tierMap, List<Integer> tempList, int temp_calc) {
		if(!tierMap.containsKey(temp_calc)){
			tierMap.put(temp_calc, tier);
			tempList.add(temp_calc);
		}
		return tempList;
	}

}
