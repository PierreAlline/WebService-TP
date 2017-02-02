package SystemeAmendeClient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import IntSystemeAmandes.SystemeAmendes;
import radars.Amende;
import radars.Personne;
import radars.Voiture;

public class SystemeAmendeClients {
	public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/amende?wsdl");
        QName qname = new QName("http://systemeAmandes/", "SystemeAmendesImplService");
        Service service = Service.create(url, qname);
        SystemeAmendes sa = service.getPort(SystemeAmendes.class);
        
        Voiture clio = new Voiture("AB 123 CD","Clio 3");
        Voiture punto = new Voiture(" AB 124 CD","Punto");
        
        Personne p1 = new Personne("Bob","Sponge","");
        Personne p2 = new Personne("Capitaine","Haddock","");
        
        clio.setProprietaire(p1);
        punto.setProprietaire(p2);
        
        sa.enregistrer(clio);
        sa.enregistrer(punto);
        
        int num = sa.signaler("AB 123 CD", "Clio 3", 90);
        System.out.println("Amende enregistré n: "+num+"\n");
        num = sa.signaler("AB 123 CD", "Tracteur", 90);
        System.out.println("Amende enregistré n: "+num+"\n");
        num = sa.signaler("AB 123 CD", "Clio 3", 130);
        System.out.println("Amende enregistré n: "+num+"\n");
        
        Amende[] a = sa.lister("AB 123 CD");
        
        for(Amende am : a){
        	System.out.println(am.toString()+"\n");
        }
        
        sa.payer(1, "Capitaine", "Haddock");
        a = sa.lister("AB 123 CD");
        
        for(Amende am : a){
        	System.out.println(am.toString()+"\n");
        }
        
        sa.payer(1, "Bob", "Sponge");
        a = sa.lister("AB 123 CD");
        
        for(Amende am : a){
        	System.out.println(am.toString()+"\n");
        }

    }
}
