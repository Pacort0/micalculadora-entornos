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
	void testResta2() {
		Boolean result = calc.resta2();
		assertTrue(result);
	}

	@Test
	void testMultiplica() {
		int result = calc.multiplica();
		assertEquals(100, result);
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
	
	@ParameterizedTest
	@MethodSource("division2")
	void testDivision2(int num1, int num2, Integer esperado) {
		Calculadora calcDiv = new Calculadora(num1, num2);
		Integer result = calcDiv.divide2();
		assertEquals(esperado, result);
	}
	
	private static Stream <Arguments> division2(){
		return Stream.of(
				Arguments.of(30, 10, 3),
				Arguments.of(10, 0, null)
			);
		
	}
	
	@ParameterizedTest
	@MethodSource("restacion")
	void testResta(int num1, int num2, int esperado) {
		Calculadora calcRestacion = new Calculadora(num1, num2);
		int result = calcRestacion.resta();
		assertEquals(esperado, result);
	}
	
	private static Stream <Arguments> restacion(){
		return Stream.of(
				Arguments.of(30, 10, 20),
				Arguments.of(20, 50, 30)
			);
	}
	
	@ParameterizedTest
	@MethodSource("restacion2")
	void testResta2(int num1, int num2, Boolean esperado) {
		Calculadora calcRestacion2 = new Calculadora (num1, num2);
		Boolean result = calcRestacion2.resta2();
		assertEquals(esperado, result);
	}
	
	private static Stream <Arguments> restacion2(){
		return Stream.of(
				Arguments.of(2, 1, true),
				Arguments.of(2, 3, false),
				Arguments.of(2, 2, true)
			);
	}
}