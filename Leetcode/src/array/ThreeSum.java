package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums.length < 3)
            return result;
        
        
        //sort the array - 0(nlogn)
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++) {
            
            if(i == 0 || nums[i] > nums[i-1]) {
                int targetSum = -nums[i];
                int start = i+1;
                int end = nums.length-1;

                while(start < end) {

                    if(nums[start] + nums[end] < targetSum) {
                        start++;
                    } else if(nums[start] + nums[end] > targetSum) {
                        end--;
                    } else {
                        List<Integer> numList = new ArrayList<Integer>();

                        numList.add(nums[i]);
                        numList.add(nums[start]);
                        numList.add(nums[end]);             

                        result.add(numList);

                        start++;
                        end--;

                        //handle duplicate here
                        while(start<end && nums[start]==nums[start-1])
                            start++;
                        while(start<end && nums[end]==nums[end+1])
                            end--;
                    }

                }
            }            
        }
        
        return result;
    }

	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		List result = sum.threeSum(new int [] {-1,0,1,2,-1,-4});
		
		result.stream().forEach(System.out::println);
	}

}
