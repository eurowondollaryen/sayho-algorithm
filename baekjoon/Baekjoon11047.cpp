#include <iostream>
using namespace std;

//array test print function
void printArray(int* arr, int length) {
	for(int i = 0; i < length; ++i) {
		cout << "i : " << arr[i] << endl;
	}
}

//main function
int main() {
	int n, k, inp;
	int answer = 0;
	
	cin >> n >> k;
	int* arr = new int[n];
	for(int i = 0; i < n; ++i) {
		cin >> inp;
		arr[i] = inp;
	}
	//printArray(arr, n);
	
	
	//k보다 낮은, 큰 단위 동전부터 나눠가면서 answer에 동전 갯수 합산 
	for(int i = n-1; i >= 0; --i) {
		if(arr[i] <= k) {
			answer += (k / arr[i]);
			k = k % arr[i];
		}
	}
	
	//정답 출력 
	cout << answer;
	
	return 0;
}