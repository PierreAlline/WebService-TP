package calculette;

import org.testng.annotations.*;

import IntCalculette.Calculette;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import static org.testng.Assert.*;

public class CalculetteTest {

    private Calculette calc;

    @BeforeClass
    public void setUp() throws Exception {
      calc = new CalculetteImpl();
    }

    @AfterClass
    public void tearDown() throws Exception {
        calc = null;
    }

    @Test
    public void testAjouter() throws Exception {
        assertEquals(calc.addition(2,3),5.0);
    }

    @Test
    public void testSoustraire() throws Exception {
        assertEquals(calc.soustraction(2,3),-1.0);
    }
}
