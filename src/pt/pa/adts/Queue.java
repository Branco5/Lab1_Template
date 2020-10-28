package pt.pa.adts;

import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.FullQueueException;

/**
 * Lists methods of a queue
 * @param <T> Generic element of the queue
 */
public interface Queue<T>  {
/**
 * Inserts element at the end of the queue
 * @param element
 * @throws FullQueueException if queue is full
 */
public void enqueue(T element) throws FullQueueException;

/**
 * Removes element at the start of the queue and returns it
 * @return element removed
 * @throws EmptyQueueException if queue is empty
 */
public T dequeue() throws EmptyQueueException;

/**
 * Returns element at the start of the queue
 * @return element at the start of queue
 * @throws EmptyQueueException if queue is empty
 */
public T front() throws EmptyQueueException;

/**
 * Returns number of elements in queue
 * @return number of elements in queue
 */
public int size();

/**
 * Returns true if queue has no elements
 * @return true if queue has no elements
 */
public boolean isEmpty();

/**
 * Discards all elements in the queue
 */
public void clear();
        }