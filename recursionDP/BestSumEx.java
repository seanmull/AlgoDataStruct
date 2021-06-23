package recursionDP;

import java.util.ArrayList;
import java.util.*;

public class BestSumEx {
    HashMap<Integer, ArrayList<Integer>> hp;
    BestSumEx () {
       hp = new HashMap<Integer, ArrayList<Integer>>();
    }
    public ArrayList<Integer> sum (int target, int nums[]) {
        if(hp.containsKey(target)) {
            return hp.get(target);
        }
        if(target == 0) {
            return new ArrayList<Integer>();
        }
        if(target < 0) {
            return null;
        }
        ArrayList<Integer> shortestCombination = null;

        for(int i  = 0; i < nums.length; i++) {
            int rest = target-nums[i];
            ArrayList<Integer> currentCombination = sum(rest, nums);
            if(currentCombination != null) {
                ArrayList<Integer> combination = new ArrayList<Integer>();
                combination = (ArrayList)currentCombination.clone();
                combination.add(nums[i]);
                if(shortestCombination == null || combination.size() < shortestCombination.size()){
                    shortestCombination = new ArrayList<Integer>();
                    shortestCombination = (ArrayList)combination.clone();
                }
            }
        }
       
        hp.put(target, shortestCombination);
        return shortestCombination;
    }
    public static void main(String[] args) {
        int target = 400;
        int nums[] = {1,2,4};
        BestSumEx bs = new BestSumEx();
        
        System.out.println(bs.sum(target, nums).toString()); //[4,4]
    }
}