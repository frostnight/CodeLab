package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
participant	completion	return
[leo, kiki, eden]	[eden, kiki]	leo
[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
입출력 예 설명
예제 #1
leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 * @author Justin
 *
 */
public class IncompletePlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};*/
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		/*String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};*/
		long start_time = System.currentTimeMillis();
		System.out.println(solution(participant, completion));
		long end_time = System.currentTimeMillis();
		System.out.println("실행시간 >>"+ (end_time - start_time) + "ms");
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> completionMap = new HashMap<>();
		Map<String, Integer> participantMap = new HashMap<>();
		Iterator<String> it = null;
		// 완주자 맵 완성
		for(String completion_str : completion){
			if(completionMap.containsKey(completion_str)){
				int cnt = completionMap.get(completion_str);
				completionMap.put(completion_str, cnt+1);
			} else {
				completionMap.put(completion_str, 1);
			}
		}

		// 완주자 비교
		boolean completionMapCheck = false;
		for(String participant_str : participant){
			if(completionMap.containsKey(participant_str)){
				if(participantMap.containsKey(participant_str)){
					int cnt = participantMap.get(participant_str);
					participantMap.put(participant_str, cnt+1);
				} else {
					participantMap.put(participant_str, 1);
				}
			} else {
				completionMapCheck = true;
				answer = participant_str;
				break;
			}
		}
		
		if(!completionMapCheck){
			it = completionMap.keySet().iterator();
			while(it.hasNext()){
				String it_str = it.next();
				int comp_duplicate_cnt = completionMap.get(it_str);
				int part_duplicate_cnt = participantMap.get(it_str);
				if(part_duplicate_cnt != comp_duplicate_cnt) {
					answer = it_str;
					break;
				}
			}
		}
       
        return answer;
    }

}
