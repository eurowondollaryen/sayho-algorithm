import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                stack.push("(");
            }
            if(s.charAt(i) == ')') {
                if(stack.size() == 0) return false;
                stack.pop();
            }
        }
        if(stack.size() > 0) return false;
        return answer;
    }
}