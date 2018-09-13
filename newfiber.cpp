#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<pair <int, int>> cons(n); // connections -> node ID

    // Read input data and sort by number of connections
    for (int i = 0; i < n; i++) cons[i].second = i;
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        cons[x].first++; cons[y].first++;
    }
    sort(cons.begin(), cons.end());

    int changes = 0, totalCons = m*2, consToMake = 2*n-2;
    // Go through and remove connections from the largest until we reach the
    // final number of connections for the system
    for (int i = cons.size()-1; totalCons > consToMake; i--) {
        int amt = min(totalCons - consToMake, cons[i].first-1);
        totalCons -= amt;
        cons[i].first -= amt;
        changes++;
    }
    sort(cons.begin(), cons.end());

    cout << changes << endl;
    cout << n << ' ' << n-1 << endl;
    if (n == 2) { // Ensure that a connection is printed for N=2
        cout << "0 1" << endl; return 0;
    }

    vector<int> nodesToConnect;
    int i;
    // Pull off all nodes that only have one connection to make
    for (i = 0; cons[i].first == 1; i++)
        nodesToConnect.push_back(cons[i].second);

    // For all remaining nodes that have more than one connection to make
    for (; i < cons.size(); i++) {
        // Keep connecting from nodes to connect until this node is down to 1 remaining connection
        // unless this is the last node
        for(int j = 0; j < cons[i].first-(i+1 < cons.size()); j++){
            cout << cons[i].second << ' ' << nodesToConnect.back() << endl;
            nodesToConnect.pop_back();
        }
        nodesToConnect.push_back(cons[i].second); // Push this node back to do its last connection
    }

    return 0;
}
