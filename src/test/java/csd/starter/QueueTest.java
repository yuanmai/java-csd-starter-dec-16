package csd.starter;

import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by jay on 12/14/16.
 */
public class QueueTest {

    private Queue queue = new LinkedList();

    @Test(expected = NoSuchElementException.class)
    public void exception_should_throw_after_retrieve_head(){

        queue.remove();

    }

    @Test
    public void queue_should_null_after_poll(){

        assertEquals(null, queue.poll());

    }

}
