package ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CuentaImparesTest {

	@ParameterizedTest
	@MethodSource("contImp")
	void testCuentaImpares(int num, int esperado) {
		CuentaImpares cont = new CuentaImpares(num);
		int result = cont.cuentaImpares(num);
		assertEquals(esperado, result);
	}
	
	private static Stream <Arguments> contImp(){
		return Stream.of(
				Arguments.of(0, 0),
				Arguments.of(1, 1),
				Arguments.of(2, 1),
				Arguments.of(3, 2)
				);
	}
	
}
