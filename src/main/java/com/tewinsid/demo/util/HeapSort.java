package com.tewinsid.demo.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HeapSort {
    private int[] heap;

    @Test
    public void main() {
        heap = new int[]{3, 23, 4, 1, 645, 234, 23, 13};
        this.sort();
        System.out.println(Arrays.toString(heap));
    }


    public void sort() {
        int len = heap.length - 1;
        //從第一個非葉子節點開始
        //此處 鍵號是爲了規避下標與序號差1
        int begainIndex = (len - 1) / 2;
        //從第一個葉子節點開始構建最大堆，並遞歸向上
        for (int i = begainIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }

        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    public void maxHeapify(int index, int len) {
        int li = index * 2 + 1;
        int ri = li + 1;
        int cMax = li;

        if (li > len) {
            return;
        }

        if (ri <= len && heap[li] < heap[ri]) {
            cMax = ri;
        }

        if (heap[cMax] > heap[index]) {
            swap(cMax, index);
            maxHeapify(cMax, len);
        }
    }

    private void swap(int j, int i) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
