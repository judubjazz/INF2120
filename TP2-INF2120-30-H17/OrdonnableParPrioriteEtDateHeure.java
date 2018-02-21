package ca.uqam.inf2120.tp2.adt;

import java.util.GregorianCalendar;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP2
 * 
 * OrdonnableParPrioriteEtDateHeure : Interface définissant les services de
 * gestion de la priorité et de la date / heure de création d'un élément
 * ordonnable selon la priorité et la date / heure de création.
 * 
 * @author Ismael Doukoure
 * @version 8 mars 2017
 */
public interface OrdonnableParPrioriteEtDateHeure {

	/**
	 * Modifie la priorité .
	 * 
	 * @param priorite
	 *            La nouvelle priorité.
	 */
	public void modifierPriorite(int priorite);

	/**
	 * Retourne la prioritié
	 * 
	 * @return La priorité
	 */
	public int obtenirPriorite();

	/**
	 * Retourne la date et heure de création
	 * 
	 * @return La date de création et heure de création
	 */
	public GregorianCalendar obtenirDateHeureCreation();

}
