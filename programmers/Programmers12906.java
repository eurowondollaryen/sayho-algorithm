import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> distinctList = new ArrayList<Integer>();
        
        distinctList.add(arr[0]);
        for(int i = 1; i < arr.length; ++i) {
            if(distinctList.get(distinctList.size()-1) != arr[i]) {
                distinctList.add(arr[i]);
            }
        }
        int[] answer = new int[distinctList.size()];
        for(int i = 0; i < distinctList.size(); ++i) {
            answer[i] = distinctList.get(i);
        }

        return answer;
    }
}