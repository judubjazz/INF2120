package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;
import ca.uqam.inf2120.tp3.modele.Patient;
import ca.uqam.inf2120.tp3.modele.Proprietaire;

import javax.swing.*;

/**
 * Created by JU on 4/8/2017.
 */
public class Controleur2 implements ActionListener{

    private Patient patient;
    private Proprietaire proprietaire;
    private GestionUrgenceCliniqueVeterinaire gestion;
    private Vue2 vue2;
    private Vue vue;
    private Controleur controleur1;
    private MessageErreur msgErr;


    Controleur2(Vue2 uneVue2){vue2 = uneVue2 ;}    // Constructeur avec la vue à controler comme paramètre

    Controleur2(Vue2 uneVue2, GestionUrgenceCliniqueVeterinaire uneGestion, Vue uneVue){
        gestion = uneGestion;
        vue2 = uneVue2 ;
        vue= uneVue;


    }

    // La redéfinition  de l'unique méthode de l'interface ActionListener
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource(); // Obtenir la source de l'événement.

        if(source == vue2.getAnnulerButton()){
            vue2.dispose();
        }else if(source == vue2.getAjouterButton()) {
            boolean complet = true;
            String nom = vue2.getTxtFieldNomPatient().getText();
            String age = vue2.getTxtFieldNomPatient().getText();
            String raison = vue2.getTxtFieldRaisonPatient().getText();
            String nomProprio = vue2.getTxtFieldNomProprio().getText();
            String prenomProprio = vue2.getTxtFieldPrenomProprio().getText();
            String telephone = vue2.getTxtFieldTelephoneProprio().getText();
            String adresse = vue2.getTxtFieldTelephoneProprio().getText();
            int priorite = vue2.getComboBoxPrioritePatient().getSelectedIndex() + 1;

            Object[] objs = {nom, age, raison, nomProprio, prenomProprio, telephone, adresse};
            for (int i = 0; i < objs.length; i++) {
                if (objs[i].equals("")) {
                    msgErr = new MessageErreur("Veuillez remplir tout le formulaire");
                    i = objs.length;
                    complet = false;
                }
            }
            if (complet && vue2.getAjouterButton().getText().equals("Ajouter")) {
                this.proprietaire = new Proprietaire(nomProprio, prenomProprio, adresse, telephone);
                this.patient = new Patient(nom, age, "batard", raison, priorite, proprietaire);
                gestion.placerPatient(patient);
                vue2.dispose();
            } else if (complet && vue2.getAjouterButton().getText().equals("Modifier")) {
                this.proprietaire = new Proprietaire(nomProprio, prenomProprio, adresse, telephone);
                this.patient = new Patient(nom, age, "batard", raison, priorite, proprietaire);
                gestion.modifierPatient(patient);
                Object[] unPatientInfo = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
                JTable unJtable = vue.getTablePatient();
                int index = unJtable.getSelectedRow();
                vue.getTableModel().insertRow(unJtable.getSelectedRow(), unPatientInfo);
                vue.getTableModel().removeRow(index+1);
                vue2.dispose();
            }
        }
    }

    public Patient getModelePatient() {
        return patient;
    }
}
