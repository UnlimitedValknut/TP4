package suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import coloreo.ColoreoAleatorioTest;
import coloreo.ColoreoRegularTest;
import generador.GeneradorGrafosAleatoriosTest;
import generador.GeneradorGrafosRegularesTest;
import probador.ProbadorColoreoTest;

@RunWith(Suite.class)
@SuiteClasses({ GeneradorGrafosRegularesTest.class, GeneradorGrafosAleatoriosTest.class, ColoreoRegularTest.class,
		ColoreoAleatorioTest.class, ProbadorColoreoTest.class })
public class SuiteGenerarColoreoProbadorTest {

	@Test
	public void test() {

	}
}
