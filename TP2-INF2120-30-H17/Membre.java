package ca.uqam.inf2120.tp2.adt.test;

import java.util.GregorianCalendar;
import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;

/**
 * Membre : Cette classe correspond à l'élément T et sera utilisé pour faire les
 * tests unitaires
 * 
 * @author Ismael Doukoure - INF2120 - Groupe 30
 * @version 8 février 2017
 */
public class Membre implements OrdonnableParPrioriteEtDateHeure {

	// Déclaration des attributs
	private String identifiant;
	private String nom;
	private String prenom;
	private int priorite;
	private GregorianCalendar dateHeureCreation;

	public Membre() {
		dateHeureCreation = new GregorianCalendar();
	}

	/**
	 * 
	 * @param identifiant Identifiant du membre
	 */
	public Membre(String identifiant) {
		this.identifiant = identifiant;
		dateHeureCreation = new GregorianCalendar();
	}

	/**
	 * 
	 * @param identifiant Identifiant du membre
	 * @param nom Nom du membre
	 * @param prenom Prénom du membre
	 * @param priorite La priorité du mémbre
	 */
	
	public Membre(String identifiant, String nom, String prenom, int priorite) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.priorite = priorite;
		dateHeureCreation = new GregorianCalendar();
	}

	
	/**
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom 
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Priorite#modifierPriorite(int)
	 */
	@Override
	public void modifierPriorite(int priorite) {
		this.priorite = priorite;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.Priorite#obtenirPriorite()
	 */
	@Override
	public int obtenirPriorite() {
		return priorite;
	}
	
	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#obtenirDateHeureCreation()
	 */
	@Override
	public GregorianCalendar obtenirDateHeureCreation() {
		return dateHeureCreation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutreObjet) {

		boolean estEgal = false;

		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme résultat.
		if (this == unAutreObjet) {
			estEgal = true;

		} else if (unAutreObjet != null && 
				this.getClass() == unAutreObjet.getClass()) {

			// Sachant que unAutreObjet n'est pas null et que unAutreObjet
			// et l'objet courant sont de même type, on peut se permettre
			// la conversion de UnAutreObjet en Membre
			Membre mbre = (Membre) unAutreObjet;

			// Tester si les deux (2) objets ont le même identifiant.
			estEgal = (identifiant.equals(mbre.identifiant));
		}

		return estEgal;

	}

}