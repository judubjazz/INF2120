package ca.uqam.inf2120.tp3.modele;

import java.util.List;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp1.adt.impl.FileAttenteImpl;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3
 * 
 * Classe GestionUrgenceCliniqueVeterinaire : contient les services de gestion
 * des patients de la clinique vétérinaire.
 * 
 * @author Ismael Doukoure 
 * Complété par : VOTRE NOM VOTRE PRÉNOM - VOTRE CODE PERMANENT
 * 
 * @version 5 avril 2017
 */
public class GestionUrgenceCliniqueVeterinaire {

	// La liste des patients
	private FileAttenteTda<Patient> listePatients;

	/**
	 * Constructeur sans argument qui crée une liste de patients vide.
	 */
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl<Patient>();
	}

	/**
	 * Place un patient dans la file des patients selon sa priorité.
	 * 
	 * @param unPatient Le patient à ajouter
	 */
	public void placerPatient(Patient unPatient) {

		listePatients.placer(unPatient);

	}

	/**
	 * Trouve le patient selon son identifiant et modifie ce dernier selon les
	 * informations du patient passé en paramètre.
	 * 
	 * @param unPatient Le patient à modifier
	 */
	public void modifierPatient(Patient unPatient) {

		// À COMPLÉTER

	}

	/**
	 * Recherche les patients selon leur priorité. La recherche se fait selon
	 * les critères suivants en fonction des paramètres "priorite" et
	 * "typeRecherche".
	 * 
	 * - Si le typeRecherche = 1, la méthode retourne tous les patients dont la
	 *   priorité est plus grande que la priorité passée en paramètre.
	 * 
	 * - Si le typeRecherche = 0, la méthode retourne tous les patients dont la
	 *   priorité est égale à la priorité passée en paramètre.
	 * 
	 * - Si le typeRecherche = -1, la méthode retourne tous les patients dont la
	 *    priorité est plus petite que la priorité passée en paramètre.
	 * 
	 * La méthode retourne null si aucun patient ne répond aux critères.
	 * 
	 * @param priorite La Priorité selon laquelle la recherche est faite.
	 * @param typeRecherche Le type de recherche dont les valeurs possibles: 1, 0, -1.
	 * @return Le tableau Liste (ArrayList) des patients qui répondent au
	 *         critère de recherche.
	 */
	public List<Patient> rechercherParPriorite(int priorite, int typeRecherche) {

		// À COMPLÉTER

		return null;

	}

	/**
	 * Recherche le patient selon son identifiant. La méthode retourne le
	 * patient dont l'identifiant qui est égal à l'identifiant passé en paramètre.
	 * La méthode retourne null si aucun candidat trouvé avec cet identifiant.
	 * 
	 * @param identifiant L'identifiant du patient recherché.
	 * @return Le patient dont l'identifiant est égal à l'identifiant passé en
	 *         paramètre.
	 */
	public Patient rechercherParIdentifiant(String identifiant) {

		// À COMPLÉTER

		return null;

	}

	/**
	 * Recherche tous les patients. La méthode retourne tous les patients.
	 * 
	 * @return Le tableau Liste (ArrayList) des patients.
	 */
	public List<Patient> rechercherTousLesPatients() {

		List<Patient> tousLesPatients = null;
		
		// À COMPLÉTER

		return tousLesPatients;

	}

	/**
	 * Enlève le patient passé en paramètre de la file des patients. Le
	 * patient enlevé doit avoir le même identifiant et la même priorité que
	 * celui passé en paramètre.
	 * 
	 * @param unPatient Le patient à enlever.
	 * @return Vrai si la suppression a été faite, sinon faux.
	 */
	public boolean enleverPatient(Patient patient) {

		// À COMPLÉTER

		return false;

	}
	

	/* INFORMATIONS IMPORTANTES : 
	 * 
	 * Ajoutez toute autre méthode que vous jugez nécessaire pour accomplir ce travail.
     *
     */


}
