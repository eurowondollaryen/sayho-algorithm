import java.util.*;
class Solution {
    public int[] arrayListToArray(ArrayList<Integer> input) {
        int[] result = new int[input.size()];
        
        for(int i = 0; i < input.size(); ++i) {
            result[i] = input.get(i);
        }
        return result;
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> processDays = new ArrayList<Integer>();
        
        //처리일수 계산
        for(int i = 0; i < progresses.length; ++i) {
            int processDay = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) processDay++;
            
            processDays.add(processDay);
        }
        
        //정답 계산
        ArrayList<Integer> answerArrayList = new ArrayList<Integer>();
        
        //앞의 처리시간이 뒤보다 크거나 같을 경우, 함께 배포한다.
        int j = 0;
        int cnt = 0;
        for(int i = 0; i < processDays.size(); ++i) {
            cnt = 1;
            for(j = i + 1; j < processDays.size(); ++j) {
                if(processDays.get(i) < processDays.get(j)) {
                    i = j - 1;
                    break;
                }
                cnt++;
            }
            answerArrayList.add(cnt);
            if(j == processDays.size()) break;
        }
        
        answer = arrayListToArray(answerArrayList);
        return answer;
        
    }
}