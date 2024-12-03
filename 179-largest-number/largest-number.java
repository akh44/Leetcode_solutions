class Solution {
    public String largestNumber(int[] nums) {
         String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        
        // Step 2: Custom comparator to sort numbers based on concatenated values
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });
        
        // Step 3: Handle the edge case where all numbers are zero
        if (numsStr[0].equals("0")) {
            return "0";
        }
        
        // Step 4: Build the largest number by concatenating the sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String num : numsStr) {
            largestNumber.append(num);
        }
        
        return largestNumber.toString();
    }
}