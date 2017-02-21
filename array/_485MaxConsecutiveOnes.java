package array;

/**
 * Created by 胡学聪 on 2017/2/21.
 */
public class _485MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0, consecutiveOnes = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(consecutiveOnes > maxConsecutiveOnes)
                    maxConsecutiveOnes = consecutiveOnes;
                consecutiveOnes = 0;
            } else
                consecutiveOnes++;
        }

        if(consecutiveOnes > maxConsecutiveOnes)
            maxConsecutiveOnes = consecutiveOnes;

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        _485MaxConsecutiveOnes test = new _485MaxConsecutiveOnes();
        int[] arr = {1,1,0,1,1,1};
        System.out.println(test.findMaxConsecutiveOnes(arr));
    }
}
