import java.util.HashMap;
class Solution {
    무식한 방법 O(nlogn + n^2)
    HashMap 사용 O(20n)
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMapString, Integer phoneBook = new HashMapString, Integer();
        for(String phoneNumber phone_book) {
            
            for(int i = 0; i  phoneNumber.length(); ++i) {
                String subStr = phoneNumber.substring(0,i);
                if(phoneBook.get(subStr) == null) {
                    phoneBook.put(subStr, phoneNumber.length());
                } else {
                    if(phoneNumber.length()  phoneBook.get(subStr)) {
                        phoneBook.put(subStr, phoneNumber.length());
                    }
                }
            }
        }
        for(String phoneNumber phone_book) {
            if(phoneBook.get(phoneNumber) != null && phoneBook.get(phoneNumber)  phoneNumber.length()) return false;
        }
        return answer;
    }
}