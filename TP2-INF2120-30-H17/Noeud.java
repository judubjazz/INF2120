package ca.uqam.inf2120.tp2.adt.impl;

/**
 * Titre : Liste Cha�n�e 
 * Description: La classe Noeud repr�sente l'unit� structurelle
 * et fonctionnelle d'une liste cha�n�e.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifi� le 12 Mars 2014
 */
public class Noeud<T> {
    private T element;          // r�f�rence de l'information contenu dans le noeud
    private Noeud<T> suivant;   // r�f�rence vers le noeud suivant
    
    
    /**
     * Cr�ation d'un objet Noeud � vide
     * les champs element et suivant seront initialis�s � null 
     */ 
     public Noeud () {
        this (null, null); // appel d'un autre constructeur
    } 
     

    /**
     * Cr�ation d'un objet Noeud
     * La r�f�rence vers l'�l�ment param�tre est initialis�e
     * @param element r�f�rence de  dans le noeud 
     */
    public Noeud (T element) {
        this (element, null); // appel d'un autre constructeur
    } 
 
    
    /**
     * Creation d'un objet Noeud
     * La r�f�rence vers l'�l�ment param�tre est initialis�e
     * @param element r�f�rence vers l'objet qui sera stock� dans le noeud 
     * @param suivant r�f�rence vers le noeud suivant
     */    
    public Noeud (T element, Noeud<T> suivant) {
        this.element = element;
        this.suivant = suivant;
    }
    
    /**
     * Obtenir la r�f�rence vers l'�l�ment contenu dans le noeud
     * @return reference vers l'objet element
     */
    public T getElement () {
        return element;    
    } 
    
    /**
     * Obtenir la r�f�rence du noeud suivant
     * @return reference vers le noeud suivant, peut �tre nulle
     */
    public Noeud<T> getSuivant () {
        return suivant;
        
    }   
 
    /**
     * Permet d'initialiser ou modifier le noeud suivant
     * @param la r�f�rence vers le noeud 
     */
    public void setSuivant (Noeud<T> unNoeud) {
        suivant = unNoeud;
    } 
    
    /**
     * Permet d'initialiser ou modifier l'�l�ment
     * @param element reference vers l'�l�ment
     */
    public void setElement (T element) {
        this.element = element;
        
    }
               
} // Noeud
