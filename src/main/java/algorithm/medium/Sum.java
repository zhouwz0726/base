package algorithm.medium;

public class Sum {

    public static void main(String[] args) {
        sumNums(9);
    }

    /**
     * 题目：求1+2+....+n，要求不能使用乘法，for循环，while，if，else，switch，case，三元运算符等关键字判断；
     * 输入：n=3；
     * 输出：6(1+2+3)；
     * 思路：利用递归调用自己，但是不能用if判断，故可以用&&，短路
     */
    private static int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
