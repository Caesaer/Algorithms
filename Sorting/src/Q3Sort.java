public class Q3Sort {
    public void sort(Comparable a[], int lo, int hi){
        if (hi <= lo)
            return;

        int lt = lo;
        int gt = hi;
        Comparable k = a[lo];

        int i = lo+1;

        while(i <= gt){
            if (a[i].compareTo(k) < 0)
                Main.exch(a, lt++, i++);
            else if (a[i].compareTo(k) > 0)
                Main.exch(a, gt--, i);
            else
                i++;
        }

        sort(a,lo,lt - 1);
        sort(a, gt + 1, hi);
    }
}
