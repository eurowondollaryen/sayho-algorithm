//https://programmers.co.kr/learn/courses/30/lessons/42842
function solution(brown, yellow) {
    var answer = [];
    answer.push((brown+4)/2 + (Math.sqrt(((brown+4)/2)*((brown+4)/2) -4*brown+yellow))/2);
    answer.push((brown+4)/2 - (Math.sqrt(((brown+4)/2)*((brown+4)/2) -4*brown+yellow))/2);
    return answer;
}