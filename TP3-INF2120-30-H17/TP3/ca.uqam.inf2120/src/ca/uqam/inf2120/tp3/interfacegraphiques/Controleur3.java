package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by JU on 4/8/2017.
 */
public class Controleur3 implements ActionListener{


    private MessageErreur erreur;

    // Constructeur avec la vue à controler comme paramètre


    Controleur3(MessageErreur uneErreur){

        erreur = uneErreur ;

    }
    // La redéfinition  de l'unique méthode de l'interface
    // ActionListener
    public void actionPerformed(ActionEvent event) {

        // Obtenir la source de l'événement.
        Object source = event.getSource();

    }
}
