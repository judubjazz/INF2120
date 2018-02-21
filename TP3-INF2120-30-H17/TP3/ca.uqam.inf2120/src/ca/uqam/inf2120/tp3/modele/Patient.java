package ca.uqam.inf2120.tp3.modele;

import java.util.GregorianCalendar;
import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;


/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3 
 * 
 * Classe Patient (F�lin, Canin, ou autre): contient les informations 
 * d'un patient de la Clinique v�t�rinaire.
 *    
 * @author Ismael Doukoure
 * Compl�t� par : Guite-Vinet Julien GUIJ09058407
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
	private static int nbSequentiel = 1;

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
	 * Construit l'identifiant en concatenant les trois (3) premiers caract�res 
	 * du nom du patient et un num�ro s�quentiel . le num�ro s�quentiel doit �tre 
	 * un attribut statique de type int qui s'incr�mente chaque fois qu'on construit
	 * un identifiant. Cet attribut doit �tre d�clar� dans la classe Patient.
	 * 
	 * Si le nombre de caract�res composant le nom du patient est moins que trois (3)
	 * caract�res, le caract�re 'X' est utilis� pour les caract�res manquants.
	 * 
	 * Exemple : 
	 *   - nom du 1er patient  = Isidor,   l'identifiant = "ISI1
	 *   - nom du 2e patient  =  Betty,    l'identifiant = "BET2
	 *   - nom du 3e patient  =  Ya,       l'identifiant = "YAX3
	 * 
	 */
	public String construireIdentifiant() {
		if (nom.length()==1){
			identifiant = nom +"XX" + String.valueOf(nbSequentiel);
		}else if (nom.length()==2) {
			identifiant = nom +"X" + String.valueOf(nbSequentiel);
		}else {
			String firstChar = nom.substring(0, 3).toUpperCase();
			identifiant = firstChar + String.valueOf(nbSequentiel);
		}
		return identifiant;
	}

	

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.OrdonnableParPrioriteEtDateHeure#modifierPriorite(int)
	 */
	@Override
	public void modifierPriorite(int priorite) {
		this.priorite = priorite;
		
	}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.OrdonnableParPrioriteEtDateHeure#obtenirPriorite()
	 */
	@Override
	public int obtenirPriorite() {return priorite;}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.OrdonnableParPrioriteEtDateHeure#obtenirDateHeureCreation()
	 */
	@Override
	public GregorianCalendar obtenirDateHeureCreation() {return dateHeureArrivee;}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutrePatient) {
		boolean estEgal = false;
		if (this == unAutrePatient) {
			estEgal = true;
		}else if (unAutrePatient != null && this.getClass() == unAutrePatient.getClass()){
			Patient unPatient = (Patient)unAutrePatient;
			if (identifiant.equals(unPatient.identifiant)){
				estEgal = true;
			}
		}
		return estEgal;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public GregorianCalendar getDateHeureArrivee() {
		return dateHeureArrivee;
	}

	public void setDateHeureArrivee(GregorianCalendar dateHeureArrivee) {
		this.dateHeureArrivee = dateHeureArrivee;
	}

	public String getRaisonUrgence() {
		return raisonUrgence;
	}

	public void setRaisonUrgence(String raisonUrgence) {
		this.raisonUrgence = raisonUrgence;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public static int getNbSequentiel() {
		return nbSequentiel;
	}

	public static void setNbSequentiel(int nbSequentiel) {
		Patient.nbSequentiel = nbSequentiel;
	}



	/* INFORMATIONS IMPORTANTES :
	 * 
	 * Ajoutez les getters, les setters et toute autre m�thode que vous jugez 
	 * n�cessaire pour accomplir ce travail.
     *
     */
	
}
