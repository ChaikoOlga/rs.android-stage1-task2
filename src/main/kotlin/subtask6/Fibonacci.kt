package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {

        var f0 = 0
        var f1 = 1
        while (f0*f1<n){
            val num=f1
            f1=f1+f0
            f0=num
        }
       return if (f0*f1==n){
            intArrayOf(f0,f1,1)
        } else {
            intArrayOf(f0,f1,0)
        }
    }
}
