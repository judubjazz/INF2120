package ca.uqam.inf2120.tp3.interfacegraphiques;

import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 * Created by JU on 4/10/2017.
 */
public class MessageErreur extends JOptionPane{

    MessageErreur() {

    }
    MessageErreur(String message) {
        init3(message);

    }

    private void init3(String message) {

        showOptionDialog(null,message, "Message", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,null ,new String[]{"Fermer"},"default");

    }
    // Le main pour démarrer l'application
    public static void main(String[] args) {

        MessageErreur uneErreur = new MessageErreur();
        uneErreur.setVisible(true);

    }
}
