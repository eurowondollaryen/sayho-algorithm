import java.util.*;

class Solution {
    class Pair {
        int index;
        int priority;
        Pair() {
            index = 0;
            priority = 0;
        }
        Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
        public void print() {
            System.out.print("(" + this.index + ", " + priority + ")");
        }
    }
    public ArrayList<Pair> cutAndAttach(ArrayList<Pair> list, int startIndex, int endIndex) {
        ArrayList<Pair> temp = new ArrayList<Pair>();
        if(endIndex >= list.size()) endIndex = list.size()-1;
        if(startIndex < 0) startIndex = 0;
        for(int i = startIndex; i <= endIndex; ++i) {
            temp.add(list.get(i));
        }
        for(int i = 0; i < temp.size(); ++i) {
            list.add(temp.get(i));
            list.remove(0);
        }
        return list;
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList<Pair> printList = new ArrayList<Pair>();
        for(int i = 0; i < priorities.length; ++i) {
            Pair temp = new Pair(i, priorities[i]);
            printList.add(temp);
        }
        /*
        for(int i = 0; i < printList.size(); ++i) {
            if(i != 0) System.out.print(", ");
            printList.get(i).print();
        }
        System.out.println();
        printList = cutAndAttach(printList, 0, 2);
        for(int i = 0; i < printList.size(); ++i) {
            if(i != 0) System.out.print(", ");
            printList.get(i).print();
        }
        */
        
        int printCount = 0;
        while(printCount < priorities.length && printList.size() > 0) {
            int higherPriorityIndex = 0;
            boolean isHigherExists = false;
            
            for(int i = 1; i < printList.size(); ++i) {
                if(printList.get(0).priority < printList.get(i).priority) {
                    isHigherExists = true;
                    higherPriorityIndex = i;
                    break;
                }
            }
            //현재 차례의 뒤에 높은 우선순위가 있으면 잘라서 뒤로 붙이기
            if(isHigherExists) {
                printList = cutAndAttach(printList, 0, higherPriorityIndex-1);
            } else {//높은 우선순위가 없으면 졸업시키기
                printCount++;
                if(printList.get(0).index == location) {
                    answer = printCount;
                    break;
                }
                printList.remove(0);
            }
        }
        
        return answer;
    }
}