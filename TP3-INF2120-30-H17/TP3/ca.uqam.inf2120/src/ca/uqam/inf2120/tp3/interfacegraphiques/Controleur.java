package ca.uqam.inf2120.tp3.interfacegraphiques;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;
import ca.uqam.inf2120.tp3.modele.Patient;
import ca.uqam.inf2120.tp3.modele.Proprietaire;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;


/**
 * Created by JU on 4/8/2017.
 */
public class Controleur implements ActionListener {
    private List<Patient> tousLesPatients = new ArrayList<>();
    private Patient patient;
    private Proprietaire proprietaire;
    private GestionUrgenceCliniqueVeterinaire gestion;
    private Vue vue;
    private Vue2 vue2;
    private MessageErreur uneErreur;
    private int index;



    Controleur(Vue uneVue) {// Constructeur avec la vue à controler comme paramètre
        vue = uneVue;
        gestion = new GestionUrgenceCliniqueVeterinaire();
        proprietaire = new Proprietaire("Propescu", "Daniel", "123 alo", "450-441-1499");
        Patient patient1 = new Patient ("Akita","20", "Batars","urgent",1, proprietaire);
        Patient patient2 = new Patient ("Alsa","20", "Batars","urgent",2, proprietaire);
        Patient patient3 = new Patient ("Baloo","20", "Batars","urgent",3, proprietaire);
        gestion.placerPatient(patient1);
        gestion.placerPatient(patient2);
        gestion.placerPatient(patient3);
    }

    // La redéfinition  de l'unique méthode de l'interface ActionListener
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == vue.getFermerButton()) {
            vue.dispose();

        } else if (source == vue.getAjouterButton()) {      //Ajouter un patient
            vue2 = new Vue2(gestion,vue);
            vue2.setVisible(true);

        } else if (source == vue.getRechercherButton()) {
            if (vue.getNorthButton1().isSelected()) {       //Rechercher un identifiant
                rechercherUnIdentifiant();
            } else if (vue.getNorthButton5().isSelected()) {    //rechercher tous les patients
                rechercherTousLesPatients();
            } else if (vue.getNorthButton3().isSelected()){     //rechercher == priorité
                rechercherEgalPriorite();
            } else if (vue.getNorthButton4().isSelected()){     //rechercher < priorité
                rechercherPlusPetitePriorite();
            } else if (vue.getNorthButton2().isSelected()){     //rechercher > priorité
                rechercherPlusGrandePriorite();
            }

        } else if (source == vue.getNorthButton1() || source == vue.getNorthButton2() || source == vue.getNorthButton3()
                    || source == vue.getNorthButton3() || source == vue.getNorthButton4()) {
                activerLeChampsDeRecherche();
                enableBoutonMilieu2(false);

        } else if (source == vue.getNorthButton5()) {
            vue.getChampTexte().setText("");
            vue.getChampTexte().setEnabled(false);
            vue.getRechercherButton().setEnabled(true);

        } else if (source == vue.getModifierButton()) {     //Modifer un Patient
            modifierUnPatient();

        } else if (source == vue.getAfficherButton()) {   //afficher un Patient
            afficherUnPatient();

        } else if (source == vue.getSupprimerButton()) {    //supprimer un patient
            supprimerUnPatient();
        }
    }

    private void removeArrowComboBox(){
        JComboBox comboBox= vue2.getComboBoxPrioritePatient();
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };      //enlève la flèche du combo box
            }
            @Override
            public void setPopupVisible(JComboBox c, boolean v) {

                if (c.getItemCount() > 0) {
                    super.setPopupVisible(c, v);        //empêche le popup
                }
            }
        });
        comboBox.setPopupVisible(false);
        comboBox.setBorder(BorderFactory.createTitledBorder(""));
    }

    private void addArrowComboBox(){
        JComboBox comboBox= vue2.getComboBoxPrioritePatient();
        comboBox.setUI(new BasicComboBoxUI() {});
        comboBox.setBorder(BorderFactory.createTitledBorder(""));
    }

    private void rechercherUnIdentifiant() {
        String identifiant = vue.getChampTexte().getText();
        patient = gestion.rechercherParIdentifiant(identifiant);
        if (patient == null) {
            uneErreur = new MessageErreur("Aucun patient avec l'identifiant " + "\""+vue.getChampTexte().getText()+"\"");
            uneErreur.setVisible(true);
        } else {
            vue.getMilieu2().setVisible(true);
            Object[] objs = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
            vue.getTableModel().insertRow(index, objs);
            vue.getTablePatient().setRowSelectionInterval(0, 0);
            index++;
            enableBoutonMilieu2(true);
            removeExtraRowsTablePatient(1);
            vue.getTablePatient().repaint();
            vue.getMilieu2().repaint();
        }
    }
    private void rechercherTousLesPatients(){
        tousLesPatients = gestion.rechercherTousLesPatients();
        if (tousLesPatients.isEmpty()){
            uneErreur = new MessageErreur("Il n'y a aucun patient inscrit");
        }else {
            vue.getMilieu2().setVisible(true);
            for (Patient tousLesPatient : tousLesPatients) {
                patient = tousLesPatient;
                Object[] objs = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
                vue.getTableModel().insertRow(index, objs);
                vue.getTablePatient().setRowSelectionInterval(0, 0);
                index++;
            }
            removeExtraRowsTablePatient(tousLesPatients.size());
            enableBoutonMilieu2(true);
            vue.getTablePatient().repaint();
            vue.getMilieu2().repaint();
            index = 0;
        }
    }
    private void rechercherEgalPriorite() {
        if (vue.getChampTexte().getText().isEmpty()){
            uneErreur = new MessageErreur("Veuillez entrer une valeur");

        }else if(Integer.parseInt(vue.getChampTexte().getText())>5 || Integer.parseInt(vue.getChampTexte().getText())<1){
            uneErreur = new MessageErreur("Les priorités doivent être entre 1 et 5");
            vue.getChampTexte().setText("");

        }else if((gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),0)).isEmpty()) {
            uneErreur = new MessageErreur("Il n'y a aucun patient ayant une priorité plus grande que "+vue.getChampTexte().getText());
            vue.getChampTexte().setText("");

        }else {
            vue.getMilieu2().setVisible(true);
            tousLesPatients = gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),0);
            for (Patient tousLesPatient : tousLesPatients) {
                patient = tousLesPatient;
                Object[] objs = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
                vue.getTableModel().insertRow(index, objs);
                vue.getTablePatient().setRowSelectionInterval(0, 0);
                index++;
            }
            removeExtraRowsTablePatient(tousLesPatients.size());
            enableBoutonMilieu2(true);
            vue.getTablePatient().repaint();
            vue.getMilieu2().repaint();
            index = 0;
        }
    }

    private void rechercherPlusPetitePriorite() {
        if (vue.getChampTexte().getText().isEmpty()){
            uneErreur = new MessageErreur("Veuillez entrer une valeur");
        }else if(Integer.parseInt(vue.getChampTexte().getText())>5 || Integer.parseInt(vue.getChampTexte().getText())<1){
            uneErreur = new MessageErreur("Les priorités doivent être entre 1 et 5");
            vue.getChampTexte().setText("");
        }else if((gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),1)).isEmpty()) {
            uneErreur = new MessageErreur("Il n'y a aucun patient ayant une priorité plus grande que "+vue.getChampTexte().getText());

        }else {
            vue.getMilieu2().setVisible(true);
            tousLesPatients = gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),1);
            for (Patient tousLesPatient : tousLesPatients) {
                patient = tousLesPatient;
                Object[] objs = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
                vue.getTableModel().insertRow(index, objs);
                vue.getTablePatient().setRowSelectionInterval(0, 0);
                index++;
            }
            removeExtraRowsTablePatient(tousLesPatients.size());
            enableBoutonMilieu2(true);
            vue.getTablePatient().repaint();
            vue.getMilieu2().repaint();
            index = 0;
        }
    }

    private void rechercherPlusGrandePriorite() {
        if (vue.getChampTexte().getText().isEmpty()){
            uneErreur = new MessageErreur("Veuillez entrer une valeur");
        }else if(Integer.parseInt(vue.getChampTexte().getText())>5 || Integer.parseInt(vue.getChampTexte().getText())<1){
            uneErreur = new MessageErreur("Les priorités doivent être entre 1 et 5");
            vue.getChampTexte().setText("");
        }else if((gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),-1)).isEmpty()) {
            uneErreur = new MessageErreur("Il n'y a aucun patient ayant une priorité plus petite que "+vue.getChampTexte().getText());

        }else {
            vue.getMilieu2().setVisible(true);
            tousLesPatients = gestion.rechercherParPriorite(Integer.parseInt(vue.getChampTexte().getText()),-1);
            for (Patient tousLesPatient : tousLesPatients) {
                patient = tousLesPatient;
                Object[] objs = {patient.getIdentifiant(), patient.getNom(), patient.getPriorite(), patient.getDateHeureArrivee().getTime(), patient.getProprietaire().getNom() + " " + patient.getProprietaire().getPrenom()};
                vue.getTableModel().insertRow(index, objs);
                vue.getTablePatient().setRowSelectionInterval(0, 0);
                index++;
            }
            removeExtraRowsTablePatient(tousLesPatients.size());
            enableBoutonMilieu2(true);
            vue.getTablePatient().repaint();
            vue.getMilieu2().repaint();
            index = 0;
        }
    }

    private void modifierUnPatient() {
        vue2.setVisible(true);
        vue2.setTitle("SPT - Modification d'un patient");
        JTable unJtable = vue.getTablePatient();
        String unIdentifiant = unJtable.getValueAt(unJtable.getSelectedRow(), 0).toString();
        patient = gestion.rechercherParIdentifiant(unIdentifiant);
        proprietaire = patient.getProprietaire();
        vue2.getPanel1().setVisible(false);

        afficherTxtFieldVue2(true);
        setTextOfTxtFieldVue2();
        editerTxtFieldVue2(true);
        addArrowComboBox();
        vue2.getTxtFieldIdentifiantPatient().setEditable(false);
        vue2.getTxtFieldNomPatient().setEditable(false);
        vue2.getTxtFieldDatePatient().setEditable(false);

        vue2.getAjouterButton().setText("Modifier");
        vue2.getAjouterButton().setVisible(true);
        vue2.getPanel2().setBorder(BorderFactory.createTitledBorder("Informations générales"));
    }

    private void afficherUnPatient() {
        vue2.setVisible(true);
        vue2.setTitle("SPT - Affichage d'un patient");
        JTable unJtable = vue.getTablePatient();
        String unIdentifiant = unJtable.getValueAt(unJtable.getSelectedRow(), 0).toString();
        patient = gestion.rechercherParIdentifiant(unIdentifiant);
        proprietaire = patient.getProprietaire();
        vue2.getPanel1().setVisible(false);

        setTextOfTxtFieldVue2();
        editerTxtFieldVue2(false);
        removeArrowComboBox();

        vue2.getAnnulerButton().setText("Fermer");
        vue2.getAjouterButton().setVisible(false);
        vue2.getPanel2().setBorder(BorderFactory.createTitledBorder("Informations générales"));
    }

    private void supprimerUnPatient() {
        JTable unJtable = vue.getTablePatient();
        String unIdentifiant = unJtable.getValueAt(unJtable.getSelectedRow(), 0).toString();
        patient = gestion.rechercherParIdentifiant(unIdentifiant);
        gestion.enleverPatient(patient);
        DefaultTableModel m = (DefaultTableModel) unJtable.getModel();
        Object [] o = null;
        m.removeRow(unJtable.getSelectedRow());
        if (m.getRowCount()==0){
            m.addRow(o);
            vue.getMilieu2().setVisible(false);
        }
        if (gestion.getListePatients().estVide()) {
            enableBoutonMilieu2(false);
        }
    }

    private void removeExtraRowsTablePatient(int size){
        JTable unJtable = vue.getTablePatient();
        DefaultTableModel m = (DefaultTableModel)unJtable.getModel();
        if (m.getRowCount()>1) {
            int rowCount = m.getRowCount()-1;
            for(int i = rowCount;i>=size ;i--) {
                m.removeRow(i);
            }
        }
    }

    private void activerLeChampsDeRecherche(){
        vue.getChampTexte().setText("");
        vue.getChampTexte().setEnabled(true);
        vue.getRechercherButton().setEnabled(true);
        vue.getMilieu2().setVisible(false);
    }
    private void setTextOfTxtFieldVue2(){
        vue2.getTxtFieldIdentifiantPatient().setText(patient.getIdentifiant());
        vue2.getTxtFieldNomPatient().setText(patient.getNom());
        vue2.getTxtFieldAgePatient().setText(patient.getAge());
        vue2.getTxtFieldRaisonPatient().setText(patient.getRaisonUrgence());
        vue2.getTxtFieldNomProprio().setText(proprietaire.getNom());
        vue2.getTxtFieldPrenomProprio().setText(proprietaire.getPrenom());
        vue2.getTxtFieldTelephoneProprio().setText(proprietaire.getTelephone());
        vue2.getTxtFieldAdresseProprio().setText(proprietaire.getAdresse());
        vue2.getTxtFieldDatePatient().setText(patient.getDateHeureArrivee().getTime().toString());
    }

    private void afficherTxtFieldVue2(boolean estVisible){
        vue2.getTxtFieldIdentifiantPatient().setVisible(estVisible);
        vue2.getLabelIdentifiantPatient().setVisible(estVisible);
        vue2.getTxtFieldDatePatient().setVisible(estVisible);
        vue2.getLabelDatePatient().setVisible(estVisible);
    }
    private void editerTxtFieldVue2(boolean estEditable){
        vue2.getTxtFieldIdentifiantPatient().setEditable(estEditable);
        vue2.getTxtFieldDatePatient().setEditable(estEditable);
        vue2.getTxtFieldNomPatient().setEditable(estEditable);
        vue2.getTxtFieldAgePatient().setEditable(estEditable);
        vue2.getTxtFieldRaisonPatient().setEditable(estEditable);
        vue2.getTxtFieldNomProprio().setEditable(estEditable);
        vue2.getTxtFieldPrenomProprio().setEditable(estEditable);
        vue2.getTxtFieldTelephoneProprio().setEditable(estEditable);
        vue2.getTxtFieldAdresseProprio().setEditable(estEditable);
    }
    private void enableBoutonMilieu2(boolean estEnable){
        vue.getModifierButton().setEnabled(estEnable);
        vue.getSupprimerButton().setEnabled(estEnable);
        vue.getAfficherButton().setEnabled(estEnable);
    }

}
