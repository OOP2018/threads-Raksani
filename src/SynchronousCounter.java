public class SynchronousCounter extends Counter {
    protected int amount = 0;
    @Override
    public synchronized void add(int amount) {
        super.add(amount);
    } }