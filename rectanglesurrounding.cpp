#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool grid[500][500];

int fill(int x1, int y1, int x2, int y2, bool fill) {
    int filled = 0;
    for(int x = x1; x < x2; x++) {
        for(int y = y1; y < y2; y++) {
            if(grid[x][y] != fill){
                grid[x][y] = fill;
                filled++; 
            }
        }
    }
    return filled;
}

int main() {
    int n, x1, y1, x2, y2, filled; 
    while(true){
        cin >> n;
        if (n == 0) break;

        filled = 0;
        fill(0, 0, 500, 500, false);

        for(int i = 0; i < n; i++){
            cin >> x1 >> y1 >> x2 >> y2;
            filled += fill(x1, y1, x2, y2, true);
        }
        cout << filled << endl;
    }
    return 0;
}
