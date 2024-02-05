#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <queue>

using namespace std;

int main() {
	int num, n;
	queue<int> q;

	cin >> num >> n;
	cout << "<";
	for (int i = 1; i <= num; i++) {
		q.push(i);
	}
	while (!q.empty()) {
		for (int j = 0; j < n- 1; j++) {
			q.push(q.front());
			q.pop();
		}
		cout << q.front();
		q.pop();
		if (!q.empty())
			cout << ", ";
	}
	cout << ">";
	return 0;
}