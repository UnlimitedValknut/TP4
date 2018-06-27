package suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import coloreo.ColoreoTest;
import generador.GeneradorGrafosTest;
import probador.ProbadorTest;

@RunWith(Suite.class)
@SuiteClasses({ GeneradorGrafosTest.class, ColoreoTest.class, ProbadorTest.class })
public class SuiteGenerico {

	@Test
	public void test() {

	}
}
