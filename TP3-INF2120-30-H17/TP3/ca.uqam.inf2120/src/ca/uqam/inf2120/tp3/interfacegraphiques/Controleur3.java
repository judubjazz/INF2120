package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by JU on 4/8/2017.
 */
public class Controleur3 implements ActionListener{


    private MessageErreur erreur;

    // Constructeur avec la vue � controler comme param�tre


    Controleur3(MessageErreur uneErreur){

        erreur = uneErreur ;

    }
    // La red�finition  de l'unique m�thode de l'interface
    // ActionListener
    public void actionPerformed(ActionEvent event) {

        // Obtenir la source de l'�v�nement.
        Object source = event.getSource();

    }
}
