import java.util.*;
public  class tset {

    public static int returnSubsequenceCount(int[] X, int S)
    {

    }
    public static void main(String[] args) {
      int [] X = {2,1,3};
      int S = 6;
        HashMap<Integer, Integer> prefixes = new HashMap<Integer, Integer>();
        int result = 0;
        int[] P = new int[X.length + 1];
        prefixes.put(0, 1);

        int[] Q = new int[X.length + 1];
        P[0] = 0;
        Q[0] = 0;

        for (int i = 1; i < X.length + 1; i++)
        {
            P[i] = P[i - 1] + X[i - 1];
            Q[i] = P[i] - S * i;

            if (!prefixes.containsKey(Q[i]))
            {
                prefixes.put(Q[i], 1);
            }
            else
            {
                Integer temp=prefixes.get(Q[i]);
                temp++;
                prefixes.put(Q[i],temp);

            }

        }

        for (Map.Entry<Integer, Integer> entry : prefixes.entrySet())
        {
            int value = entry.getValue();
            result += value * (value - 1) / 2;
        }

        System.out.println(result);
    }
}