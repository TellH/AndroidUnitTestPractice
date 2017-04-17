package com.tellh.unittestpractice;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tlh on 2017/4/17 :)
 */
public class MockitoTest {
    @Test
    public void verifyMethodCalls() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        mockedList.clear();

        verify(mockedList).add("one"); // 验证方法是否被调用
        verify(mockedList).add(Mockito.any()); // 验证方法是否被调用,但不验证方法的参数

        verify(mockedList, times(2)).clear(); // 验证方法被调用次数
        verify(mockedList, atMost(2)).clear(); // 验证方法被调用最多次数
        verify(mockedList, atLeast(1)).clear(); // 验证方法被调用最少次数
        verify(mockedList, never()).get(0); // 验证方法没有被调用
    }

    // 指定方法执行特定的动作或指定方法的返回值
    @Test
    public void stubMethodCalls() {
        List mockedList = mock(List.class);
        // 指定方法的返回值
        when(mockedList.get(0)).thenReturn("first");
        Assert.assertEquals("first", mockedList.get(0));

        // 指定方法执行特定的动作
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                return true;
            }
        }).when(mockedList).add("Hello");
        doNothing().when(mockedList).add("doNothing");
        doCallRealMethod().when(mockedList).add("doReal");
        doThrow(Exception.class).when(mockedList).add("doThrow");
    }
}
