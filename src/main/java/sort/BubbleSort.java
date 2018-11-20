package sort;

/**
 * 冒泡排序：
 * 1:比较相邻的二个元素，如前一个元素比后一个大，则交互位置;
 * 2:对每一组相邻的元素都做同样的操作，从一组开始知道最后一组，这样做完一次后，最后一个元素肯定是最大的;
 * 3:针对所有的元素重复以上步骤，除了最后一个;
 * 4:每次对越来越少的元素重复以上的步骤，直到没有一对元素需要交互位置
 * @author zhouwz
 * */
public class BubbleSort {

    public static void main(String[] args) {
        int a[] = {11,6,8,1,8,3,7};
        bubbleSort(a);
        //输出循环
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void bubbleSort(int[] a) {
        int temp ;
        for (int i = 0; i < a.length-1; i++) {//外层循环控制排序趟数
            for (int j = 0; j <a.length-1-i ; j++) {// 依次比较相邻的两个元素,使较大的那个向后移
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j] = temp;
                }
            }
        }
    }

}
