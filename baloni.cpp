#include <iostream>

using namespace std;

int main() {
	int n, val, arrows = 0;
	int heights[1000002] = { 0 };
        cin >> n;
	while (n--) {
                cin >> val;
		++heights[val];
		if (heights[++val])
			--heights[val];
		else
			++arrows;
	}
        cout << arrows << endl;
	return 0;
}
