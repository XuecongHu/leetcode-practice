package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 胡学聪 on 2017/2/23.
 */
public class _525ContiguousArray {

    /**
     * 把0换作-1，当一个数组所有的0和1数量相等时，这个数组累加的和为0
     * 假设当数组[x1,x2,...,xi,xi+1,....,xj,...]从x1累加到xi的结果是sumi，假设子数组[xi+1,...,xj]0和1数量相等，
     * 则xi+1至xj的累加和为0，所以x1累加到xj的和sumj等于sumi
     * 利用这个特性，在遍历数组的时候维护一个从累加sum到索引index的hashtable，
     * 当目前的元素的累加sumi在hashtable中有相同的key k时，说明从xk+1到xi这段子数组0和1数量相等，对应的数组长度就是xi-xk
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)
                sum += -1;
            else
                sum += 1;
            if(sum == 0){
                if(i + 1 > maxLength)
                    maxLength = i + 1;
            }else {
                if (map.containsKey(sum)) {
                    int preIndex = map.get(sum);
                    if (i - preIndex > maxLength)
                        maxLength = i - preIndex;
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxLength;
    }
}
