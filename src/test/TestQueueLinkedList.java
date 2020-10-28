package test;

import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.FullQueueException;
import pt.pa.adts.QueueLinkedList;
import org.junit.*;

public class TestQueueLinkedList {
    QueueLinkedList<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueLinkedList<>();
        for (int i = 1; i < 6; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void front() throws FullQueueException {
        Assert.assertEquals(1, (int) queue.front());
    }

    @Test
    public void size() throws FullQueueException {
        Assert.assertEquals(5, (int) queue.size());
    }

    @Test
    public void dequeue() throws FullQueueException {
        Assert.assertEquals(1, (int) queue.dequeue());
        Assert.assertEquals(2, (int) queue.front());
    }

    @Test(expected = EmptyQueueException.class)
    public void emptyQueueExceptionDequeue() {
        queue.clear();
        queue.dequeue();
    }

    @Test(expected = EmptyQueueException.class)
    public void emptyQueueExceptionFront() {
        queue.clear();
        queue.front();
    }
}

    //assertThrows(EmptyQueueException.class ->queue.dequeue())

