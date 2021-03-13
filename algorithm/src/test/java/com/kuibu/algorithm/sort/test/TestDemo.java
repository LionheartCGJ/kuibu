package com.kuibu.algorithm.sort.test;

import common.util.CommonUtil;

/**
 * @Classname TestDemo
 * @Description TestDemo
 * @Date 2021/3/2 15:34
 * @Created by chenguangjin
 */
public class TestDemo {

    public static void main(String[] args) {
        int[] arr = CommonUtil.generateRandomIntArr(20, 100);

        CommonUtil.printIntArr(arr);

        heapSort(arr);

        CommonUtil.printIntArr(arr);

    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    public static void heapAdjust(int[] arr, int father, int length) {
        int fatherValue = arr[father];

        while (leftChild(father) < length) {
            int child = leftChild(father);

            if (child < length - 1 && arr[child] < arr[child + 1]) {
                child++;
            }

            if (fatherValue < arr[child]) {
                arr[father] = arr[child];
            } else {
                break;
            }
            father = child;
        }

        arr[father] = fatherValue;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }

    public static int leftChild(int father) {
        return father * 2 + 1;
    }
}
