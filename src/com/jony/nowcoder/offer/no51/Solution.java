/**
 * 题目：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * <p>
 * 思路：
 * 解释下代码，设有数组大小为5。
 * 对于第一个for循环
 * 第一步：b[0] = 1;
 * 第二步：b[1] = b[0] * a[0] = a[0]
 * 第三步：b[2] = b[1] * a[1] = a[0] * a[1];
 * 第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
 * 第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
 * 然后对于第二个for循环
 * 第一步
 * temp *= a[4] = a[4];
 * b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
 * 第二步
 * temp *= a[3] = a[4] * a[3];
 * b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
 * 第三步
 * temp *= a[2] = a[4] * a[3] * a[2];
 * b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
 * 第四步
 * temp *= a[1] = a[4] * a[3] * a[2] * a[1];
 * b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
 */
package com.jony.nowcoder.offer.no51;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/10 22:30
 **/
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
