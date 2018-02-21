package ca.uqam.inf2120.tp3.modele;

import java.util.List;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp1.adt.impl.FileAttenteImpl;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3
 * 
 * Classe GestionUrgenceCliniqueVeterinaire : contient les services de gestion
 * des patients de la clinique v�t�rinaire.
 * 
 * @author Ismael Doukoure 
 * Compl�t� par : VOTRE NOM VOTRE PR�NOM - VOTRE CODE PERMANENT
 * 
 * @version 5 avril 2017
 */
public class GestionUrgenceCliniqueVeterinaire {

	// La liste des patients
	private FileAttenteTda<Patient> listePatients;

	/**
	 * Constructeur sans argument qui cr�e une liste de patients vide.
	 */
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl<Patient>();
	}

	/**
	 * Place un patient dans la file des patients selon sa priorit�.
	 * 
	 * @param unPatient Le patient � ajouter
	 */
	public void placerPatient(Patient unPatient) {

		listePatients.placer(unPatient);

	}

	/**
	 * Trouve le patient selon son identifiant et modifie ce dernier selon les
	 * informations du patient pass� en param�tre.
	 * 
	 * @param unPatient Le patient � modifier
	 */
	public void modifierPatient(Patient unPatient) {

		// � COMPL�TER

	}

	/**
	 * Recherche les patients selon leur priorit�. La recherche se fait selon
	 * les crit�res suivants en fonction des param�tres "priorite" et
	 * "typeRecherche".
	 * 
	 * - Si le typeRecherche = 1, la m�thode retourne tous les patients dont la
	 *   priorit� est plus grande que la priorit� pass�e en param�tre.
	 * 
	 * - Si le typeRecherche = 0, la m�thode retourne tous les patients dont la
	 *   priorit� est �gale � la priorit� pass�e en param�tre.
	 * 
	 * - Si le typeRecherche = -1, la m�thode retourne tous les patients dont la
	 *    priorit� est plus petite que la priorit� pass�e en param�tre.
	 * 
	 * La m�thode retourne null si aucun patient ne r�pond aux crit�res.
	 * 
	 * @param priorite La Priorit� selon laquelle la recherche est faite.
	 * @param typeRecherche Le type de recherche dont les valeurs possibles: 1, 0, -1.
	 * @return Le tableau Liste (ArrayList) des patients qui r�pondent au
	 *         crit�re de recherche.
	 */
	public List<Patient> rechercherParPriorite(int priorite, int typeRecherche) {

		// � COMPL�TER

		return null;

	}

	/**
	 * Recherche le patient selon son identifiant. La m�thode retourne le
	 * patient dont l'identifiant qui est �gal � l'identifiant pass� en param�tre.
	 * La m�thode retourne null si aucun candidat trouv� avec cet identifiant.
	 * 
	 * @param identifiant L'identifiant du patient recherch�.
	 * @return Le patient dont l'identifiant est �gal � l'identifiant pass� en
	 *         param�tre.
	 */
	public Patient rechercherParIdentifiant(String identifiant) {

		// � COMPL�TER

		return null;

	}

	/**
	 * Recherche tous les patients. La m�thode retourne tous les patients.
	 * 
	 * @return Le tableau Liste (ArrayList) des patients.
	 */
	public List<Patient> rechercherTousLesPatients() {

		List<Patient> tousLesPatients = null;
		
		// � COMPL�TER

		return tousLesPatients;

	}

	/**
	 * Enl�ve le patient pass� en param�tre de la file des patients. Le
	 * patient enlev� doit avoir le m�me identifiant et la m�me priorit� que
	 * celui pass� en param�tre.
	 * 
	 * @param unPatient Le patient � enlever.
	 * @return Vrai si la suppression a �t� faite, sinon faux.
	 */
	public boolean enleverPatient(Patient patient) {

		// � COMPL�TER

		return false;

	}
	

	/* INFORMATIONS IMPORTANTES : 
	 * 
	 * Ajoutez toute autre m�thode que vous jugez n�cessaire pour accomplir ce travail.
     *
     */


}
