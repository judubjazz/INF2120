package ca.uqam.inf2120.tp3.modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
 * Compl�t� par : Guit�-Vinet Julien GUIJ09058407
 * 
 * @version 5 avril 2017
 */
public class GestionUrgenceCliniqueVeterinaire {


	// La liste des patients
	private FileAttenteTda<Patient> listePatients;
	private Iterator<Patient> it;
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
	public void placerPatient(Patient unPatient) {listePatients.placer(unPatient);}

	/**
	 * Trouve le patient selon son identifiant et modifie ce dernier selon les
	 * informations du patient pass� en param�tre.
	 * 
	 * @param unPatient Le patient � modifier
	 */
	public void modifierPatient(Patient unPatient) {
		Patient patientAmodifier;
		boolean estDansLaListe = false;
		it = listePatients.iterateur();

		while (it.hasNext() &&!estDansLaListe) {
			patientAmodifier = it.next();
			if (patientAmodifier.getIdentifiant().equals(unPatient.getIdentifiant())){
				estDansLaListe = true;
				listePatients.enlever(patientAmodifier);
				listePatients.placer(unPatient);
			}
		}
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
		List<Patient> unArrayList = new ArrayList<>();
		Patient unPatient;
		it = listePatients.iterateur();

		switch (typeRecherche) {
			case 1:
				while (it.hasNext()) {
					unPatient = it.next();
					if (unPatient.obtenirPriorite() < priorite){
						unArrayList.add(unPatient);
					}
				}
				break;
			case 0:
				while (it.hasNext()) {
					unPatient = it.next();
					if (unPatient.obtenirPriorite() == priorite) {
						unArrayList.add(unPatient);
					}
				}
				break;
			case -1:
				while (it.hasNext()) {
					unPatient = it.next();
					if (unPatient.obtenirPriorite() > priorite) {
						unArrayList.add(unPatient);
					}
				}
				break;
			default:
				unArrayList = null;
				break;
		}
		return unArrayList;
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
		Patient unPatient = null;
		boolean estDansLaListe = false;
		it = listePatients.iterateur();

		while (it.hasNext() && !estDansLaListe){
			unPatient = it.next();
			if (unPatient.getIdentifiant().equals(identifiant)){
				estDansLaListe = true;
			}
		}
		if (estDansLaListe == false){unPatient = null;}
		return unPatient;
	}

	/**
	 * Recherche tous les patients. La m�thode retourne tous les patients.
	 * 
	 * @return Le tableau Liste (ArrayList) des patients.
	 */
	public List<Patient> rechercherTousLesPatients() {

		List<Patient> tousLesPatients = new ArrayList<>();
		Patient unPatient;
		it = listePatients.iterateur();

		while (it.hasNext()){
			unPatient = it.next();
			tousLesPatients.add(unPatient);
		}
		return tousLesPatients;
	}

	/**
	 * Enl�ve le patient pass� en param�tre de la file des patients. Le
	 * patient enlev� doit avoir le m�me identifiant et la m�me priorit� que
	 * celui pass� en param�tre.
	 * 
	 * @param  patient Le patient � enlever.
	 * @return Vrai si la suppression a �t� faite, sinon faux.
	 */
	public boolean enleverPatient(Patient patient) {

		Patient unPatient = null;
		boolean estDansLaListe = false;
		it = listePatients.iterateur();

		while (it.hasNext() && !estDansLaListe){
			unPatient = it.next();
			if (unPatient.getIdentifiant().equals(patient.getIdentifiant()) && unPatient.obtenirPriorite() == patient.obtenirPriorite()){
				estDansLaListe = true;
				listePatients.enlever(patient);
			}
		}
		return estDansLaListe;

	}

	public FileAttenteTda<Patient> getListePatients() {
		return listePatients;
	}
	
/* INFORMATIONS IMPORTANTES :
	 * 
	 * Ajoutez toute autre m�thode que vous jugez n�cessaire pour accomplir ce travail.
     *
     */


}
