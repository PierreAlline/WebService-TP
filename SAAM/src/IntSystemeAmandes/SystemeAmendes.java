package IntSystemeAmandes;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import radars.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SystemeAmendes {
	void enregistrer(Voiture v);
	int signaler(String Immatriculation, String modele, int tarif);
	Amende[] lister(String Immatriculation);
	void payer (int numero, String nom, String prenom);
}
