package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Mock
    Adder mockAdder;

    @InjectMocks
    private Calculator mockCalculator;


    @Test
    void addTest() {
        doAnswer(invocationOnMock -> {
            int a = invocationOnMock.getArgument(0);
            int b = invocationOnMock.getArgument(1);
            return a + b;
        }).when(mockAdder).add(Mockito.anyInt(), Mockito.anyInt());

        assertThat(mockCalculator.add(3, 4))
                .isEqualTo(7);
    }

    @Test
    void subtractTest() {
        doAnswer(invocationOnMock -> {
            int a = invocationOnMock.getArgument(0);
            int b = invocationOnMock.getArgument(1);
            return a + b;
        }).when(mockAdder).add(Mockito.anyInt(), Mockito.anyInt());

        assertThat(mockCalculator.add(3, 4))
                .isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        doAnswer(invocationOnMock -> {
            int a = invocationOnMock.getArgument(0);
            int b = invocationOnMock.getArgument(1);
            return a + b;
        }).when(mockAdder).add(Mockito.anyInt(), Mockito.anyInt());

        assertThat(mockCalculator.add(3, 4))
                .isEqualTo(12);
    }
}