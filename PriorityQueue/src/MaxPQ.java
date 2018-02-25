import java.awt.desktop.SystemEventListener;
import java.util.Arrays;

public class MaxPQ <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity){
        pq = (Key[])new Comparable[capacity+1];
    }

    public MaxPQ(Key[] content){
        pq = (Key[])new Comparable[content.length + 1];
        System.arraycopy(content,0,pq,1,content.length);
        N = content.length;
    }

    public void show(){
        System.out.print("排序结果:");
        for (Key key : pq)
            if (key != null)
                System.out.print(key+ " ");

        System.out.println("\n");
    }

    public void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean less(int i, int j){
        if (pq[i].compareTo(pq[j]) >= 0)
            return false;
        else
            return true;
    }

    public void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    public void sink(int k, int n){
        while(2*k <= n){
            int j = 2*k;
            if (j < n && less(j,j+1))
                j ++;
            if (!less(k,j))
                break;
            exch(k,j);
            k = j;
        }
    }

    public void resize(int max){
        Key[] temp =(Key[]) new Comparable[max];
        for (int i = 0;i <= N; i++)
            temp[i] = pq[i];

        pq = temp;
    }

    public void ensureCapacity(int i){
        if (i == N)
            resize(2*i);
        else if (N > 0 && N == pq.length/4)
            resize(pq.length/2);
    }

    public void add(Key item){
        ensureCapacity(N+1);
        pq[++N] = item;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        // pq[N+1] = null;
        sink(1,N);

        return max;
    }
}
