public class QuickSort {
    public void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi)
            return;

        int j = partition(a,lo,hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public int partition(Comparable[] a, int lo, int hi){
        Comparable k = a[lo];
        int i = lo + 1;
        int j = hi;
        while(true){
            while (a[i].compareTo(k) <= 0) {
                i++;
                if (i == hi)
                    break;
            }
            while (a[j].compareTo(k) >= 0) {
                j--;
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            Main.exch(a,i,j);
        }
        Main.exch(a,lo,j);
        return j;
    }
}
