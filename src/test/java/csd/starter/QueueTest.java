package csd.starter;

import org.junit.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by shushuxu on 2016/12/14.
 */
public class QueueTest {
    //fifo
    Queue queue = new LinkedList();

    @Before
    public void before(){
        System.out.println("before each test");
    }

    @After
    public void after(){
        System.out.println("after each test");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

    @Test
    public void size_of_empty_queue_should_be_zero(){
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void size_should_be_increased_after_push(){
        queue.add(1);

        Assert.assertEquals(1, queue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void exception_should_be_throw_when_element_empty(){
        queue.element();
    }

    @Test
    public void first_in_should_be_first_out(){
        queue.add(1);
        queue.add(2);

        Assert.assertEquals(1, queue.poll());
    }
}

