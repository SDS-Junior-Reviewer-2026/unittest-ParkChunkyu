package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Mock
    Adder mockAdder;

    @InjectMocks
    private Calculator mockCalculator;

    @BeforeEach
    void stub() {
        lenient().doAnswer(invocationOnMock -> {
            int firstArgument = invocationOnMock.getArgument(0);
            int secondArgument = invocationOnMock.getArgument(1);
            return firstArgument + secondArgument;
        }).when(mockAdder).add(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void addTest() {
        assertThat(mockCalculator.add(3, 4))
                .isEqualTo(7);
    }

    @Test
    void subtractTest() {
        assertThat(mockCalculator.subtract(3, 4))
                .isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        assertThat(mockCalculator.multiply(3, 4))
                .isEqualTo(12);
    }

    @Test
    void divideTest_pos_pos() {
        assertThat(mockCalculator.divide(8, 4))
                .isEqualTo(2);
    }

    @Test
    void divideTest_neg_pos() {
        assertThat(mockCalculator.divide(-8, 4))
                .isEqualTo(-2);
    }

    @Test
    void divideTest_pos_neg() {
        assertThat(mockCalculator.divide(8, -4))
                .isEqualTo(-2);
    }

    @Test
    void divideTest_neg_neg() {
        assertThat(mockCalculator.divide(-8, -4))
                .isEqualTo(2);
    }

    @Test
    void divideByZeroTest() {
        assertThatThrownBy(() -> mockCalculator.divide(10, 0))
                .isInstanceOf(ArithmeticException.class);
    }
}