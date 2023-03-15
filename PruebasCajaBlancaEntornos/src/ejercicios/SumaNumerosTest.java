package ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumaNumerosTest {

	@ParameterizedTest
	@MethodSource("contNums")
	void testCuentaImpares(int num, int esperado) {
		SumaNumeros cont = new SumaNumeros(num);
		int result = cont.sumaNumeros(num);
		assertEquals(esperado, result);
	}
	
	private static Stream <Arguments> contNums(){
		return Stream.of(
				Arguments.of(0, 0),
				Arguments.of(1, 0),
				Arguments.of(2, 2)
				);
	}

}
