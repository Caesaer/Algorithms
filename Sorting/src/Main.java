public class Main {
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a){
        for(Comparable item : a)
            System.out.print(item + " ");

        System.out.println("\n");
    }

    public static boolean less(Comparable[] a, int i, int j){
        if(a[i].compareTo(a[j]) < 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Integer[] arr = {3,5,3,2,434,5,5,5,5,5,1233,22};
        new QuickSort().sort(arr,0,arr.length - 1);
        show(arr);

        new Q3Sort().sort(arr,0, arr.length - 1);
        show(arr);
    }
}
