package pl.sdacademy.unit.test.advance.exercises.Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sdacademy.unit.test.advance.exercises.exceptions.CalculatorService;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideDataForAdd")
    void shouldAddTwoInt(int a, int b, int ecpectedResult) {
        //given
        Calculator calculator =new Calculator();
        //when
        int result = calculator.add(a,b);

        //then
        assertEquals(ecpectedResult, result);  //junit
        assertThat(result).isEqualTo(ecpectedResult);

    }
    static Stream<Arguments> provideDataForAdd(){
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(2,3,5),
                Arguments.of(2,2,4)
        );
    }
    @ParameterizedTest
    @MethodSource("provideDataForDiv")
    void shouldThrowExeptionWhenIntZero(int a, int b) {
        //given
        Calculator calculator=new Calculator(); //mozna wyciagnac tworzenie obiektu na gorze
        //when
        assertThrows(ArithmeticException.class,
                () -> calculator.div(a, b));
    }
    static Stream<Arguments> provideDataForDiv() {
        return Stream.of(

                Arguments.of(6, 0),
                Arguments.of(0, 0)


        );


    }



}
//    @ParameterizedTest
//    @ValueSource(strings = {"", "   ", " "})
//    void shouldReturnTrueIfStringIsBlank(String input) {
//        //when
//        boolean result = StringUtil.isBlank(input);
//        //then
//        assertTrue(result); //jUnit
//        assertThat(result).isTrue(); //assertJ