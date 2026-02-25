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

}


