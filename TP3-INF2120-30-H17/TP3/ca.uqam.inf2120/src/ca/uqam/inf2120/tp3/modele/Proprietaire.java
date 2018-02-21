package ca.uqam.inf2120.tp3.modele;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3 
 * 
 * Classe Proprietaire : contient les informations du propriétaire
 * du patient (Félin, canin, autre).
 *    
 * @author Ismael Doukoure
 * Complété par : GUITE-VINET JULIEN - GUIJ09058407
 * 
 * @version 5 avril 2017
 */
public class Proprietaire {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;



	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 */
	public Proprietaire(String nom, String prenom, String adresse,
			String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

/* INFORMATIONS IMPORTANTES :
	 * 
	 * Ajoutez les getters, les setters et toute autre méthode que vous jugez 
	 * nécessaire pour accomplir ce travail.
     *
     */	
	

}
