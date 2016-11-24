package com.yuyu.coursera.algorithms.unionFind;

/**
 * Created by chenyuyu on 2016/11/22.
 */
public class BinarySearch {
    public static int binarySearch (int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            }
            else if (key > a[mid]) {
                lo = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

}
