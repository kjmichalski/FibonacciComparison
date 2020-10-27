public class FibonacciComparison {
    int[] nlist = {5, 10, 15, 20, 25, 30, 35, 40, 45};
    int[] fibarray1 = new int[nlist.length]; //stores fibonacci numbers from FibLinear
    int[] fibarray2 = new int[nlist.length]; //stores fibonacci numbers from FibExponential

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int i = fib(n - 1) + fib(n - 2);
        return i;

    }

    public static Pair<Integer, Integer> fibLinear(int n) {
        if (n == 1)
            return new Pair<Integer, Integer>(1, 0);
        Pair<Integer, Integer> prev = fibLinear(n - 1);
        return new Pair<>(prev.first() + prev.second(), prev.first());

    }

    public static double timeLinear(int x) {
        double timeLin;
        int numTrials = 10;
        long start = System.nanoTime();
        long end = System.nanoTime();
        timeLin = 1e-9 * (end - start) / numTrials;
        return timeLin;
    }

    public static double timeExp(int y) {
        double timeExp;
        int numTrials = 10;
        long start = System.nanoTime();
        for (int j = 0; j < numTrials; j++) {
            int e = fib(y);
        }
        long end = System.nanoTime();
        timeExp = 1e-9 * (end - start) / numTrials;
        return timeExp;
    }

    public static void main(String[] args) {
        int[] nlist = {5, 10, 15, 20, 25, 30, 35, 40, 45};
        int[] fibarray1 = new int[nlist.length]; //stores fibonacci numbers from FibLinear
        int[] fibarray2 = new int[nlist.length]; //stores fibonacci numbers from FibExponential
        double[] timingsEF = new double[nlist.length];
        double[] timingsLF = new double[nlist.length];
        int numTrials = 5;
        int fib1 = 0, fib2 = 0;

        for (int i = 0; i < nlist.length; i++) {
            int n = nlist[i];
            long start = System.nanoTime();
            for (int k = 0; k < numTrials; k++)
                fib1 = fib(n);
            long end = System.nanoTime();
            timingsEF[i] = 1e-9 * (end - start) / numTrials;
            fibarray1[i] = fib1;
        }
        for (int j = 0; j < nlist.length; j++) {
            int m = nlist[j];
            long start = System.nanoTime();
            for (int k = 0; k < numTrials; k++)
                fib2 = fibLinear(m).second();
            long end = System.nanoTime();
            timingsLF[j] =  1e-9 * (end - start) / numTrials;
            fibarray2[j] = fib2;
        }

        System.out.println("Timings for Exponential Fibonacci");
        for (double time : timingsEF)
            System.out.print("  " + time);
        System.out.println();
        for (int i = 0; i < fibarray1.length; i++) {
            System.out.print("  " + fibarray1[i]);
        }
            System.out.println();
            System.out.println();
            System.out.println("Timings for Linear Fibonacci");
            for (double time1 : timingsLF)
                System.out.print("  " + time1);
            System.out.println();
            for (int i = 0; i < fibarray2.length; i++) {
                System.out.print("  " + fibarray2[i]);
            }
        }

    }

