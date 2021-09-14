package com.practice.javapractice.tdd.add.test;

import com.practice.javapractice.tdd.add.StringPlusCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringPlusCalculatorTest {

    private StringPlusCalculator calculator = new StringPlusCalculator();

    @DisplayName("null 또는 빈문자 계산 테스트")
    @Test
    void nullOrEmptyTest() {
        String factor = "";
        assertThat(calculator.calculate(factor)).isEqualTo(0);
    }
    
    @DisplayName("숫자 하나 계산 테스트")
    @Test
    void singleFactorTest() {
        String factor = "1";
        assertThat(calculator.calculate(factor)).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자 계산 테스트")
    @Test
    void commaSeparatorTest() {
        String factors = "1,2,3";
        assertThat(calculator.calculate(factors)).isEqualTo(6);
    }

    @DisplayName("콤마, 세미콜론 계산 테스트")
    @Test
    void commanAndSemicolonTest() {
        String factors = "1,2:3";
        assertThat(calculator.calculate(factors)).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 계산 테스트")
    @Test
    void calculateTest() {
        String factors = "//;\n1;2;3";
        assertThat(calculator.calculate(factors)).isEqualTo(6);
    }

    @DisplayName("음수 값 전달하는 경우 RuntimeException")
    @Test
    void minusExceptionTest() {
        String factors = "-1,2,3";
        assertThatThrownBy(() -> {
            calculator.calculate(factors);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 외 값 전달하는 경우 RuntimeException")
    @Test
    void notNumberFactorExceptionTest() {
        String factors = "#,2,3";
        assertThatThrownBy(() -> {
            calculator.calculate(factors);
        }).isInstanceOf(RuntimeException.class);
    }
}
