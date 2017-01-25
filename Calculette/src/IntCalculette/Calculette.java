package IntCalculette;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Calculette {
	double addition(double a, double b);
	double soustraction(double a,double b);
}
