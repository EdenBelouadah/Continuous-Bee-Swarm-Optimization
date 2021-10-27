/**
 * @author: ZOUGGARI Feriel & BELOUADAH Eden
 */

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

class Algorithme extends SwingWorker<Solution, Information> 
{
    //Paramètres de l'algorithme
    long temps_debut;
    long temps_fin;
    long temps_ecoule;	
    private GUI gui;
    static String fctProb;
    static double fOpt;
    int N;
    double borneInf;
    double borneSup;
    static double epsilon;
    static double h0;
    static double hk;
    double xi;
    int nbrAbeilles;
    static int K; 
    static int maxIter;
    int flip;
    int maxChances;
    int nbrChances;
    static int searchIter;
    static int meanIter;
    static LinkedHashSet<Solution> tabou;
    Solution danse [];
    Solution espaceDeRecherche [];
    static int nbrEvalFct; 
    static int succRuns=0;
    static int tauxStag=0;
    static int tauxMaxIter=0;
    static int nbrMoyEvalFct=0;
    static int nbrMoyIter=0;
    static int stagnation;
    static int iter=1;
    static double tpsExeMoyen;
    static double [] H;
    
    //Constructeur du thread
    public Algorithme
        (GUI gui,
        String fctProb,
        double fOpt,
        int N,
        double borneInf,
        double borneSup,
        double epsilon,
        double h0,
        double hk,
        double xi,
        int nbrAbeilles,
        int K,
        int maxIter,
        int flip,
        int maxChances,
        int searchIter,
        int meanIter,
        int stagnation
        )
    {
        this.gui=gui;
        this.fctProb=fctProb;
        this.fOpt=fOpt;
        this.N=N;
        this.borneInf=borneInf;
        this.borneSup=borneSup;
        this.epsilon=epsilon;
        this.h0=h0;
        this.hk=hk; //this.hk=2.2; 
        this.xi=xi;
        this.nbrAbeilles=nbrAbeilles;
        this.K=K;
        this.maxIter=maxIter;
        this.flip=flip;
        this.maxChances=maxChances;
        this.nbrChances=nbrChances;
        this.searchIter=searchIter;
        this.meanIter=meanIter;
        this.stagnation=stagnation;
        System.out.println("hk= "+this.hk);
        System.out.println("h0= "+this.h0);
        System.out.println("BInf= "+this.borneInf);
        System.out.println("BSup= "+this.borneSup);
    }
    //Méthode qui traite les informations que le thread veut afficher 
    @Override
    protected void process(List<Information> arg0) 
    {
        Information info;
        if(!this.isCancelled())
            info= arg0.get(arg0.size()-1);
        else
            info=new Information(0,0) ;
        gui.AfficherInformations(info);	
    }

    //Méthode qui génère un nombre aléatoire selon la loi gaussiènne
    private  double GaussAleatoire(double moyenne, double variance)
    {
        Random R = new Random();
        double aleatoire=moyenne + R.nextGaussian() * variance;
        if(aleatoire<borneInf)
            return borneInf;
        if(aleatoire>borneSup)
            return borneSup;
        return aleatoire;
    }

    //Trier les solutions de la table danse selon leur qualité 
    void TrierTableDanseQualite()
    {
        Solution Z;
        for(int i=0;i<danse.length;i++)
        {
            for(int j=i+1; j<danse.length;j++)
            {
                if (danse[i].fitness>danse[j].fitness)
                {
                    Z=danse[i];
                    danse[i]=danse[j];
                    danse[j]=Z;
                }
                else if (danse[i].fitness==danse[j].fitness)
                {
                    if (danse[j].CalculerDiversite() > danse[i].CalculerDiversite())
                    {
                        Z=danse[i];
                        danse[i]=danse[j];
                        danse[j]=Z;
                    }
                }
            }
        }
    }
    
    //Trier les solutions de la table danse selon leur diversité
    void TrierTableDanseDiversite()
    {
        Solution Z;
        for(int i=0;i<danse.length;i++)
        {
            for(int j=i+1; j<danse.length;j++)
            {
                if (danse[j].CalculerDiversite() > danse[i].CalculerDiversite())
                {
                    Z=danse[i];
                    danse[i]=danse[j];
                    danse[j]=Z;
                }
                else if (danse[i].CalculerDiversite() == danse[j].CalculerDiversite())
                {
                    if (danse[i].fitness > danse[j].fitness)
                    {
                        Z=danse[i];
                        danse[i]=danse[j];
                        danse[j]=Z;
                    }
                }
            }
        }
    }

    //Choisir la meilleure solution danse en qualité
    int ChoisirMeilleureSolutionDanse(int taille)
    {
        int iMeilleure=0;
        double fMeilleure=danse[0].fitness;
        for(int i=1;i<taille;i++)
        {
            if(danse[i].fitness<fMeilleure)
            {
                fMeilleure=danse[i].fitness;
                iMeilleure=i;
            }
            else if(danse[i].fitness==fMeilleure)
            {
                if(danse[i].CalculerDiversite()> danse[iMeilleure].CalculerDiversite())
                {
                    fMeilleure=danse[i].fitness;
                    iMeilleure=i;
                }
            }
        }
        return iMeilleure;
    }

    //Méthode principale du thread
    @Override
    protected Solution doInBackground() throws Exception 
    {
        H=new double[K+1];
        H[0]=h0;
        H[K]=hk;
        for(int i=1;i<=K;i++)
        {
            H[K-i+1]=H[K]/Math.pow(2, i-1);
        }
        temps_debut = System.currentTimeMillis();
        succRuns=0;
        tauxStag=0;
        tauxMaxIter=0;
        nbrMoyEvalFct=0;
        nbrMoyIter=0;
        tpsExeMoyen=0;
        Solution solution=new Solution(N,borneInf,borneSup);
        Solution sRef=null;
        Solution precSref=null;
        for(int u=1;u<=meanIter;u++) //Répéter l'algorithme meanIter fois
        {
           gui.fitnessSRefs=new ArrayList<>();
           gui.indiceSRefs=new ArrayList<>();
           nbrChances=maxChances;
           if(gui.algorithme.isCancelled()) break;
           nbrEvalFct=0;
           iter=1;
           int stag=0;
           //Création des structures des données
           danse= new Solution[nbrAbeilles+1];
           espaceDeRecherche= new Solution[nbrAbeilles];
           tabou = new LinkedHashSet<>();
           //Choisir un sommet de référence aléatoire.
           sRef= new Solution(N,borneInf,borneSup);	
           sRef.RemplirSolutionAleatoire();  
           //Tantque la condition d'arret est non vérifiée
           while(Math.abs(sRef.fitness - fOpt)>epsilon && iter<=maxIter)
            {
                if(gui.algorithme.isCancelled()) break;
                publish(new Information(iter, u));
                tabou.add(sRef); //Ajouter sRef à la liste tabou
                precSref=sRef; //Mise à jour du sRef précédant
                if(iter<=3000)
                    //Mise à jour du tableau du graphe
                    gui.RemplirFitnessSRefs(sRef.fitness, iter);
                //Création de l'aspace de recherche
                espaceDeRecherche[0]=sRef;
                int l=0;
                for(int i=1; i<nbrAbeilles;i++)
                {
                    espaceDeRecherche[i]=sRef.GenererNonVoisin();
                    if(i==nbrAbeilles-1)
                    {
                        espaceDeRecherche[i].CalculerFitness(fctProb);
                        break;
                    }
                    else
                    {
                        l=(l+1)%flip;
                        for(int j=l;j<N;j++)
                        {
                            espaceDeRecherche[i].X[j]=sRef.X[j];
                            j++;
                        }
                        espaceDeRecherche[i].CalculerFitness(fctProb);
                    }
                }
                //Recherches locales
                Optimum optimumLocal=null;
                for (int abeille=0; abeille<nbrAbeilles;abeille++)
                {
                    nbrChances=maxChances;
                    optimumLocal=Abeille.RechercheLocaleVoisinageEtoile(espaceDeRecherche[abeille]);
                    if(optimumLocal.aEteTrouve==true)
                    {
                        //Si l'optimum est atteint, alors sortir
                        sRef=optimumLocal.solution;
                        break;
                    }
                    //Insérer les optimums locaux dans la table danse.
                    danse[abeille] = optimumLocal.solution;
                }
                //Choisir la meilleure solution Dance:
                if(optimumLocal.aEteTrouve==true)
                    break;
                //Choisir la meilleure solution danse
                int iMeilleure=ChoisirMeilleureSolutionDanse(nbrAbeilles);
                Solution sMeilleure= danse[iMeilleure];
                //Construction de la solution noyau
                Solution solutionNoyau= new Solution(N,borneInf,borneSup);
                double moyenne, variance;
                for(int i=0;i<N;i++)
                {
                    variance=0;
                    moyenne=sMeilleure.X[i];
                    for(int j=0;j<nbrAbeilles;j++)
                    {
                        variance=variance+ Math.abs(danse[j].X[i]-danse[iMeilleure].X[i]);
                    }
                    variance=xi/(nbrAbeilles-1)*variance;
                    solutionNoyau.X[i]= GaussAleatoire(moyenne,variance);
                }
                solutionNoyau.CalculerFitness(fctProb);
                if(Math.abs(solutionNoyau.fitness - fOpt)<=epsilon)
                {
                    //Si la solution noyau est l'optimum, alors sortir
                    sRef=solutionNoyau;
                    break;
                }
                nbrEvalFct++;
                //Insérer la solution noyau dans la table danse
                danse[nbrAbeilles]=solutionNoyau;
                //Choisir la meilleure soltion danse en qualité
                iMeilleure=ChoisirMeilleureSolutionDanse(nbrAbeilles+1);
                sMeilleure= danse[iMeilleure];
                if (sMeilleure.fitness < sRef.fitness) //La meilleure solution est meilleure que sRef
                {
                    TrierTableDanseQualite();
                    int i=0;
                    while(tabou.contains(sMeilleure) && (i<danse.length))
                    {
                        i=i+1;
                        sMeilleure=danse[i];
                    }
                    if (i==danse.length)
                    {
                        //Choisir sRef aléatoire car toutes les solutions sont taboues.
                        sRef.RemplirSolutionAleatoire();
                    }
                    else
                        sRef=sMeilleure;
                    nbrChances=maxChances;
                }
                else
                {
                    //Décrémenter le nombre de chances
                    nbrChances--;
                    if (nbrChances >0)
                    {
                        TrierTableDanseQualite();
                        int i=0;
                        while(tabou.contains(sMeilleure) && (i<danse.length))
                        {
                            i=i+1;
                            sMeilleure=danse[i];
                        }
                        if (i==danse.length)
                        {
                            //Choisir sRef aléatoire car toutes les solutions sont taboues.
                            sRef.RemplirSolutionAleatoire();
                        }
                        else
                            sRef=sMeilleure;	
                    }
                    else
                    {
                        //Chercher la meilleure solution danse en diversité.
                        TrierTableDanseDiversite();
                        int i=0;
                        while(tabou.contains(sMeilleure) && (i<danse.length))
                        {
                            i=i+1;
                            sMeilleure=danse[i];
                        }
                        if (i==danse.length)
                        {
                            //Choisir sRef aléatoire car toutes les solutions sont taboues.
                            System.out.println("abcd");
                            sRef.RemplirSolutionAleatoire();
                        }
                        else
                            sRef=sMeilleure;
                        nbrChances=maxChances;
                    }
                }
                iter++;   
                if(iter>1)
                {
                    //Vérifier s'il y a eu une stagnation
                    double distance=Math.abs(precSref.fitness-sRef.fitness);
                    if (distance<=epsilon)
                    {
                        stag=stag+1;
                        if(stag>stagnation)
                            break;
                    }
                    else 
                        stag=0;
                }
            }
            if(stag>stagnation)
                tauxStag++;
            else if(iter>maxIter)
                     tauxMaxIter++;
            else
            {
                succRuns++;
                nbrMoyEvalFct+=nbrEvalFct;
                solution=sRef;
                nbrMoyIter+=iter;
            }
       }
       temps_fin = System.currentTimeMillis();
       temps_ecoule = temps_fin - temps_debut;
       tpsExeMoyen=temps_ecoule/meanIter;
       if(succRuns>0)
       {
            //S'il y a au moins une exécution réussie
            nbrMoyEvalFct=nbrMoyEvalFct/succRuns;
            nbrMoyIter=nbrMoyIter/succRuns;
            return solution;
       }
       else 
       {  	
           //Si ausune exécution n'est réussie
           return sRef;
       }
    }

    //Méthode qui s'exécute à la fin du thread
    @Override
    protected void done() 
    {
        if(!gui.algorithme.isCancelled())
        {   
            try 
            {
                Solution S=get(); //Récupérer la meilleure solution
                gui.AfficherSolution(S);
                gui.AfficherTexte("Temps d'exécution moyen= "+tpsExeMoyen+" ms");
                gui.ArreterProgressBar();
                gui.DessinerGraphe();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            catch (ExecutionException e) 
            {
                e.printStackTrace();
            }	  
            catch (CancellationException  e) 
            {
                e.printStackTrace();
            }
            try 
            {
                Clip soundClip = AudioSystem.getClip();
                soundClip.open(AudioSystem.getAudioInputStream(getClass().getResource("completed.wav")));
                soundClip.start();
            } catch (LineUnavailableException e) {
                System.err.println("Impossible d'obtenir la ligne pour jouer un son !");
            } catch (UnsupportedAudioFileException e) {
                System.err.println("Le format du fichier audio n'est pas valide !");
            } catch (IOException e) {
                System.err.println("Impossible de lire le fichier audio !");
            }
        }
        else
        {
            gui.AfficherTexte("Exécution annulée");
        }
        gui.ActiverBoutonDemarrer();
        gui.DesactiverBoutonAnnuler();
    }
}