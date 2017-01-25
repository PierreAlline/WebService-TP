package calculette;

import javax.jws.WebService;

import IntCalculette.Calculette;

@WebService(endpointInterface = "IntCalculette.Calculette")
public class CalculetteImpl implements Calculette{

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double soustraction(double a, double b) {
		return a -b;
	}
	
}
