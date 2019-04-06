package jpa.domain;

/**
 * Created by Robert Burek
 */
public class KolejnaKata {

    public static void main(String[] args) {
        int[] teraz = foldArray(new int[]{1, 2, 3, 4, 5}, 2);
        for (int i = 0; i < teraz.length; ++i) {
            System.out.print(teraz[i] + "  ");
        }
    }

    public static int[] foldArray(int[] array, int runs) {
        int[] start = array;
        int[] nowa = array;
        for (int z = 0; z < runs; ++z) {
            int dlNowa = 0;
            if (start.length % 2 == 0) dlNowa = start.length / 2;
            if (start.length % 2 == 1) dlNowa = (start.length / 2) + 1;
            nowa = new int[dlNowa];
            for (int i = 0; i < dlNowa; ++i)
                nowa[i] = start[i];
            System.out.println(start.length / 2);
            for (int i = 0; i < (start.length / 2); ++i) {
                nowa[i] = start[i] + start[start.length - 1 - i];
            }
            start = nowa;
        }
        return nowa;
    }
}

