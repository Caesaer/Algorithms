public class HeapSort {
    public void Sort(Integer[] arr){
        MaxPQ maxPQ = new MaxPQ<>(arr);
        int k = arr.length;
        for (int i = k/2; i > 0; i --)
            maxPQ.sink(i,k);

        while (k > 1){
            maxPQ.exch(1,k--);
            maxPQ.sink(1,k);
        }
        maxPQ.show();
    }
}

//堆排序需要注意在最大顶构建完毕后每一次sink操作需要实时更新堆的大小，将已经输出的最大顶剔除到顶外。