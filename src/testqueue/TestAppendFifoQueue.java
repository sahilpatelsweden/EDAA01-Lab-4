package testqueue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
    
    // Append two empty queues, both remain empty
    @Test
    void testAppendTwoEmptyQueues() {
        FifoQueue<Integer> q1 = new FifoQueue<>();
        FifoQueue<Integer> q2 = new FifoQueue<>();

        q1.append(q2);

        assertEquals(0, q1.size());
        assertEquals(0, q2.size());
    }

    // Append non-empty to empty, elements move and source becomes empty
    @Test
    void testAppendEmptyToNonEmpty() {
        FifoQueue<Integer> q1 = new FifoQueue<>();
        FifoQueue<Integer> q2 = new FifoQueue<>();

        q2.offer(1);
        q2.offer(2);

        q1.append(q2);

        assertEquals(2, q1.size());
        assertEquals(0, q2.size());
        assertEquals(1, q1.poll());
        assertEquals(2, q1.poll());
    }

    // Append empty to non-empty, original queue remains unchanged
    @Test
    void testAppendNonEmptyToEmptySource() {
        FifoQueue<Integer> q1 = new FifoQueue<>();
        FifoQueue<Integer> q2 = new FifoQueue<>();

        q1.offer(1);
        q1.offer(2);

        q1.append(q2);

        assertEquals(2, q1.size());
        assertEquals(0, q2.size());
        assertEquals(1, q1.poll());
        assertEquals(2, q1.poll());
    }

    // Append two non-empty queues, elements concatenate in order
    @Test
    void testAppendTwoNonEmptyQueues() {
        FifoQueue<Integer> q1 = new FifoQueue<>();
        FifoQueue<Integer> q2 = new FifoQueue<>();

        q1.offer(1);
        q1.offer(2);

        q2.offer(3);
        q2.offer(4);

        q1.append(q2);

        assertEquals(4, q1.size());
        assertEquals(0, q2.size());

        assertEquals(1, q1.poll());
        assertEquals(2, q1.poll());
        assertEquals(3, q1.poll());
        assertEquals(4, q1.poll());

    }

    // Append queue to itself, should throw exception
    @Test
    void testAppendSelfThrowsException() {
        FifoQueue<Integer> q1 = new FifoQueue<>();

        q1.offer(1);
        q1.offer(2);

        assertThrows(IllegalArgumentException.class, () -> q1.append(q1));
    

    }
}
