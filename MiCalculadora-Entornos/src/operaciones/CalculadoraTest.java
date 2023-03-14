package operaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculadoraTest {
	static Calculadora calc; //Lo creamos en estático porque los métodos 'beforeall' y 'afterall' sólo fufan así
	//Los métodos 'beforeeach' y 'aftereach' sí funcionan de manera no estática

	@BeforeAll
	static void crearCalculadora() { //De nuevo, estático para que no dé error
		calc = new Calculadora(20, 5);
	}

	@AfterAll
	static void borrarDatos() { //ESTÁTICO
		calc = null;
	}

	@Test
	void testSuma() {
		int result = calc.suma();
		assertEquals(25, result);
	}

	@Test
	void testResta() {
		int result = calc.resta();
		assertEquals(15, result);
	}

	@Test
	void testResta2() {
		Boolean result = calc.resta2();
		assertTrue(result);
	}

	@Test
	void testMultiplica() {
		int result = calc.multiplica();
		assertEquals(100, result);
	}

	@Test
	void testDivide() {
		int result = calc.divide();
		assertEquals(4, result, "No coinciden los resultados");
	}

	@Test
	void testDivide2() {
		Integer result = calc.divide2();
		assertNotNull(result);
	}

	@ParameterizedTest
	@MethodSource("division") //Le indicamos que haga uso del método 'division' mediante la etiqueta 'MethodSource'
	void testDivision(int num1, int num2, int expected) {
		//Creamos objeto de tipo Calculadora con los números usados por parámetro
		Calculadora calcDiv = new Calculadora(num1, num2);
		int result = calcDiv.divide();
		//Comparo si el resultado esperado coincide con el resultado de la función
		assertEquals(expected, result);
	}

	private static Stream<Arguments> division() {
		return Stream.of(
				Arguments.of(20, 10, 2),
				Arguments.of(30, -5, -6), 
				Arguments.of(5, 2, 2)
			);
	}
}