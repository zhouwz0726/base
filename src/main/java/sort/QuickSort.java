package sort;

/**
 * 快速排序
 * 1:从序列中挑选一个元素，当做"基准"
 * 2:把所有比基准小的元素放在基准的前面，所以比基准小的元素放在基准后面，可以成为分区操作
 * 3:对每个分区进行递归操作，重复步骤1和步骤2，递归结束的条件是序列的大小是0或者1；
 * @author zhouwz
 * */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {5,2,8,1,9,6,10};
        quickSort(arr,0,arr.length-1);
        for (int a:arr) {
            System.out.println(a);
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int pivotIndex = partiton(arr,left,right);//基准的索引
        quickSort(arr,left,pivotIndex-1);
        quickSort(arr,pivotIndex+1,right);
    }

    private static int partiton(int[] arr, int left, int right) {
        int pivot = arr[right];//基准，这里选择最后一个元素为基准
        int tail = left -1;//tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i <right ; i++) {//遍历基准以外元素
            if(arr[i] <= pivot){//吧小于等于基准的元素放到前一个字子数组末尾
                swap(arr,++tail,i);
            }
        }
        swap(arr,tail+1,right);//最后把基准放到前一个子数组的后边，剩下的子数组是大于基准的子数组，该操作很有可能把后面元素的稳定性打乱，索引快速排序是不稳定的
        return tail+1;//返回基准的索引
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
