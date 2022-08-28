import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//minHeap
		//Heap에 초기값 입력
        for(int i = 0; i < scoville.length; ++i) {
            minHeap.add(scoville[i]);
        }
		
        while(minHeap.size() > 1) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            answer++;
            minHeap.add(min1 + (min2 * 2));//스코빌 계산
            if(minHeap.peek() >= K) return answer;//최소값으로 확인
        }
        return -1;//answer를 return하지 않았다면, -1 return.
    }
}