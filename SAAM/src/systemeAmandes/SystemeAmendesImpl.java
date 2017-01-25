package systemeAmandes;

import java.util.HashSet;
import java.util.Set;

import IntSystemeAmandes.SystemeAmendes;
import radars.Amende;
import radars.Voiture;

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
			return a.getNumero();
		}else{
			return -1;
		}
	}

	@Override
	public Amende[] lister(String Immatriculation) {
		Amende[] a = new Amende [100];
		for(Amende am : listAmande){
			int cpt= 0;
			
			if(am.getImmatriculation().equals(Immatriculation)){
				a[cpt] = am;
				cpt++;
			}
		}
		return a;
	}

	@Override
	public void payer(int numero, String nom, String prenom) {
		for(Amende a : listAmande){
			if(a.getNumero() == numero){
				listAmande.remove(a);
			}
		}
	}

}
