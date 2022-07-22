import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> monsterCount = new HashMap<Integer, Integer>();
        for(int monsterKind: nums) {
            if(monsterCount.get(monsterKind) != null) {
                monsterCount.put(monsterKind, monsterCount.get(monsterKind) + 1);
            } else {
                monsterCount.put(monsterKind, 1);
                answer++;
            }
        }
        answer = answer > (nums.length / 2) ? (nums.length / 2) : answer;
        return answer;
    }
}