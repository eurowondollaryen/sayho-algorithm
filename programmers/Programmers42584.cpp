#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for(int i = 0; i < prices.size(); ++i) {
        int score = 0;
        for(int j = i+1; j < prices.size(); ++j) {
            score++;
            if(prices[i] <= prices[j]) ;
            else break;
        }
        answer.push_back(score);
    }
    return answer;
}