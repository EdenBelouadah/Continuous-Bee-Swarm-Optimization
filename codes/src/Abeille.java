/**
 * @author: ZOUGGARI Feriel & BELOUADAH Eden
 */

public class Abeille 
{
    static Optimum RechercheLocaleVoisinageEtoile(Solution S)
    {
        Optimum optimum=new Optimum(S);
        double evalMin;
        int iMin=0;
        int K=Algorithme.K;
        Solution[] voisins= new Solution[K];
        for(int iter=0;iter<Algorithme.searchIter;iter++)
        {
            evalMin=Double.MAX_VALUE;
            for(int i=0; i<K; i++)
            {
                //Générer un voisin dans la couronne Ci
                voisins[i]=S.GenererVoisin(Algorithme.H[i], Algorithme.H[i+1]);
                if(Math.abs(voisins[i].fitness - Algorithme.fOpt)<=Algorithme.epsilon)
                {
                    //Si le voisin est l'optimum, alors le retourner et sortir
                    optimum.aEteTrouve=true;
                    optimum.solution=voisins[i];
                    Algorithme.nbrEvalFct++;
                    return optimum;
                }
                if(voisins[i].fitness<evalMin)
                {
                    //Mise à jour du meilleur voisin
                    evalMin=voisins[i].fitness;
                    iMin=i;
                }
            }
            if(voisins[iMin].fitness < S.fitness)
            {
                //Si le meilleur voisin est meileur que S, alors le retourner 
                Algorithme.nbrEvalFct++;
                optimum.solution=voisins[iMin];
                return optimum;
            }
        }
        //Sinon retourner S
        return optimum;
    }

    static Solution RechercheLocaleVoisinageAnneau(Solution S, boolean B)
    {
        double evalMin=Double.MAX_VALUE;
        int iMin=0;
        int K=Algorithme.K;
        int searchIter=Algorithme.searchIter;
        Solution[] voisins= new Solution[K*searchIter];
        int j=0;
        for(int i=0; i<K*searchIter; i++)
        {
            if(j==5)
                j=0;
            voisins[i]=S.GenererVoisin(Algorithme.H[j], Algorithme.H[j+1]);
            if(Math.abs(voisins[i].fitness - Algorithme.fOpt)<=Algorithme.epsilon)
            {
                B=true;
                Algorithme.nbrEvalFct++;
                return voisins[i];
            }
            if(voisins[i].fitness<evalMin)
            {
                evalMin=voisins[i].fitness;
                iMin=i;
            }
            j++;
        }
        Algorithme.nbrEvalFct++;
        return voisins[iMin];    
    }
    
    static Solution RechercheLocaleVoisinagePoint(Solution S, boolean B)
    {
        int K=Algorithme.K;
        Solution[] voisins= new Solution[K];
        for(int iter=0;iter<Algorithme.searchIter;iter++)
        {
            for(int i=0; i<K; i++)
            {
                voisins[i]=S.GenererVoisin(Algorithme.H[i], Algorithme.H[i+1]);
                if(Math.abs(voisins[i].fitness - Algorithme.fOpt)<=Algorithme.epsilon)
                {
                    B=true;
                    Algorithme.nbrEvalFct++;
                    return voisins[i];
                }
                if(voisins[i].fitness<S.fitness)
                {
                    Algorithme.nbrEvalFct++;
                    return voisins[i];
                }
            }
        }
        return S;
    }

    
    
}