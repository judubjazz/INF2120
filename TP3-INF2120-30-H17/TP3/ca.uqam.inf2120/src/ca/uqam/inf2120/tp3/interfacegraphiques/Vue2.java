package ca.uqam.inf2120.tp3.interfacegraphiques;

import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;

import java.awt.*;
import javax.swing.*;
import javax.swing.SpringLayout;


/**
 * Created by Julien Guité-Vinet  on 4/8/2017.
 */
public class Vue2 extends JDialog {
    // instance variables etc

    private Controleur2 aControleur;

    private JPanel  panelContainer;

    private JPanel  panel1;
    private JRadioButton boutonFelin;
    private JRadioButton boutonCanin;
    private JRadioButton boutonAutre;
    private JLabel  labelFelin;
    private JLabel  labelCanin;
    private JLabel  labelAutre;


    private JPanel  panel2;
    private JLabel labelIdentifiantPatient;
    private JLabel labelNomPatient;
    private JLabel labelAgePatient;
    private JLabel labelRaisonPatient;
    private JLabel labelPrioritePatient;
    private JLabel labelDatePatient;
    private JTextField  txtFieldIdentifiantPatient;
    private JTextField  txtFieldNomPatient;
    private JTextField  txtFieldAgePatient;
    private JTextField  txtFieldRaisonPatient;
    private JTextField  txtFieldDatePatient;
    private JComboBox  comboBoxPrioritePatient;


    private JPanel panel3;
    private JLabel labelNomProprio;
    private JLabel labelPrenomProprio;
    private JLabel labelTelephoneProprio;
    private JLabel labelAdresseProprio;
    private JTextField  txtFieldNomProprio;
    private JTextField  txtFieldPrenomProprio;
    private JTextField  txtFieldTelephoneProprio;
    private JTextField  txtFieldAdresseProprio;

    private JPanel panelBouton;
    private JButton boutonAjouter;
    private JButton boutonAnnuler;


    // Constructeur
    Vue2() {

        init2();
        // Création du controleur (Controller du MVC)
        aControleur = new Controleur2(this);
        // Ajouter le controleur (écouteur) aux composants
        boutonAjouter.addActionListener(aControleur);
        boutonAnnuler.addActionListener(aControleur);
        comboBoxPrioritePatient.addActionListener(aControleur);
        txtFieldAgePatient.addActionListener(aControleur);
        txtFieldNomPatient.addActionListener(aControleur);
        txtFieldPrenomProprio.addActionListener(aControleur);

    }
    //Construscteur avec gestion en parametre
    Vue2(GestionUrgenceCliniqueVeterinaire gestion, Vue vue) {

        init2();
        // Création du controleur (Controller du MVC)
        aControleur = new Controleur2(this, gestion,vue);
        // Ajouter le controleur (écouteur) aux composants
        boutonAjouter.addActionListener(aControleur);
        boutonAnnuler.addActionListener(aControleur);
        comboBoxPrioritePatient.addActionListener(aControleur);
        txtFieldAgePatient.addActionListener(aControleur);
        txtFieldNomPatient.addActionListener(aControleur);
        txtFieldPrenomProprio.addActionListener(aControleur);

    }
    // Créer les composants et les ajouter au conteneur
    private void init2() {

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("SPT-Ajout d'un client");
        panelContainer = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panelBouton = new JPanel();

        panelContainer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));    //padding
        panelContainer.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        c.weightx = 10.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 0;
        add(panelContainer);

        panelContainer.add(panel1,c);
        panel1.setBorder(BorderFactory.createTitledBorder("Espèce"));
        panel1.setLayout(new FlowLayout());
        groupeBouton();
        panel1.add(boutonFelin);
        panel1.add(labelFelin= new JLabel("Félin"));
        panel1.add(boutonCanin);
        panel1.add(labelCanin = new JLabel("Canin"));
        panel1.add(boutonAutre);
        panel1.add(labelAutre = new JLabel("Autre"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        c.weightx = 10.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 1;
        panelContainer.add(panel2,c);
        panel2.setBorder(BorderFactory.createTitledBorder("Informations générales du patient"));
        SpringLayout springLayout1 = new SpringLayout();
        panel2.setLayout(springLayout1);
        panel2.add(labelIdentifiantPatient = new JLabel("Identifiant : "));
        panel2.add(txtFieldIdentifiantPatient = new JTextField("", 15));
        labelIdentifiantPatient.setVisible(false);
        txtFieldIdentifiantPatient.setVisible(false);
        panel2.add(labelNomPatient = new JLabel("Nom-Patient : "));
        panel2.add(txtFieldNomPatient = new JTextField("", 15));
        panel2.add(labelAgePatient = new JLabel("Age : "));
        panel2.add(txtFieldAgePatient = new JTextField("", 15));
        panel2.add(labelRaisonPatient = new JLabel("Raison de l'urgence : "));
        panel2.add(txtFieldRaisonPatient = new JTextField("", 15));
        panel2.add(labelPrioritePatient = new JLabel("Priorité:"));
        panel2.add(comboBoxPrioritePatient = new JComboBox());
        comboBoxPrioritePatient.addItem("1");
        comboBoxPrioritePatient.addItem("2");
        comboBoxPrioritePatient.addItem("3");
        comboBoxPrioritePatient.addItem("4");
        comboBoxPrioritePatient.addItem("5");
        comboBoxPrioritePatient.setEditable(false);
        panel2.add(labelDatePatient = new JLabel("Date/Heure d'arrivée : "));
        panel2.add(txtFieldDatePatient = new JTextField("", 15));
        labelDatePatient.setVisible(false);
        txtFieldDatePatient.setVisible(false);
        txtFieldRaisonPatient.setBackground(Color.white);
        txtFieldRaisonPatient.setBorder(null);
        SpringUtilities.makeGrid(panel2, 6, 2, 5, 5, 5, 5);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        c.weightx = 10.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 2;
        panelContainer.add(panel3,c);
        panel3.setBorder(BorderFactory.createTitledBorder("Informations du propriétaire"));
        panel3.setLayout(new SpringLayout());
        panel3.add(labelNomProprio = new JLabel("Nom :"));
        panel3.add(txtFieldNomProprio = new JTextField("", 15));
        panel3.add(labelPrenomProprio = new JLabel("Prénom :"));
        panel3.add(txtFieldPrenomProprio = new JTextField("", 15));
        panel3.add(labelTelephoneProprio = new JLabel("Téléphone :"));
        panel3.add(txtFieldTelephoneProprio = new JTextField("", 15));
        panel3.add(labelAdresseProprio = new JLabel("Adresse :"));
        panel3.add(txtFieldAdresseProprio = new JTextField("", 15));

        txtFieldAdresseProprio.setBackground(Color.white);
        txtFieldAdresseProprio.setBorder(null);
        SpringUtilities.makeGrid(panel3, 4, 2, 5, 5, 5, 5);


        ////////panneau du bas avec boutons
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 10.0;
        c.weighty = 0.0;
        c.gridwidth = 5;
        c.gridheight = 0;
        c.gridx = 4;
        c.gridy = 3;
        panelContainer.add(panelBouton,c);
        panelBouton.setLayout(new FlowLayout (FlowLayout.TRAILING));
        panelBouton.add(boutonAjouter = new JButton());
        boutonAjouter.setText("Ajouter");
        panelBouton.add(boutonAnnuler = new JButton());
        boutonAnnuler.setText("Annuler");
        setSize(600, 600);
        setResizable(true);
        setLocationRelativeTo(null);
    }


    public JButton getAjouterButton() {
        return boutonAjouter;
    }
    public JButton getAnnulerButton() {
        return boutonAnnuler;
    }

    public JRadioButton getBoutonFelin() {
        return boutonFelin;
    }
    public JRadioButton getBoutonCanin() {
        return boutonCanin;
    }
    public JRadioButton getBoutonAutre() {
        return boutonAutre;
    }
    public JLabel getLabelFelin() {
        return labelFelin;
    }
    public JLabel getLabelCanin() {
        return labelCanin;
    }
    public JLabel getLabelAutre() {
        return labelAutre;
    }

    public JPanel getPanel2() {
        return panel2;
    }
    public JLabel getLabelIdentifiantPatient() {
        return labelIdentifiantPatient;
    }
    public JLabel getLabelNomPatient() {
        return labelNomPatient;
    }
    public JLabel getLabelAgePatient() {
        return labelAgePatient;
    }
    public JLabel getLabelRaisonPatient() {
        return labelRaisonPatient;
    }
    public JLabel getLabelPrioritePatient() {
        return labelPrioritePatient;
    }
    public JLabel getLabelDatePatient() {
        return labelDatePatient;
    }

    public JTextField getTxtFieldNomPatient() {
        return txtFieldNomPatient;
    }
    public JTextField getTxtFieldAgePatient() {
        return txtFieldAgePatient;
    }
    public JTextField getTxtFieldRaisonPatient() {
        return txtFieldRaisonPatient;
    }
    public JTextField getTxtFieldDatePatient() {
        return txtFieldDatePatient;
    }
    public JTextField getTxtFieldIdentifiantPatient() {return txtFieldIdentifiantPatient;}

    public JComboBox getComboBoxPrioritePatient() {
        return comboBoxPrioritePatient;
    }

    public JPanel getPanel3() {
        return panel3;
    }
    public JLabel getLabelNomProprio() {
        return labelNomProprio;
    }
    public JLabel getLabelPrenomProprio() {
        return labelPrenomProprio;
    }
    public JLabel getLabelTelephoneProprio() {
        return labelTelephoneProprio;
    }
    public JLabel getLabelAdresseProprio() {
        return labelAdresseProprio;
    }

    public JTextField getTxtFieldNomProprio() {
        return txtFieldNomProprio;
    }
    public JTextField getTxtFieldPrenomProprio() {
        return txtFieldPrenomProprio;
    }
    public JTextField getTxtFieldTelephoneProprio() {
        return txtFieldTelephoneProprio;
    }
    public JTextField getTxtFieldAdresseProprio() {
        return txtFieldAdresseProprio;
    }
    public JPanel getPanelBouton() {
        return panelBouton;
    }
    public JPanel getPanel1() {
        return panel1;
    }
    public JButton getBoutonAjouter() {
        return boutonAjouter;
    }
    public JButton getBoutonAnnuler() {
        return boutonAnnuler;
    }
    public Controleur2 getControleur2() {
        return aControleur;
    }

    private void groupeBouton(){
        boutonFelin = new JRadioButton();
        boutonFelin.setSelected(true);
        boutonCanin = new JRadioButton();
        boutonAutre = new JRadioButton();
        ButtonGroup groupe = new ButtonGroup(); // Ajout des radio boutons au groupe pour// permettre un choix exclusif.
        groupe.add(boutonFelin);
        groupe.add(boutonCanin);
        groupe.add(boutonAutre);
    }
    // Le main pour démarrer l'application
    public static void main(String[] args) {
        Vue2 laVue2 = new Vue2();
        laVue2.setVisible(true);
    }

}
