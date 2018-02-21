package ca.uqam.inf2120.tp3.interfacegraphiques;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Julien Guité-Vinet on 4/8/2017.
 */
public class Vue extends JFrame {
    // instance variables etc

    private Controleur aControleur;

    private JPanel  haut;
    private JRadioButton northButtton1;
    private JRadioButton northButtton2;
    private JRadioButton northButtton3;
    private JRadioButton northButtton4;
    private JRadioButton northButtton5;
    private ButtonGroup groupeBouton;
    private JLabel  identifiant;
    private JLabel  prioriteEq;
    private JLabel  allPatients;
    private JLabel  prioriteGt;
    private JLabel  prioriteLt;

    private JPanel milieuContainer;
    private JPanel  milieu;
    private JPanel emptyPanel;
    private JPanel milieu2;
    private JButton rechercher;
    private JTextField  champTexte;

    private JTable tablePatient;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    private JPanel  bas;
    private JButton ajouter;
    private JButton modifier;
    private JButton supprimer;
    private JButton afficher;
    private JButton fermer;


    // Constructeur
        Vue() {
        init();

        aControleur = new Controleur(this);     // Création du controleur (Controller du MVC)

        // Ajouter le controleur (écouteur) aux composants
        ajouter.addActionListener(aControleur);
        modifier.addActionListener(aControleur);
        supprimer.addActionListener(aControleur);
        afficher.addActionListener(aControleur);
        fermer.addActionListener(aControleur);
        rechercher.addActionListener(aControleur);
        northButtton1.addActionListener(aControleur);
        northButtton2.addActionListener(aControleur);
        northButtton3.addActionListener(aControleur);
        northButtton4.addActionListener(aControleur);
        northButtton5.addActionListener(aControleur);
    }

    // Créer les composants et les ajouter au conteneur
    private void init() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Clinique vétérinaire- Soins pour Tous(SPT)");

        newJPanels();
        newJTable();
        newJButtons();
        newJLabels();
        champTexte = new JTextField(20);
        groupeBouton = groupeBouton();  //new JRadioButtons

        //////les paneaux///////
        add(haut, BorderLayout.NORTH);
        add(milieuContainer,BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);


        /////panneau du haut///////
        haut.setLayout(new GridLayout(3, 2, 0, 5 ));
        haut.setBorder(BorderFactory.createTitledBorder("Type de recherche"));
        identifiant.setText("Identifiant");
        prioriteEq.setText("= à la priorité");
        allPatients.setText("Tous les patients");
        prioriteGt.setText("> à la priorité");
        prioriteLt.setText("< à la priorité");
        haut.add(northButtton1);
        haut.add(identifiant);
        haut.add(northButtton2);
        haut.add(prioriteLt);
        haut.add(northButtton3);
        haut.add(prioriteEq);
        haut.add(northButtton4);
        haut.add(prioriteGt);
        haut.add(northButtton5);
        haut.add(allPatients);

        //panneau du milieu
        milieuContainer.setLayout(new BorderLayout());
        milieuContainer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        milieuContainer.add(emptyPanel, BorderLayout.NORTH);
        milieuContainer.add(milieu2, BorderLayout.SOUTH);

                 //la barre de recherche
            emptyPanel.add(milieu);
            emptyPanel.setBorder(BorderFactory.createTitledBorder(""));
            milieu.setLayout(new FlowLayout(FlowLayout.CENTER));
            milieu.setBorder(BorderFactory.createEmptyBorder(50,5,50,5));
            rechercher.setText("Rechercher");
            milieu.add(champTexte);
            milieu.add(rechercher);

                     //le tableau
            milieu2.setLayout(new BorderLayout());
            milieu2.add(scrollPane,BorderLayout.CENTER);
            milieu2.setBorder(BorderFactory.createEmptyBorder(5,3,50,3));
            milieu2.setVisible(false);

        //paneau du bas
        bas.setLayout(new FlowLayout(FlowLayout.TRAILING));
        bas.setBorder(new EmptyBorder(10,10,60,10));
        ajouter.setText("Ajouter");
        modifier.setText("Modifier");
        modifier.setEnabled(false);
        supprimer.setText("Supprimer");
        supprimer.setEnabled(false);
        afficher.setText("Afficher");
        afficher.setEnabled(false);
        fermer.setText("Fermer");
        bas.add(ajouter);
        bas.add(modifier);
        bas.add(supprimer);
        bas.add(afficher);
        bas.add(fermer);

        //setting du JFrame
        setSize(800, 525);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    private void newJPanels(){
        haut = new JPanel();
        milieuContainer = new JPanel();
        milieu = new JPanel();
        emptyPanel = new JPanel();
        milieu2 = new JPanel();
        bas = new JPanel();
    }

    private void newJTable(){
        String columnNames[]= {"Identifiant","Nom","Priorité" ,"Date/Heure d'arrivée","Nom et Prénom du propriétaire"};
        tableModel = new DefaultTableModel(columnNames,3){
            @Override
            public boolean isCellEditable(int row, int column) {return false;}  //toutes les cellules sont non-éditables
        };
        tablePatient = new JTable(tableModel);
        scrollPane = new JScrollPane(tablePatient, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tablePatient.setPreferredScrollableViewportSize(tablePatient.getPreferredSize()); //affiche correctement le tableau
        tablePatient.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
    }
    private void newJButtons(){
        ajouter = new JButton();
        modifier = new JButton();
        supprimer = new JButton();
        afficher = new JButton();
        fermer = new JButton();
        rechercher = new JButton();
    }

    private void newJLabels(){
        identifiant = new JLabel();
        prioriteEq = new JLabel();
        allPatients = new JLabel();
        prioriteGt = new JLabel();
        prioriteLt = new JLabel();
    }

    private ButtonGroup groupeBouton(){
        ButtonGroup groupe = new ButtonGroup(); // Ajout des radio boutons au groupe pour permettre un choix exclusif.
        northButtton1 = new JRadioButton();
        northButtton1.setSelected(true);
        northButtton2 = new JRadioButton();
        northButtton3 = new JRadioButton();
        northButtton4 = new JRadioButton();
        northButtton5 = new JRadioButton();
        groupe.add(northButtton1);
        groupe.add(northButtton2);
        groupe.add(northButtton3);
        groupe.add(northButtton4);
        groupe.add(northButtton5);

        return groupe;
    }
    /**
     * @return the FermerButton
     */
    public JButton getFermerButton() {
        return fermer;
    }
    /**
     * @return the FermerButton
     */
    public ButtonGroup getGroupeButton() {
        return groupeBouton;
    }
    /**
     * @return the FermerButton
     */
    public JRadioButton getNorthButton4() {return northButtton4;}
    /**
     * @return the FermerButton
     */
    public JRadioButton getNorthButton3() {
        return northButtton3;
    }
    /**
     * @return the FermerButton
     */
    public JRadioButton getNorthButton2() {
        return northButtton2;
    }
    /**
     * @return the FermerButton
     */
    public JRadioButton getNorthButton5() {
        return northButtton5;
    }
    /**
     * @return the FermerButton
     */
    public JRadioButton getNorthButton1() {
        return northButtton1;
    }

    /**
     * @return the AjouterButton
     */
    public JButton getAjouterButton() {
        return ajouter;
    }

    /**
     * @return the ModifierButton
     */
    public JButton getModifierButton() {
        return modifier;
    }
    /**
     * @return the supprimerButton
     */
    public JButton getSupprimerButton() {
        return supprimer;
    }
    /**
     * @return the afficherButton
     */
    public JButton getAfficherButton() {
        return afficher;
    }
    /**
     * @return the afficherButton
     */
    public JButton getRechercherButton() {
        return rechercher;
    }
    /**
     * @return the afficherButton
     */
    public JTextField getChampTexte() {return champTexte;}

    /**
     * @return the afficherButton
     */
    public JPanel getMilieu2() {return milieu2;}

    /**
     * @return the afficherButton
     */
    public JScrollPane getScrollPane() {return scrollPane;}
    /**
     * @return the afficherButton
     */
    public JTable getTablePatient() {return tablePatient;}
    /**
     * @return the afficherButton
     */
    public DefaultTableModel getTableModel() {return tableModel;}


    public Controleur getaControleur() {
        return aControleur;
    }

    // Le main pour démarrer l'application
    public static void main(String[] args) {

        Vue laVue = new Vue();
        laVue.setVisible(true);

    }

}
