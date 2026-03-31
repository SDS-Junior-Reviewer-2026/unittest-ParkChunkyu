package org.example;

import java.util.ArrayList;

public class OddEven {
    public ArrayList<String> getResult(ArrayList<Integer> nums) {
        if (nums.isEmpty() || isAllEvenOrOdd(nums)) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) result.add("O");
            else result.add("X");
        }
        return result;
    }
    private boolean isAllEvenOrOdd(ArrayList<Integer> nums) {
        int cntEven = 0;
        int cntOdd = 0;
        for (Integer num : nums) {
            if (num % 2 == 0) cntEven++;
            else cntOdd++;
        }
        return cntEven == nums.size() || cntOdd == nums.size();
    }
}
