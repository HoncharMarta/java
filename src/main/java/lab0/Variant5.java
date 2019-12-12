  package lab0;

  import java.util.Objects;

  public class Variant5 {


    public static class TwoNumbers {
        private int s;
        private int v;

        public TwoNumbers(int s, int v) {
            this.s = s;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TwoNumbers that = (TwoNumbers) o;
            return s == that.s &&
                    v == that.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, v);
        }
    }


    /**
     * @param a is cube side
     * @return square and volume
     */
    public TwoNumbers inputOutputTask(int a) {
        return new TwoNumbers(6 * a * a, a * a * a);
    }

    /**
     * @param a is distance in cm
     * @param b is distance in cm
     * @return ostacha
     */

    public int integerNumbersTask(int a,int b) {
        return a % b;
    }

    /**
     * @param a
     * @param b
     * @return true, if a and 0 or b<-2
     */
    public boolean booleanTask(int a,int b) {
        return (a == 0) || (b < -2);
    }


    /**
     * @param a is integer number
     * @param b is integer number
     * @param c is integer number
     * @return number of positive and negative numbers
     */
    public TwoNumbers ifTask(int a,int b,int c) {
        int count = 0;

        if (a > 0)
            count++;
        if (b > 0)
            count++;
        if (c > 0)
            count++;

        return new TwoNumbers(count, 3 - count);
    }


    /**
     * @param a
     * @param b
     * @param n
     * @return arithmetic 
     */
    public int switchTask(int a, int b, int n) {
        assert b > 0 : "Argument should be more than zero";
        int result = 0;
        switch (n) {
            case 1:
                result = a + b;
                break;
            case 2:
                result = a - b;
                break;
            case 3:
                result = a * b;
                break;
            case 4:
                result = a / b;
                break;
            default:
                assert n >= 1 && n <= 4: "n should be from 1 to 4";
        }
        return result;
    }


    /**
     * @param n is price for 1 kg
     * @return price for 0.1,0.2,...,1kg
     */
    public double[] forTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        double[] result = new double[10];
        int j = 0;

        for (double i = 0.1; i < 10; i += 0.1){
            result[j++] = n * i;
        }

        return result ;
    }


    public int whileTask(int n) {
        assert (n > 0) : "Argument should be more than zero";
        int k = 0;
        while (n >= 2){
            k++;
            n /= 2;
        }
        return k;
    }

    public int[] arrayTask(int k) {
        assert (k > 2) : "Argument should be more than two";
        int[] array = new int[k];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < k; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array;
    }

    /**
     * @param array
     * @param m
     * @param n
     * @param d
     * @return transformed array where next row is previous rov + d
     */
    public int[][] twoDimensionArrayTask(int[] array, int m, int n, int d) {
        int[][] result = new int[m][n];
        for ( int i = 0; i < m; i++)
            result[i][0] = array[i];

        for ( int i = 0; i < m; i++){
            for ( int j = 1; j < n; j++) {
                result[i][j] = result[i][j-1] + d;

            }
        }

        return result;
    }
}
