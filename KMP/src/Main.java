public class Main {

    public int[] cal_next(String pattern){     //a b a b a b z a b a b a b a
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int j = -1;
        int i = 0;

        while(i < pattern.length() - 1){
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }
            else
                j = next[j];
        }
        return next;
    }

    public static void main(String[] args){
        String T = "abbaabbaaba";
        String p = "abbaaba";
        int[] next = new Main().cal_next(p);

        int i = 0;
        int j = 0;

        while(i < T.length() && j < p.length()){
            if (j == -1 || T.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
        }

        if (j == p.length())
            System.out.println(i-j);
        else
            System.out.println("wrong!");
    }
}
