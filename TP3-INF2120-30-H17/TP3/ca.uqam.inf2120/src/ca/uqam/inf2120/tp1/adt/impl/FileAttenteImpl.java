package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;


/**
 * FileAttenteImpl : implèmente l'interface FileAttenteTda 
 * 					hérite de OrdonnableParPrioriteEtDateHeure
 * 
 * @author Julien Guité-Vinet
 * @version Février 2017
 * 
 */
public class FileAttenteImpl<T extends OrdonnableParPrioriteEtDateHeure>
								implements FileAttenteTda<T> {
	private List<T> uneListe;
	private List<T> listOfRemovedElement;
	private List<T> listOfKeptElement;
	private HashMap<Integer,List<T> > uneMatrice;
	private boolean answer = false;
	private int compteur;
	private T element;
	private T elementCompared;
	private Iterator<T> it;

	
	/**
	 * Constructeur par défaut.
	 */
	public FileAttenteImpl() {
		
		uneListe = new ArrayList<>();
		listOfRemovedElement = new ArrayList<>();
		listOfKeptElement = new ArrayList<>();
		uneMatrice = new HashMap<>();
	}

	@Override
	public boolean placer(T elt) {
			
		if (elt == null || elt.obtenirPriorite() < 1 ||  estDansLaListe(elt)) {
			answer = false;
		}else{	
			
			if (uneListe.isEmpty()){
				uneListe.add(elt);
			}else {
				answer= true;
				Iterator <T> it = iterateur();
				while (it.hasNext())
					element = it.next();
					if (elt.obtenirPriorite() > element.obtenirPriorite()){
						uneListe.add(elt);
					}
					if (elt.obtenirPriorite() < element.obtenirPriorite()){
						uneListe.add(uneListe.indexOf(element),elt);
					}
					if (elt.obtenirPriorite() == element.obtenirPriorite()){
						if (elt.obtenirDateHeureCreation().before(element)){
							uneListe.add(uneListe.indexOf(element),elt);
						}else{
							uneListe.add(elt);
						}
					}
				}
			}		
		return answer;
	}

	@Override
	public void placer(List<T> liste) {

		for (T aListe : liste) {
			elementCompared = aListe;
			if (!(elementCompared == null || elementCompared.obtenirPriorite() < 1
					|| estDansLaListe(elementCompared))) {

				placer(aListe);
			}
		}
	}

	@Override
	public boolean enlever(T elt) {
		for (int i= 0 ;i < uneListe.size();i++){		
			element = uneListe.get(i);
			
			if(element.equals(elt)) {
				uneListe.remove(i);
				answer = true;
			}
		}
				
		return answer;
	}

	@Override
	public List<T> enlever(List<T> liste) {

		for (T aListe : liste) {
			elementCompared = aListe;
			for (int i = 0; i < uneListe.size(); i++) {
				element = uneListe.get(i);
				if (element.equals(elementCompared)) {
					uneListe.remove(i);
					compteur++;
				}
			}
		}		
		if (uneListe.size()== 0){
			listOfKeptElement = null;
		}else{
			listOfKeptElement = uneListe;
		}
		return listOfKeptElement;
	}

	@Override
	public List<T> enlever(int priorite) {
		
		for (int i= 0 ;i < uneListe.size();i++){		
			element = uneListe.get(i);
			
			if(element.obtenirPriorite() == priorite) {
				listOfRemovedElement.add(uneListe.remove(i));
				compteur++;
			}
		}
		if (compteur == 0){
			listOfRemovedElement = null;
		}
		return  listOfRemovedElement;
	}

	@Override
	public Map<Integer, List<T>> enlever(int priorite, boolean plusPetit) {
		Integer key;
		if (plusPetit){
		
			for (int i= 0 ; i< uneListe.size(); i++){		
				element = uneListe.get(i);
				key = element.obtenirPriorite();
				if(element.obtenirPriorite() > priorite) {
					listOfKeptElement.add(element);
					it = uneListe.iterator();
					while (it.hasNext()){
						element = it.next();

						if (element.obtenirPriorite() == key){
							listOfRemovedElement.add(element);
						}						
						uneMatrice.put(key, listOfRemovedElement);
						listOfRemovedElement.clear();
						compteur++;							
					}	
				}
			}
				uneListe = enlever(listOfKeptElement);
		}else {
			
			for (int i= 0 ; i< uneListe.size(); i++){		
				element = uneListe.get(i);
				key = element.obtenirPriorite();
				if(element.obtenirPriorite() < priorite) {
					listOfKeptElement.add(element);
					it = uneListe.iterator();
					while (it.hasNext()){
						element = it.next();

						if (element.obtenirPriorite() == key){
							listOfRemovedElement.add(element);
						}						
						uneMatrice.put(key, listOfRemovedElement);
						listOfRemovedElement.clear();
						compteur++;						
					}	
				}
			}
			
			uneListe = enlever(listOfKeptElement);					
		}
		if (compteur == 0){
			uneMatrice = null;
		}
		return uneMatrice;
				
	}

	@Override
	public boolean remplacer(int anciennePriorite, int nouvellePriorite) {
		if (nouvellePriorite < 1){
			answer = false;
		}else{
			it = iterateur();
			while (it.hasNext()){
				element = it.next();
				if (element.obtenirPriorite() == anciennePriorite){
					element.modifierPriorite(nouvellePriorite);	
					listOfKeptElement.add(element);
				}else{
					listOfKeptElement.add(element);
				}
			}
			uneListe.clear();
			placer(listOfKeptElement);
			answer = true;
		}
		return answer;
	}

	@Override
	public int ObtenirNbElments(int priorite) {
		compteur = 0;
		it = iterateur();
		while (it.hasNext()){
			element = it.next();
			if (element.obtenirPriorite() == priorite){
				compteur++;			
			}
		}
		return compteur;
	}

	@Override
	public boolean estVide() {return uneListe.isEmpty();}

	@Override
	public Iterator<T> iterateur() {return uneListe.iterator();}
	
	 /**
	    * Retourne vrai si l'élément T est dans la liste
	    * 
	    */
	public boolean estDansLaListe(T elt){
		answer= false;
		
		it = iterateur();
		while (it.hasNext() && !answer){
			element = it.next();
			answer = element.equals(elt);
		}
		return answer;
	}
	
	 /**
	    * Retourne la taille de uneListe
	    * 
	    */
	public int size(){return uneListe.size();}
	
	 /**
	    * Retourne uneListe
	    * 
	    */
	public List<T> thisListe(){
		return uneListe;
	}
	@Override
	public String toString() {
		String s= "";
		
		it = iterateur();
		while (it.hasNext()){
			element = it.next();
			String e = element.toString();
			s = s + e;
		}
		return "FileAttenteImpl [uneListe=" + s +"]";
	}

}
