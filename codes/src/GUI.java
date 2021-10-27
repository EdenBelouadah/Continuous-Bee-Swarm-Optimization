/**
 * @author: ZOUGGARI Feriel & BELOUADAH Eden
 */

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class GUI extends javax.swing.JFrame 
{    
    String fctProb;
    Algorithme algorithme;
    ArrayList<Double> fitnessSRefs;
    ArrayList<Double> indiceSRefs;
    JLabel placeholderLabel;

    public GUI()
    {
        Locale.setDefault(Locale.Category.DISPLAY, Locale.FRENCH);
        Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);
        initComponents();
        CBnomFonction.setSelectedItem(CBnomFonction.getItemAt(0));
        TFmaxIter.setValue(50000);
        TFsearchIter.setValue(10);
        TFmeanIter.setValue(100);
        TFK.setValue(5);
        TFnbrBee.setValue(4);
        TFmaxChances.setValue(3);
        TFflip.setValue(2);
        TFxi.setValue(0.0001);
        TFepsilon.setValue(0.0001);
        TFStagnation.setValue(5000);
        graphePanel.setLayout(new BorderLayout());
        placeholderLabel = new JLabel();
        placeholderLabel.addComponentListener(new ComponentListener() 
        {
            @Override
            public void componentResized(ComponentEvent componentEvent) 
            {
                placeholderLabel.setIcon(getScaledImageLabel("graphe_non_dispo.png", placeholderLabel.getWidth(), placeholderLabel.getHeight()));
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) 
            {
                // Nothing to do
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) 
            {
                // Nothing to do
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) 
            {
                // Nothing to do
            }
        });
        dessinerGraphNonDispo();
    }
   
    
    void dessinerGraphNonDispo()
    {
        graphePanel.removeAll();
        graphePanel.setLayout(new BorderLayout());
        graphePanel.add(placeholderLabel, BorderLayout.CENTER);
        graphePanel.validate();
        placeholderLabel.setIcon(getScaledImageLabel("graphe_non_dispo.png", placeholderLabel.getWidth(), placeholderLabel.getHeight()));
    }
    
    private ImageIcon getScaledImageLabel(String imageName, int width, int height) 
    {
       if(width==0 || height==0)
       {
           System.exit(1);
           return null;
       }
        ImageIcon picture = new ImageIcon(getClass().getResource("/" + imageName));
        return new ImageIcon(picture.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
    
    public void setMaxIter(int iter) 
    {
        maxIterProgressBar.setMaximum(iter);
    }

    public void setMeanIter(int iter) 
    {
        meanIterProgressBar.setMaximum(iter);
    }

    //Mise à jour de la barre de progression 
    public void updateMaxIterProgress(int iter) 
    {
        maxIterProgressBar.setValue(iter);
        maxIterProgressBar.setString(String.format("Itération %d sur %d", iter, maxIterProgressBar.getMaximum()));
    }

    //Mise à jour de la barre de progression
    public void updateMeanIterProgress(int iter) 
    {
        meanIterProgressBar.setValue(iter);
        meanIterProgressBar.setString(String.format("Execution %d sur %d", iter, meanIterProgressBar.getMaximum()));
    }
    
    public void RemplirFitnessSRefs(double valeur, double i)
    {
        fitnessSRefs.add(valeur);
        indiceSRefs.add(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBLnomFonction = new javax.swing.JLabel();
        CBnomFonction = new javax.swing.JComboBox<>();
        LBLparamFonction = new javax.swing.JLabel();
        LBLparamAlgo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAoptLocaux = new javax.swing.JTextArea();
        LBLoptLocaux = new javax.swing.JLabel();
        BoutonDemarrer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAResultat = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        TFBinf = new javax.swing.JSpinner();
        TFBsup = new javax.swing.JSpinner();
        TFH0 = new javax.swing.JSpinner();
        TFHk = new javax.swing.JSpinner();
        TFmaxIter = new javax.swing.JSpinner();
        TFnbrBee = new javax.swing.JSpinner();
        TFK = new javax.swing.JSpinner();
        TFxi = new javax.swing.JSpinner();
        TFepsilon = new javax.swing.JSpinner();
        TFOpt = new javax.swing.JTextField();
        TFN = new javax.swing.JTextField();
        maxIterProgressBar = new javax.swing.JProgressBar();
        meanIterProgressBar = new javax.swing.JProgressBar();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BoutonAnnuler = new javax.swing.JButton();
        graphePanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        TFmeanIter = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        TFsearchIter = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        TFStagnation = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        TFmaxChances = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        TFflip = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Continuous Bee Swarm Optimization");
        setMinimumSize(new java.awt.Dimension(890, 550));

        LBLnomFonction.setText("Fonction de test");

        CBnomFonction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diagonal Plane (DP)", "Sphere (SP)", "B2", "Branin RCOS (RC)", "Easom (ES)", "De Joung (DJ)", "RosenBrock2 (R2)", "Hartmann3 (H3,4)", "Hartmann6 (H6,4)", "Shekel5 (S4,5)", "Shekel7 (S4,7)", "Shekel10 (S4,10)", "Zakharov2 (Z2)", "Zakharov5 (Z5)" }));
        CBnomFonction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBnomFonctionActionPerformed(evt);
            }
        });

        LBLparamFonction.setText("Paramètres de la fonction");

        LBLparamAlgo.setText("Paramètres de l'algorithme");

        jLabel1.setText("Optimum");
        jLabel1.setToolTipText("La valeur de la fonction pour l'optimum global");

        jLabel2.setText("N");
        jLabel2.setToolTipText("Le nombre de variables de la fonction");

        jLabel3.setText("Binf");
        jLabel3.setToolTipText("Borne inférieure du domaine de définition de la fonction");

        jLabel4.setText("Bsup");
        jLabel4.setToolTipText("Borne supérieure du domaine de définition de la fonction");

        jLabel5.setText("Epsilon");
        jLabel5.setToolTipText("Erreur tolérée entre l'optimum et la solution trouvée");

        jLabel6.setText("H0");
        jLabel6.setToolTipText("Longueur du demi côté du premier hyper-carré du voisinage");

        jLabel7.setText("Hk");
        jLabel7.setToolTipText("Longueur du demi côté du dernier hyper-carré du voisinage");

        jLabel8.setText("Xi");
        jLabel8.setToolTipText("La vitesse de convergence de la solution noyau");

        jLabel10.setText("Mean iter");
        jLabel10.setToolTipText("Le nombre d'exécutions indépendantes");

        jLabel11.setText("Nbr bees");
        jLabel11.setToolTipText("Le nombre d'abeilles");

        jLabel14.setText("Max chances");
        jLabel14.setToolTipText("Le nombre maximum de chances pour améliorer le sommet de référence");

        TAoptLocaux.setEditable(false);
        TAoptLocaux.setColumns(20);
        TAoptLocaux.setRows(5);
        jScrollPane1.setViewportView(TAoptLocaux);

        LBLoptLocaux.setText("Optimums locaux et globaux");

        BoutonDemarrer.setText("Démarrer l'exécution");
        BoutonDemarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonDemarrerActionPerformed(evt);
            }
        });

        TAResultat.setEditable(false);
        TAResultat.setColumns(20);
        TAResultat.setRows(5);
        jScrollPane2.setViewportView(TAResultat);

        jLabel16.setText("Résultats");

        TFBinf.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        TFBsup.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        TFH0.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.1d));
        TFH0.setEditor(new javax.swing.JSpinner.NumberEditor(TFH0, "0.###"));

        TFHk.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.1d));
        TFHk.setEditor(new javax.swing.JSpinner.NumberEditor(TFHk, "0.###"));

        TFmaxIter.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1000));

        TFxi.setModel(new javax.swing.SpinnerNumberModel(1.0E-4d, 0.0d, null, 0.0d));
        TFxi.setEditor(new javax.swing.JSpinner.NumberEditor(TFxi, "##.####"));

        TFepsilon.setModel(new javax.swing.SpinnerNumberModel(1.0E-4d, 0.0d, null, 1.0E-4d));
        TFepsilon.setEditor(new javax.swing.JSpinner.NumberEditor(TFepsilon, "##.#####"));

        TFOpt.setEditable(false);

        TFN.setEditable(false);

        maxIterProgressBar.setMinimum(1);
        maxIterProgressBar.setStringPainted(true);

        meanIterProgressBar.setMinimum(1);
        meanIterProgressBar.setStringPainted(true);

        jLabel18.setText("Executions");

        jLabel17.setText("Itérations");

        BoutonAnnuler.setText("Annuler l'exécution");
        BoutonAnnuler.setEnabled(false);
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
            }
        });

        graphePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphePanel.setMaximumSize(new java.awt.Dimension(32767, 328));
        graphePanel.setMinimumSize(new java.awt.Dimension(402, 0));

        javax.swing.GroupLayout graphePanelLayout = new javax.swing.GroupLayout(graphePanel);
        graphePanel.setLayout(graphePanelLayout);
        graphePanelLayout.setHorizontalGroup(
            graphePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        graphePanelLayout.setVerticalGroup(
            graphePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        jLabel19.setText("Stagnation");
        jLabel19.setToolTipText("Le nombre d'itérations avant de détecter la stagnation");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Continuous Bee Swarm Optimization");
        jLabel20.setToolTipText("Ce projet a été développé par ZOUGGARI Feriel et BELOUADAH Eden");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bee.png"))); // NOI18N

        TFmeanIter.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 10));

        jLabel9.setText("Max iter");
        jLabel9.setToolTipText("Le nombre maximum des itérations dans une exécution");

        jLabel15.setText("Search iter");
        jLabel15.setToolTipText("Le nombre de recherches locales que fait une abeille à chaque itération");

        TFStagnation.setModel(new javax.swing.SpinnerNumberModel(1000, 1, 10000, 1000));

        jLabel12.setText("K");
        jLabel12.setToolTipText("Le nombre de voisins d'une solution");

        jLabel13.setText("Flip");
        jLabel13.setToolTipText("1/Flip est le nombre de cases à modifier du sommet de référence");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LBLoptLocaux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BoutonDemarrer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoutonAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(meanIterProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxIterProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLnomFonction)
                                    .addComponent(CBnomFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLparamFonction)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(45, 45, 45)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(34, 34, 34)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(21, 21, 21)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(TFBsup)
                                            .addComponent(TFBinf, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TFN, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TFOpt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TFH0)
                                            .addComponent(TFHk, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel22)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFxi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LBLparamAlgo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFmaxIter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFepsilon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFmeanIter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFK, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFnbrBee, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(TFsearchIter)
                                            .addComponent(TFmaxChances, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(TFStagnation)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFflip, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graphePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBLnomFonction)
                            .addComponent(LBLparamFonction)
                            .addComponent(LBLparamAlgo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBnomFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(TFOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFmeanIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(TFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TFmaxIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(TFBinf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFsearchIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(TFBsup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFStagnation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(TFH0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFmaxChances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(TFHk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addComponent(TFnbrBee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(TFK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(TFflip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TFxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFepsilon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(graphePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBLoptLocaux)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonDemarrer)
                    .addComponent(BoutonAnnuler)
                    .addComponent(meanIterProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(maxIterProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Initialisation des paramètres des fonctions à travers le combo box
    private void CBnomFonctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBnomFonctionActionPerformed
       
       String nomFonction;
       nomFonction=(String)CBnomFonction.getSelectedItem();
       switch (nomFonction)
       {
           case"Diagonal Plane (DP)":
           { 
              fctProb="DiagonalPlane";
              TFOpt.setText("0.5");
              TFN.setText("10");
              TFBinf.setValue(0.5);
              TFBsup.setValue(1.5);
              TFH0.setValue(0.0000000000000000000001);//10^-22   
              TFHk.setValue(0.000000000000000000007);//7*10^-21   
              TAoptLocaux.setText("Optimum global f(0.5,...,0.5)=0.5");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.5);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(1.5);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(0.5);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(1.5);
              break;
           }
           case"Sphere (SP)":
           {
              fctProb="Sphere";
              TFOpt.setText("0.0");
              TFN.setText("10");
              TFBinf.setValue(-3.0);
              TFBsup.setValue(7.0);
              TFH0.setValue(0.00001);
              TFHk.setValue(0.1);
              TAoptLocaux.setText("Optimum global f(0,...,0)=0");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-3.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(7.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-3.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(7.);
              break;
           }
           case"B2":
           {
              fctProb="B2";
              TFOpt.setText("0.0");
              TFN.setText("2");
              TFBinf.setValue(-100.0);
              TFBsup.setValue(100.0);
              TFH0.setValue(0.003);
              TFHk.setValue(2.0);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(0,0)=0\nPlusieurs optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-100.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(100.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-100.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(100.);
              break;
           }
           case"Branin RCOS (RC)":
           {
              fctProb="Branin";
              TFOpt.setText("0.3978873");
              TFN.setText("2");
              TFBinf.setValue(-5.0);
              TFBsup.setValue(15.0);
              TFH0.setValue(0.0006);
              TFHk.setValue(0.8);
              TAoptLocaux.setText("Optimums globaux\n f(-3.14,12.275)=0.39\n f(3.14,2.275)=0.39\n f(9.42478,2.475)]=0.39");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(15.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(15.);
              break;
           }
           case"Easom (ES)":
           {
              fctProb="Easom";
              TFOpt.setText("-1");
              TFN.setText("2");
              TFBinf.setValue(-100.0);
              TFBsup.setValue(100.0);
              TFH0.setValue(0.0008);
              TFHk.setValue(2.0);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(3.14,3.14)=-1\nPlusieurs optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-100.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(100.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-100.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(100.);
              break;
           }
           case"De Joung (DJ)":
           {
              fctProb="DeJoung";
              TFOpt.setText("0.0");
              TFN.setText("3");
              TFBinf.setValue(-5.12);
              TFBsup.setValue(5.12);
              TFH0.setValue(0.0003);
              TFHk.setValue(0.4);
              TAoptLocaux.setText("Optimum global f(0,0,0)=0");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-5.12);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(5.12);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-5.12);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(5.12);
              break;
           }
           case"RosenBrock2 (R2)":
           {
              fctProb="RosenBrock";
              TFOpt.setText("0.0");
              TFN.setText("2");
              TFBinf.setValue(-5.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.01);
              TFHk.setValue(1.0);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(1,1)=0\nPlusieurs optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-5.12);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(5.12);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-5.12);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(5.12);
              break;
           }
           case"Hartmann3 (H3,4)":
           {
              fctProb="Hartmann3";
              TFOpt.setText("-3.862782");
              TFN.setText("3");
              TFBinf.setValue(0.0);
              TFBsup.setValue(1.0);
              TFH0.setValue(0.00006);
              TFHk.setValue(0.08);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(0.1140,0.556,0.852)=-3.86\n4 Optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(1.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(0.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(1.);
              break;
           }
           case"Hartmann6 (H6,4)":
           {
              fctProb="Hartmann6";
              TFOpt.setText("-3.32236");
              TFN.setText("6");
              TFBinf.setValue(0.0);
              TFBsup.setValue(1.0);
              TFH0.setValue(0.001);
              TFHk.setValue(0.02);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(0.2016690,0.150011,0.476874,0.275332,0.311652,0.65731)=-3.32\n4 Optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(1.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(0.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(1.);
              break;
           }
           case"Shekel5 (S4,5)":
           {
              fctProb="Shekel4_5";
              TFOpt.setText("-10.1499");
              TFN.setText("4");
              TFBinf.setValue(0.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.00006);
              TFHk.setValue(0.02);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(4,4,4,4)=-10.14\n5 Optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(10.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(10.);
              break;
           }
           case"Shekel7 (S4,7)":
           {
              fctProb="Shekel4_7";
              TFOpt.setText("-10.3999");
              TFN.setText("4");
              TFBinf.setValue(0.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.00006);
              TFHk.setValue(0.02);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(4,4,4,4)=-10.39\n7 Optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(10.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(10.);
              break;
           }
           case"Shekel10 (S4,10)":
           {
              fctProb="Shekel4_10";
              TFOpt.setText("-10.5319");
              TFN.setText("4");
              TFBinf.setValue(0.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.00006);
              TFHk.setValue(0.02);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(4,4,4,4)=-10.53\n10 Optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(10.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(0.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(10.);
              break;
           }
           case"Zakharov2 (Z2)":
           {
              fctProb="Zakharov";
              TFOpt.setText("0.0");
              TFN.setText("2");
              TFBinf.setValue(-5.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.01);
              TFHk.setValue(0.2);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(0,0)=0\nPlusieurs optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(10.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(10.);
              break;
           }
           case"Zakharov5 (Z5)":
           {
              fctProb="Zakharov";
              TFOpt.setText("0.0");
              TFN.setText("5");
              TFBinf.setValue(-5.0);
              TFBsup.setValue(10.0);
              TFH0.setValue(0.002);
              TFHk.setValue(0.2);
              TAoptLocaux.setText("Fonction multi-modale\nOptimum global f(0,0,0,0,0)=0\nPlusieurs optimums locaux");
              ((SpinnerNumberModel)TFBinf.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBinf.getModel()).setMaximum(10.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMinimum(-5.);
              ((SpinnerNumberModel)TFBsup.getModel()).setMaximum(10.);
              break;
           } 
       }
    }//GEN-LAST:event_CBnomFonctionActionPerformed

    double[] default_bInf_bSup()
    {
       String nomFonction;
       nomFonction=(String)CBnomFonction.getSelectedItem();      
       double Binf=-1,Bsup=-1;
       switch (nomFonction)
       {
           case"Diagonal Plane (DP)":
           { 
              Binf=0.5;
              Bsup=1.5;
              break;
           }
           case"Sphere (SP)":
           {
              Binf=-3.0;
              Bsup=7.0;
              break;
           }
           case"Goldstein and Price (GP)":
           {
              Binf=-2.0;
              Bsup=2.0;
              break;
           }
           case"B2":
           {
              Binf=-100.0;
              Bsup=100.0;
              break;
           }
           case"Branin RCOS (RC)":
           {
              Binf=-5.0;
              Bsup=15.0;
              break;
           }
           case"Easom (ES)":
           {
              Binf=-100.0;
              Bsup=100.0;
              break;
           }
           case"Griewank (GRn)":
           {
              Binf=-5.12;
              Bsup=5.12;
              break;
           }
           case"De Joung (DJ)":
           {
              Binf=-5.12;
              Bsup=5.12;
              break;
           }
           case"RosenBrock2 (R2)":
           {
              Binf=-5.0;
              Bsup=10.0;
              break;
           }
           case"RosenBrock5 (R5)":
           {
              Binf=-5.0;
              Bsup=10.0;
              break;
           }
           case"Hartmann3 (H3,4)":
           {
              Binf=0.0;
              Bsup=1.0;
              break;
           }
           case"Hartmann6 (H6,4)":
           {
              Binf=0.0;
              Bsup=1.0;
              break;
           }
           case"Shekel5 (S4,5)":
           {
              Binf=0.0;
              Bsup=10.0;
              break;
           }
           case"Shekel7 (S4,7)":
           {
              Binf=0.0;
              Bsup=10.0;
              break;
           }
           case"Shekel10 (S4,10)":
           {
              Binf=0.0;
              Bsup=10.0;
              break;
           }
           case"Zakharov2 (Z2)":
           {
              Binf=-5.0;
              Bsup=10.0;
              break;
           }
           case"Zakharov5 (Z5)":
           {
              Binf=-5.0;
              Bsup=10.0;
              break;
           } 
       }
       return new double[]{Binf,Bsup};
    }
    //Affichage d'un texte dans l'IHM
    void AfficherTexte(String text)
    {
        TAResultat.append("\n"+text);
    }
    
    //Affichage de la solution finale
    void AfficherSolution(Solution S)
    {
    	if(Algorithme.succRuns==0) //Aucune exécution n'est réussie
        {
            TAResultat.append("impossible de trouver l'optimum de la fonction");
            TAResultat.append("\n---------------------------\n");
            TAResultat.append("La solution actuelle est: f(");
        }
        else //Au moins une exécution réussie
    	{
    	    TAResultat.append("L'optimum de la fonction est atteint");
            TAResultat.append("\n---------------------------\n");
            TAResultat.append("Le nombre moyen des évaluations de la fonction= "+new DecimalFormat("0.##").format(Algorithme.nbrMoyEvalFct)+"\n");       
            TAResultat.append("Le nombre moyen des itérations= "+Algorithme.nbrMoyIter);
            TAResultat.append("\n---------------------------\n");
            TAResultat.append("La solution est: f(");
        }
        for(int i=0;i<S.N-1;i++)
            TAResultat.append(new DecimalFormat("0.##").format(S.X[i])+"; ");
        TAResultat.append(new DecimalFormat("0.##").format(S.X[S.N-1])+")="+new DecimalFormat("0.##").format(S.fitness));    
        TAResultat.append("\n---------------------------\n");
        TAResultat.append("Le taux des exécutions réussies="+Algorithme.succRuns*100/Algorithme.meanIter+"%\n");
        TAResultat.append("Le taux de stagnation="+Algorithme.tauxStag*100/Algorithme.meanIter+"%\n");
        TAResultat.append("Le taux d'atteinte de maxIter="+Algorithme.tauxMaxIter*100/Algorithme.meanIter+"%\n");
    }
    
    //Mise à jour de la barre de progression
    void AfficherInformations(Information info)
    {
    	this.updateMaxIterProgress(info.maxIter);
    	this.updateMeanIterProgress(info.meanIter);
    }
    
    void ActiverBoutonDemarrer()
    {
        BoutonDemarrer.setEnabled(true);
    }
    
    void DesactiverBoutonDemarrer()
    {
        BoutonDemarrer.setEnabled(false);
    }
    
    void ActiverBoutonAnnuler()
    {
        BoutonAnnuler.setEnabled(true);
    }
    
    void DesactiverBoutonAnnuler()
    {
        BoutonAnnuler.setEnabled(false);
    }
    
    //Arreter la barre de progréssion
    void ArreterProgressBar()
    {
        maxIterProgressBar.setValue(0);
        maxIterProgressBar.setString(String.format("Itération %d sur %d", 0, maxIterProgressBar.getMaximum()));
        meanIterProgressBar.setValue(0);
        meanIterProgressBar.setString(String.format("Execution %d sur %d", 0, meanIterProgressBar.getMaximum()));
    }
    

    //Démarrage du traitement
    private void BoutonDemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonDemarrerActionPerformed
        double[] minMax = default_bInf_bSup();
        double binf = (double) TFBinf.getValue();
        double bsup = (double) TFBsup.getValue();
        double hk = (double) TFHk.getValue();
        double h0 = (double) TFH0.getValue();
        if (binf < minMax[0])
            JOptionPane.showMessageDialog(this, "La borne inférieure est invalide!", "Erreur", JOptionPane.WARNING_MESSAGE); // ou JOptionPane.ERROR_MESSAGE si tu veux une icon rouge contenant un 'x'
        else if (bsup > minMax[1])
            JOptionPane.showMessageDialog(this, "La borne supérieure est invalide!", "Erreur", JOptionPane.WARNING_MESSAGE);
        else if (binf >= bsup)
            JOptionPane.showMessageDialog(this, "La borne supérieure doit être plus grande que la borne inférieure!", "Erreur", JOptionPane.WARNING_MESSAGE);
        else if (hk <= 0 || hk >= (bsup - binf) / 2)
            JOptionPane.showMessageDialog(this, "Hk n'est pas dans l'intervalle ]0, (bsup-binf)/2[ !", "Erreur", JOptionPane.WARNING_MESSAGE);
        else if (h0 <= 0 || h0 >= hk/Math.pow(2, ((int) TFK.getValue())-1))
            JOptionPane.showMessageDialog(this, "H0 n'est pas dans l'intervalle ]0, Hk/2^(k-1)[ !", "Erreur", JOptionPane.WARNING_MESSAGE);
        else 
        {
            dessinerGraphNonDispo();
            //Création des tableaux du graphe
            ActiverBoutonAnnuler();
            DesactiverBoutonDemarrer();
            this.setMaxIter((Integer) TFmaxIter.getValue());
            this.setMeanIter((Integer) TFmeanIter.getValue());
            TAResultat.setText("");
            //Création du thread du traitement
            algorithme=new Algorithme(this,
            fctProb,
            Double.parseDouble(TFOpt.getText()),
            Integer.parseInt(TFN.getText()),
            (Double) TFBinf.getValue(),
            (Double) TFBsup.getValue(),
            (Double) TFepsilon.getValue(),
            (Double) TFH0.getValue(),
            (Double) TFHk.getValue(),
            (Double) TFxi.getValue(),
            (Integer) TFnbrBee.getValue(),
            (Integer) TFK.getValue(),
            (Integer) TFmaxIter.getValue(),
            (Integer) TFflip.getValue(),
            (Integer) TFmaxChances.getValue(),
            (Integer) TFsearchIter.getValue(),
            (Integer) TFmeanIter.getValue(),
            (Integer) TFStagnation.getValue()        
            );
            //Exécution du thread 
            algorithme.execute();
        }
    }//GEN-LAST:event_BoutonDemarrerActionPerformed

    //Annuler le traitement, donc arreter le thread
    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        algorithme.cancel(true);
        DesactiverBoutonAnnuler();
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    //Dessiner le graphe sur l'IHM
    void DessinerGraphe()
    {
        DefaultXYDataset dataset = new DefaultXYDataset();
        String attribute1Name = "Iteration";
        String attribute2Name = "Fitness";
        String title = (String) CBnomFonction.getSelectedItem();  
        double[] indices =  Stream.of(indiceSRefs.toArray(new Double[]{})).mapToDouble(Double::doubleValue).toArray();
        double[] fitnesses = Stream.of(fitnessSRefs.toArray(new Double[]{})).mapToDouble(Double::doubleValue).toArray();
        dataset.addSeries(title, new double[][]{indices, fitnesses});
        JFreeChart chart = ChartFactory.createXYLineChart("Evolution du sommet de référence", attribute1Name, attribute2Name, (XYDataset) dataset);
        final ChartPanel myChart = new ChartPanel(chart, true);
        graphePanel.removeAll();
        graphePanel.setLayout(new java.awt.BorderLayout());
        graphePanel.add(myChart, BorderLayout.CENTER);
        graphePanel.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.JButton BoutonDemarrer;
    private javax.swing.JComboBox<String> CBnomFonction;
    private javax.swing.JLabel LBLnomFonction;
    private javax.swing.JLabel LBLoptLocaux;
    private javax.swing.JLabel LBLparamAlgo;
    private javax.swing.JLabel LBLparamFonction;
    private javax.swing.JTextArea TAResultat;
    private javax.swing.JTextArea TAoptLocaux;
    private javax.swing.JSpinner TFBinf;
    private javax.swing.JSpinner TFBsup;
    private javax.swing.JSpinner TFH0;
    private javax.swing.JSpinner TFHk;
    private javax.swing.JSpinner TFK;
    private javax.swing.JTextField TFN;
    private javax.swing.JTextField TFOpt;
    private javax.swing.JSpinner TFStagnation;
    private javax.swing.JSpinner TFepsilon;
    private javax.swing.JSpinner TFflip;
    private javax.swing.JSpinner TFmaxChances;
    private javax.swing.JSpinner TFmaxIter;
    private javax.swing.JSpinner TFmeanIter;
    private javax.swing.JSpinner TFnbrBee;
    private javax.swing.JSpinner TFsearchIter;
    private javax.swing.JSpinner TFxi;
    private javax.swing.JPanel graphePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JProgressBar maxIterProgressBar;
    private javax.swing.JProgressBar meanIterProgressBar;
    // End of variables declaration//GEN-END:variables
}