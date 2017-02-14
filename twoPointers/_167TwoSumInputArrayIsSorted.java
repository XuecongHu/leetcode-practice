package twoPointers;

/**
 * Created by 胡学聪 on 2017/2/14.
 */
public class _167TwoSumInputArrayIsSorted {

    /**
     * 思路：
     * 数组维护两个指针p1、p2，p1指向第一个元素, p2指向最后一个元素
     * 假设这两个就是最后要找到的元素，不断调整p1和p2的位置，逼近目标值
     * 按照下面的步骤循环直到p1和p2指向相同的元素：
     * p1和p2指向的元素相加，分三种情况：
     * （1）若相加之和与目标相等，即要找的元素；
     * （2）若相加之和大于目标值，表示两个元素的值过大，由于数组是升序的，所以p2向前移动；
     * （3）若相加之和小于目标值，表示两个元素的值过小，p1向后移动；
     *
     * @param numbers
     * @param target
     * @return 相加之和等于target的两个元素值各自的索引（1 based)
     */
    public int[] twoNum(int[] numbers, int target){
        int start = 0, end = numbers.length - 1;

        int index1 = -1, index2 = -1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                index1 = start + 1;
                index2 = end + 1;
                break;
            }else if(sum < target){
                start++;
            }else
                end--;
        }

        return new int[]{index1, index2};
    }
}
