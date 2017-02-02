package systemeAmandes;

import java.util.HashSet;
import java.util.Set;

import javax.jws.WebService;

import IntSystemeAmandes.SystemeAmendes;
import radars.Amende;
import radars.Voiture;

@WebService(endpointInterface = "IntSystemeAmandes.SystemeAmendes")
public class SystemeAmendesImpl implements SystemeAmendes{

	Set<Amende> listAmande;
	Set<Voiture> listVoiture;
	
	public SystemeAmendesImpl() {
		listAmande = new HashSet<>();
		listVoiture = new HashSet<>();
	}
	
	public Set<Amende> getListAmande() {
		return listAmande;
	}

	public void setListAmande(Set<Amende> listAmande) {
		this.listAmande = listAmande;
	}

	public Set<Voiture> getListVoiture() {
		return listVoiture;
	}

	public void setListVoiture(Set<Voiture> listVoiture) {
		this.listVoiture = listVoiture;
	}

	@Override
	public void enregistrer(Voiture v) {
		listVoiture.add(v);
		v.toString();
	}

	@Override
	public int signaler(String Immatriculation, String modele, int tarif) {
		Voiture voit = null;
		Amende a;
		for(Voiture v : listVoiture){
			if(v.getImmatriculation().equals(Immatriculation)&& v.getModele().equals(modele)){
				voit = v;
			}
		}
		if(voit != null){
			a = new Amende(Immatriculation, tarif);
			listAmande.add(a);
			a.toString();
			return a.getNumero();
		}else{
			return -1;
		}
	}

	@Override
	public Amende[] lister(String Immatriculation) {
		Amende[] a;
		int cpt= 0;
		for(Amende am : listAmande){
			cpt++;
		}
		a= new Amende[cpt];
		cpt = 0;
		for(Amende am : listAmande){
			if(am.getImmatriculation().equals(Immatriculation)){
				a[cpt] = am;
				cpt++;
			}
		}
		return a;
	}

	@Override
	public void payer(int numero, String nom, String prenom) {
		Amende an = null;
		for(Amende a : listAmande){
			if(a.getNumero() == numero){
				for(Voiture v : listVoiture){
					if(a.getImmatriculation() == v.getImmatriculation()){
						if(v.getProprietaire().getNom().equals(nom) && v.getProprietaire().getPrenom().equals(prenom)){
							an = a;
						}
					}
				}
				
			}
		}
		if(an != null){
			listAmande.remove(an);
		}
	}

}
