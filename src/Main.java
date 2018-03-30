public class Main{
    Runnable addtask = new Runnable() {
        public void run() {
            //for(int k=1; k<=limit; k++) counter.add( k );
            System.out.println("Done "+Thread.currentThread().getName());
        }
    };
}
