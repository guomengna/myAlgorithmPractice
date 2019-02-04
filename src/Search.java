/**
 * 查找算法
 */
public class Search {
    /**
     * 二分查找法，非递归
     * @param array 需要搜索的目标数组
     * @param size 目标数组的大小
     * @param target 需要在数组中搜索的元素值
     * @return
     */
    public int binarySearch(int[] array, int size, int target){
        int left = 0;
        int right = size-1;//搜索范围是从[left,right]的闭区间
        while(left <= right){//当left与right重合的时候依然是有效的搜索区间
//            int mid = (left + right)/2;//当left 和 right足够大的时候，有可能使用假发会造成溢出
            int mid = left + (right - left)/2;
            if(target == array[mid]){
                return mid;//直接返回此时的索引值
            }else if(target > array[mid]){//target的值大于中心值，此时，搜索范围变为[mid+1,right]
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
