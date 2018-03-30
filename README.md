## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |    10,000,000      |    0.02253567   |
| Using ReentrantLock     |    10,000,000      |    0.67383633   |
| Synchronized method     |    10,000,000      |    0.51565933   |
| AtomicLong for total    |    10,000,000      |    0.25782000   |

## 1. Using unsynchronized counter object

1.1 The total should be zero but the total is not always the same. Sometimes the total is -72221.  
1.2 The average run time is 0.02253567 sec.   
1.3 first to forth result is zero but the fifth is -72221 because subtask may work faster than addtask. Thus, subtask is using the old value not the value that comes from addtask would affects the total.                               
## 2. Implications for Multi-threaded Applications
If user do several activities at the same time such as using ATM for deposit and using mobile banking gets the transfer money when override it could have overlapped and the transfer money will gone and balance has wrong value.
How might this affect real applications?  

## 3. Counter with ReentrantLock

3.1 the total always be zero. The average run time is 0.67383633 sec.       
3.2,3.3 it always be zero because ReentrantLock locks the total avoid subtask and addtask work overlapped. So,ReentrantLock will lock subtask when addtask is working that causes run time more than problem 1.    
3.4 we have unlock code in finally block, to make sure it run even if try block throws exception or not.

## 4. Counter with synchronized method
4.1 the total is always zero. The average run time is 0.51565933 sec.   
4.2 When the addtask is executing a synchronized method blocks another thread.  
4.3 Synchronized methods enable simple strategy for preventing thread interference and memory consistency error.

## 5. Counter with AtomicLong
5.1 Java provides AtomicLong which can be used without any synchronization. The average run time is 0.25782000 sec.  
5.2 you would use AtomicLong when you have to guarantee that the value can be used in concurrent environment and don't need the wrapper class.
Using AtomicLong because Long does not allow for thread interoperability.

## 6. Analysis of Results
6.1 The fastest counter is unsynchronized counter and The slowest counter is ReentrantLock.   
6.2 The best solution for this program is AtomicCounter because it will work completely by itself without any synchronization.


## 7. Using Many Threads (optional)

