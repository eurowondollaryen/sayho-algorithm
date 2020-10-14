## C++ 알고리즘 snippet
### **1. `vector` - 출력, 함수 사용법**
```C
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void print_vec(vector<int> v) {//vector 출력하기
	for(int i = 0; i < v.size(); ++i) {
		cout << v[i];
		if(i != v.size()-1) cout << " ";
	}
	cout << endl;
}

bool compare(int a, int b) {//stable_sort 용 비교 함수
	return a < b;//compare함수, 오름차순 정렬
}

int main(void)
{
	vector<int> test_vec;
	test_vec.clear();//erase all element
	test_vec.push_back(1);//push
	test_vec.pop_back();//pop
	test_vec.erase(test_vec.begin());//pop front할 때 사용. element 삭제
	stable_sort(test_vec.begin(), test_vec.end(), compare);//sort

	return 0;
}

```

### **2. `string` - split(`find(token, startposition)` 활용)**
```C
#include <iostream>
#include <vector>
#include <string>
using namespace std;
void print_vec(vector<string> v) {//vector 출력하기
	for(int i = 0; i < v.size(); ++i) {
		cout << v[i];
		if(i != v.size()-1) cout << " ";
	}
	cout << endl;
}
vector<string> split(string target, char token)//c++용 split(find 활용) 
{
	vector<string> result;
	int previous = 0;
	int current = 0;
	current = target.find(token);
	while(current != -1) {
		string substring = target.substr(previous, current-previous);
		result.push_back(substring);
		previous = current+1;
		current = target.find(token, previous);
	}
	result.push_back(target.substr(previous, current-previous));
	
	return result;
}
int main(void)
{
	string testStr = "hello,work,hard,go";
	vector<string> splitted = split(testStr, ',');
	
	cout << "size is " << splitted.size() << endl;
	print_vec(splitted);
	return 0;
}
```