/**
 * @author: ZOUGGARI Feriel & BELOUADAH Eden 
 */

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;

public class Solution
{
    double X[];
    int N;
    double borneInf;
    double borneSup;
    double fitness;
	
    //Constructeur d'une solution
    Solution (int N, double borneInf, double borneSup)
    {
        this.N=N;
        X= new double[N];
        this.borneInf=borneInf;
        this.borneSup=borneSup;
    }

    @Override
    public int hashCode() 
    {
        return toString().hashCode();
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("|");
        DecimalFormat precisionFormat = new DecimalFormat("0.0000");
        for (double x : X) {
            sb.append(precisionFormat.format(x));
            sb.append("|");
        }
        return sb.toString();
    }
	
    //Remplir une solution aléatoirement
    void RemplirSolutionAleatoire()
    {
        Random R= new Random();
        for(int i=0;i<N;i++)
        {
            X[i]=R.nextDouble()*(borneSup-borneInf)+borneInf;
        }
        this.CalculerFitness(Algorithme.fctProb);
    }
	
    //Générer une solution voisine
    Solution GenererVoisin(double hi, double hiPlus1)
    {
        //System.out.println("hi="+hi);
        //System.out.println("hi+1="+hiPlus1);
        Solution voisin= new Solution(N, borneInf,borneSup);
        Random R= new Random();
        double R1,R2,R3; double r1,r2;
        for(int i=0;i<N;i++)
        {
            if(((this.X[i] - hiPlus1) >= this.borneInf) && ((this.X[i] + hiPlus1) <= this.borneSup))
            {
                //System.out.println("random="+R.nextDouble());
                //System.out.println("xi="+this.X[i]);
                r1=R.nextDouble(); //System.out.println("r1="+r1);
                r2=R.nextDouble();//System.out.println("r2="+r2);
                R1= r1*(hiPlus1-hi)+this.X[i]-hiPlus1;
                R2= r2*(hiPlus1-hi)+this.X[i]+hi;
                //System.out.println("R1="+R1);
                //System.out.println("R2="+R2);
                R3= R.nextDouble();
                if(R3<=0.5)
                    voisin.X[i]=R1;
                else
                    voisin.X[i]=R2;	
                 //System.out.println("voisin "+voisin.X[i]);
            }
            else if(this.X[i] - hiPlus1 >= this.borneInf)
            {
                                //System.out.println("here2");

                 R1= R.nextDouble()*(hiPlus1-hi)+this.X[i]-hiPlus1;
                 voisin.X[i]=R1;
            }
            else
            {
                                //System.out.println("here3");

                R2= R.nextDouble()*(hiPlus1-hi)+this.X[i]+hi;
                voisin.X[i]=R2;
            }       
            
           /* if(voisin.X[i]>this.borneSup)
                voisin.X[i]=this.borneSup;
            else if (voisin.X[i]<this.borneInf)
                voisin.X[i]=this.borneInf;*/
           if(voisin.X[i]>this.borneSup || voisin.X[i]<this.borneInf)
               System.out.println("oui "+voisin.X[i]);
        }
        voisin.CalculerFitness(Algorithme.fctProb);
            //System.out.println("fitness="+voisin.fitness);
        return voisin;	
    }
	
    //Générer une solution non voisine
    Solution GenererNonVoisin()
    {
        Solution nonVoisin= new Solution(N, borneInf,borneSup);
        Random R= new Random();
        double R1,R2,R3;
        for(int i=0;i<N;i++)
        {
            if((this.X[i]+Algorithme.hk<this.borneSup)&&(this.X[i]-Algorithme.hk>this.borneInf))
            {
                R1= R.nextDouble()*(this.X[i]-Algorithme.hk - this.borneInf) + this.borneInf;
                R2= R.nextDouble()*(this.borneSup - this.X[i] - Algorithme.hk) + this.X[i] + Algorithme.hk;
                R3= R.nextDouble();
                if(R3<=0.5)
                    nonVoisin.X[i]=R1;
                else
                    nonVoisin.X[i]=R2;	
            }
            else if(this.X[i]+Algorithme.hk>=this.borneSup)
            {
                R1= R.nextDouble()*(this.X[i]-Algorithme.hk - this.borneInf) + this.borneInf;
                nonVoisin.X[i]=R1;
            }
            else //if(this.X[i]-Algorithme.hk<=this.borneInf)
            {
                R2= R.nextDouble()*(this.borneSup - this.X[i] - Algorithme.hk) + this.X[i] + Algorithme.hk;
                nonVoisin.X[i]=R2;
            }
           if(nonVoisin.X[i]>this.borneSup || nonVoisin.X[i]<this.borneInf)
               System.out.println("non "+nonVoisin.X[i]);
        }
        return nonVoisin;
    }

    //Evaluation d'une solution
    void CalculerFitness(String fctProb)
    {
        double f=-1;
        switch (fctProb)
        {
            case "DiagonalPlane": { f= DiagonalPlane(); break;}
            case "Sphere":{  f=Sphere(); break;}
            case "B2":{  f=B2(); break;}		
            case "Branin": { f=Branin(); break;}
            case "Easom": { f=Easom(); break;}
            case "DeJoung":{  f=DeJoung(); break;}
            case "RosenBrock": { f= RosenBrock(); break;}
            case "Hartmann3": { f= Hartmann3(); break;}
            case "Hartmann6": { f= Hartmann6();break;}
            case "Shekel4_5":{  f= Shekel4_5(); break;}
            case "Shekel4_7":{  f= Shekel4_7(); break;}
            case "Shekel4_10":{  f= Shekel4_10(); break;}
            case "Zakharov":{  f= Zakharov(); break;}
        }
        this.fitness= f;
    }
	
    double DiagonalPlane()
    {
        //System.out.println("solution="+this.toString());
        //System.out.println("n="+N);

        double N=X.length;
        double S=0;
        for (int j=0;j<N;j++)
        {
            S=S+X[j];
        }
        return S/N;   
    }
	
    double Sphere()
    {
        double N=X.length;
        double S=0; 
        for(int j=0; j<N;j++)
        {
            S=S+Math.pow(X[j],2);
        }
        return S;
    }

    double B2()
    {
        return (Math.pow(X[0], 2)+2*Math.pow(X[1], 2)-0.3*Math.cos(3*Math.PI*X[0])-0.4*Math.cos(4*Math.PI*X[1])+0.7);
    }

    double Branin() 
    {
        double pi=Math.PI;
        double Y=0;
        Y=Math.pow((X[1]-(5.0/(4.0*Math.pow(pi,2)))*Math.pow(X[0],2)+5.0*X[0]/pi-6.0),2)+10.0*(1.0-1.0/(8.0*pi))*Math.cos(X[0])+10.0;
        return Y;	
    }

    double Easom()
    {
        return (-Math.cos(X[0])*Math.cos(X[1])*Math.exp(-(Math.pow((X[0]-Math.PI),2)+Math.pow((X[1]-Math.PI), 2))));
    }

    double DeJoung()
    {
        double N=X.length;
        double S=0; 
        for(int j=0; j<N;j++)
        {
            S=S+Math.pow(X[j],2);
        }
        return S;
    }

    double RosenBrock()
    {
        double N=X.length;
        double S=0; 
        for(int j=0; j<N-1;j++)
        {
            S=S+100*Math.pow((Math.pow(X[j],2)-X[j+1]),2)+Math.pow((X[j]-1),2);
        }
        return S;	
    }

    double Hartmann3()
    {
        double [][]A={{3,10,30},
                    {0.1,10,35},
                    {3,10,30},
                    {0.1,10,35}
                   };
        double []C={1,1.2,3,3.2};
        double [][]P={{0.3689,0.1170,0.2673},
                    {0.4699,0.4387,0.7470},
                    {0.1091,0.8732,0.5547},
                    {0.0381,0.5743,0.8828}
                    };
        double S=0;
        for(int i=0; i<4;i++)
        {
            double sm=0;
            for(int j=0; j<3;j++)
            {
                sm=sm+A[i][j]*Math.pow(X[j]-P[i][j],2);
            }
            S=S+C[i]*Math.exp(-sm);
        }
        return -S;
    }

    double Hartmann6()
    {
        double [][]A={{10,3,17,3.5,1.7,8},
                    {0.05,10,17,0.1,8,14},
                    {3,3.5,1.7,10,17,8},
                    {17,8,0.05,10,0.1,14}
                   };

        double []C={1,1.2,3,3.2};

        double [][]P={{0.1312,0.1696,0.5569,0.0124,0.8283,0.5886},
                    {0.2329,0.4135,0.8307,0.3736,0.1004,0.9991},
                    {0.2348,0.1451,0.3522,0.2883,0.3047,0.6650},
                    {0.4047,0.8828,0.8732,0.5743,0.1091,0.0381}
                    };
        double S=0;
        for(int i=0; i<4;i++)
        {
            double sm=0;
            for(int j=0; j<6;j++)
            {
                sm=sm+A[i][j]*Math.pow(X[j]-P[i][j],2);
            }
            S=S+C[i]*Math.exp(-sm);
        }
        return -S;
    }

    double Shekel4_5() 
    {
        double [][]A={{4,4,4,4},
                    {1,1,1,1},
                    {8,8,8,8},
                    {6,6,6,6},
                    {3,7,3,7}};
        double []C={0.1,0.2,0.2,0.4,0.4};
        double S=0;
        for(int j=0; j<5;j++)
        {
            double P=0;
            for(int i=0; i<4;i++)
            {
                P=P+Math.pow((X[i]-A[j][i]),2);
            }
            S=S+1/(P+C[j]);
        }
        return -S;
    }

    double Shekel4_7() 
    {
        double [][]A={{4,4,4,4},
                    {1,1,1,1},
                    {8,8,8,8},
                    {6,6,6,6},
                    {3,7,3,7},
                    {2,9,2,9},
                    {5,5,3,3}};
        double []C={0.1,0.2,0.2,0.4,0.4,0.6,0.3};
        double S=0;
        for(int j=0; j<7;j++)
        {
            double P=0;
            for(int i=0; i<4;i++)
            {
                P=P+Math.pow((X[i]-A[j][i]),2);
            }
            S=S+1/(P+C[j]);
        }
        return -S;
    }

    double Shekel4_10() 
    {
        double [][]A={{4,4,4,4},
                    {1,1,1,1},
                    {8,8,8,8},
                    {6,6,6,6},
                    {3,7,3,7},
                    {2,9,2,9},
                    {5,5,3,3},
                    {8,1,8,1},
                    {6,2,6,2},
                    {7,3.6,7,3.6}};
        double []C={0.1,0.2,0.2,0.4,0.4,0.6,0.3,0.7,0.5,0.5};
        double S=0;
        for(int j=0; j<10;j++)
        {
            double P=0;
            for(int i=0; i<4;i++)
            {
                P=P+Math.pow((X[i]-A[j][i]),2);
            }
            S=S+1/(P+C[j]);
        }
        return -S;
    }	

    double Zakharov()
    {
        double N=X.length;
        double S1=0;
        double S2=0;
        for(int j=0; j<N;j++)
        {
            S1=S1+Math.pow(X[j],2);
            S2=S2+0.5*j*X[j];
        }
        return S1+Math.pow(S2,2)+Math.pow(S2,4);
    }

    //Diversité d'une solution
    double CalculerDiversite()
    {
        double diversite=1000;
        Iterator<Solution> solutions = Algorithme.tabou.iterator(); 
        Solution S;
        while(solutions.hasNext()) 
        {
            S=solutions.next();
            if(diversite>this.Distance(S))
                diversite=this.Distance(S);
        }
        return diversite;
    }

    //Distance entre deux solutions
    double Distance(Solution S2) 
    {
        double max=-1;
        for(int i=0;i<N;i++)
        {
            if (max<Math.abs(this.X[i]-S2.X[i]))
            {
                max=Math.abs(this.X[i]-S2.X[i]);
            }
        }
        return max;
    }
}