/*
Alternative solution:  Use HashMap to store intermediate result.  time: N2,  space: N
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> rsl = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4) {
            return rsl;
        }
        Arrays.sort(num);
        for (int j = 0; j < num.length - 3; j++) {
            if (j != 0 && num[j] == num[j - 1]) {
                continue;
            }
            for (int i = j + 1; i < num.length - 2; i++) {
                if (i != j + 1 && num[i] == num[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = num.length - 1;
                while (l < r) {
                    int sum = num[j] + num[i] + num[l] + num[r];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[j]);
                        temp.add(num[i]);
                        temp.add(num[l]);
                        temp.add(num[r]);
                        rsl.add(temp);
                        l++;
                        while (l < r && num[l] == num[l - 1]) {
                            l++;
                        }
                        r--;
                        while (l < r && num[r] == num[r + 1]) {
                            r--;
                        }
                    }
                    else if (sum < target) {
                        l++;
                        while (l < r && num[l] == num[l - 1]) {
                            l++;
                        }
                    } else if (sum > target) {
                        r--;
                        while (l < r && num[r] == num[r + 1]) {
                            r--;
                        }
                    }
                }  //end of 2-sum while
                
                
            }
        }
        return rsl;
        
    }
}