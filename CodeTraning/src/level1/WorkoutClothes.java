package level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 *  체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *  
 *  전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 *  체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *  
 *  전체 학생의 수는 2명 이상 30명 이하입니다.
 *  체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 *  여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *  @author Justin
 *
 */
public class WorkoutClothes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkoutClothes wc = new WorkoutClothes();
		int n = 24;
		int[] lost = {12, 13, 16, 17, 19, 20, 21, 22};
		int[] reserve = {1,22, 16, 18, 9, 10};
		//int[] lost = {3,4};
		//int[] reserve = {4,5};
		
		System.out.println(wc.solution(n, lost, reserve));
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> lostList = new ArrayList<Integer>();
        List<Integer> reserveList = new ArrayList<Integer>();
        List<Integer> completeList = new ArrayList<Integer>();
        
        // 여벌 있는 사람 리스트
        for(int i = 0; i < reserve.length; i++){
        	reserveList.add(reserve[i]);
        }
        
        // 여벌 있지만 잃어버린 사람
        for(int i = 0; i < lost.length; i++){
        	int search_idx = reserveList.indexOf(lost[i]);
        	if(search_idx > -1){
        		reserveList.remove(search_idx);
        	} else {
        		lostList.add(lost[i]);
        	}
        }
        
        for(int i = 0; i < lostList.size(); i++){
        	int lost_num = lostList.get(i);
        	
        	for(int j=0; j < reserveList.size(); j++){
        		int prefix_reserve = reserveList.get(j) - 1;
        		int suffix_reserve = reserveList.get(j) + 1;
        		if(lost_num == prefix_reserve
            			|| lost_num == suffix_reserve
            			){
        			reserveList.remove(j);	
        			completeList.add(lost_num);
        			break;
        		}
        	}
        }
        answer = n - (lostList.size() - completeList.size());
        return answer;
    }
}
