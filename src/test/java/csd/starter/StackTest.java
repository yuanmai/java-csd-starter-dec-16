package csd.starter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by jay on 12/14/16.
 */
public class StackTest {

    private Stack stack = new Stack();

    public StackTest(){
        System.out.println("constructor");
    }

    @Before
    public void setup(){

    }

    @BeforeClass
    public static void beforeClass(){

    }

    @Test(expected = EmptyStackException.class)
    public void exception_should_throw_after_pop() {

        stack.pop();
    }


    @Test
    public void size_should_be_inc_when_push(){
        //Arrange

        stack.push("anything"); //Act

        assertEquals(1, stack.size()); //Assert
    }
}
