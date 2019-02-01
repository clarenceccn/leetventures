public class ArrayEasyProblems {

  /********************** [Array Problem, Rotate Array] ************************/
  // 0. Make sure k is within array length-wrap around
  // 1. Reverse whole array
  // 2. Reverse first 0 to k elems
  // 3. Reverse from k+1 elems to end of array
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverseInPlace(nums, 0, nums.length - 1);
    reverseInPlace(nums, 0, k - 1);
    reverseInPlace(nums, k, nums.length - 1);
  }

  private void reverseInPlace(int[] arr, int start, int end) {
    int curr = start;
    while (curr < end) {
      int tmp = arr[curr];
      arr[curr++] = arr[end];
      arr[end--] = tmp;
    }
  }

  /*****************************************************************************/

  /*********** [Array Problem, Remove Duplicates from Sorted Array] *************/
  // 0. Check if list is size < 1 : Return 0 eol pointer = 1
  // 1. Start off with EOL pointer being 1 (This assumes first item in list)
  // 2. Iterate through array from 1 - END
  // 2. a. Check if current pointer is different from current - 1 pointer
  // 2. b. If different, add the value of current pointer to list and increment
  // end of list pointer
  // Visual : Imagine a virtual list starting off with 1 element, and iterating
  // through array and adding unseen elements to it and increment its size
  public int removeDuplicates(int[] nums) {
    if (nums.length < 1) {
      return 0;
    }

    int eol = 1;
    for (int curr = 1; curr < nums.length; curr++) {
      if (nums[curr - 1] != nums[curr]) {
        nums[eol++] = nums[curr];
      }
    }
    return eol;
  }

  /*****************************************************************************/

  /*********** [Array Problem, Best Time to Buy and Sell Stock II] *************/
  /**
   * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell
   * on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1,
   * buy on day 2 and sell them later, as you are engaging multiple transactions
   * at the same time. You must sell before buying again.
   */
  public int maxProfit(int[] prices) {
    int profit = 0;
    for (int curr = 1; curr < prices.length; curr++) {
      if (prices[curr - 1] < prices[curr]) {
        profit += prices[curr] - prices[curr - 1];
      }
    }
    return profit;
  }

  /*****************************************************************************/

  /*************** [Array Problem, Contains Duplicate Unsorted] ****************/
  /**
   * Given an array of integers, find if the array contains any duplicates.
   * 
   * Your function should return true if any value appears at least twice in the
   * array, and it should return false if every element is distinct.
   */
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

  /*****************************************************************************/

  /********************* [Array Problem, Single Number] ************************/
  /**
   * Given a non-empty array of integers, every element appears twice except for
   * one. Find that single one.
   */
  // Solution : XOR every element in the list
  public int singleNumber(int[] nums) {
    int answer = nums[0];
    for (int i = 1; i < nums.length; i++) {
      answer ^= nums[i];
    }
    return answer;
  }

  /*****************************************************************************/

  /*********************** [Array Problem, Two Sum] *****************************/
  /**
   * Given an array of integers, return indices of the two numbers such that they
   * add up to a specific target.
   * 
   * You may assume that each input would have exactly one solution, and you may
   * not use the same element twice.
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int requiredAmount = target - nums[i];
      if (map.containsKey(requiredAmount)) {
        return new int[] { map.get(requiredAmount), i };
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }

  /*****************************************************************************/

}
