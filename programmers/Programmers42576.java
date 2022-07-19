import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionCount = new HashMap<String, Integer>();
        
        for(String name: completion) {
            if(completionCount.get(name) != null) {
                completionCount.put(name, completionCount.get(name) + 1);
            } else {
                completionCount.put(name, 1);
            }
        }
        for(String name: participant) {
            if(completionCount.get(name) != null && completionCount.get(name) != 0) {
                completionCount.put(name, completionCount.get(name) - 1);
            } else {
                answer = name;
                break;
            }
        }
        return answer;
    }
}