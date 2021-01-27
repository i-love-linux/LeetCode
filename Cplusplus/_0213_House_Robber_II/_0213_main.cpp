// Created by WXX on 2021/1/27 16:59
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int rob(vector<int> &nums) {

        int n = nums.size();
        if (!n) return 0;
        if (n == 1) return nums[0];

        vector<int> f(n + 1), g(n + 1);  // 从1开始，表示第1家店
        // 考虑不抢劫第一家店，则最后一家店可抢可不抢
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = max(f[i - 1], g[i - 1]);
        }
        int res = max(g[n], f[n]);
        // 考虑抢劫第一家店，则最后一家店不可以抢劫
        f[1] = nums[0];
        g[1] = INT_MIN;
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = max(f[i - 1], g[i - 1]);
        }
        return max(res, g[n]);
    }
};

int main() {

    vector<int> nums = {2, 3, 2};
    cout << Solution().rob(nums) << endl;  // 3

    return 0;
}