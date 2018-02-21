package ca.uqam.inf2120.tp3.modele;

import java.util.GregorianCalendar;

import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;


/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3 
 * 
 * Classe Patient (Félin, Canin, ou autre): contient les informations 
 * d'un patient de la Clinique vétérinaire.
 *    
 * @author Ismael Doukoure
 * Complété par : VOTRE NOM  VOTRE PRÉNOM - VOTRE CODE PERMANENT
 * 
 * @version 5 avril 2017
 */
public class Patient implements OrdonnableParPrioriteEtDateHeure {
	 
	
	private String identifiant;
	private String espece;
	private String nom;
	private String age;
	private GregorianCalendar dateHeureArrivee;
	private String raisonUrgence;
	private int priorite;
	private Proprietaire proprietaire;
	private static int nbSequentiel = 0;
	
	
	
	/**
	 * 
	 * @param nom
	 * @param age
	 * @param espece
	 * @param raisonUrgence
	 * @param priorite
	 * @param proprietaire
	 */
	public Patient(String nom, String age, String espece, String raisonUrgence,
			       int priorite, Proprietaire proprietaire) {
		
		this.nom = nom;
		this.age = age;
		this.espece = espece;
		this.raisonUrgence = raisonUrgence;
		this.priorite = priorite;
		this.proprietaire = proprietaire;
		identifiant = construireIdentifiant();
		dateHeureArrivee = new GregorianCalendar();
		
	}

	
	/**
	 * Construit l'identifiant en concatenant les trois (3) premiers caractères 
	 * du nom du patient et un numéro séquentiel . le numéro séquentiel doit être 
	 * un attribut statique de type int qui s'incrémente chaque fois qu'on construit
	 * un identifiant. Cet attribut doit être déclaré dans la classe Patient.
	 * 
	 * Si le nombre de caractères composant le nom du patient est moins que trois (3)
	 * caractères, le caractère 'X' est utilisé pour les caractères manquants.
	 * 
	 * Exemple : 
	 *   - nom du 1er patient  = Isidor,   l'identifiant = "ISI1
	 *   - nom du 2e patient  =  Betty,    l'identifiant = "BET2
	 *   - nom du 3e patient  =  Ya,       l'identifiant = "YAX3
	 * 
	 */
	public String construireIdentifiant() {

		// À COMPLÉTER
		
		return null;
	}

	

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#modifierPriorite(int)
	 */
	@Override
	public void modifierPriorite(int priorite) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#obtenirPriorite()
	 */
	@Override
	public int obtenirPriorite() {
		// TODO Auto-generated method stub
		return 0;
	}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#obtenirDateHeureCreation()
	 */
	@Override
	public GregorianCalendar obtenirDateHeureCreation() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutrePatient) {


		// À COMPLÉTER
		
		return false;

	}



	

	/* INFORMATIONS IMPORTANTES : 
	 * 
	 * Ajoutez les getters, les setters et toute autre méthode que vous jugez 
	 * nécessaire pour accomplir ce travail.
     *
     */
	
}
