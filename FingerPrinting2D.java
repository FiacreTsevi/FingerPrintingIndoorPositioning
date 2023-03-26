/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ubfc.embedded.fingerprinting2d;

/**
 *
 * @author Fiacre Tsevi & Rifat Jian Lia
 */
public class FingerPrinting2D {

    public static void main(String[] args) {
        
        // Cells creation
        Cellule Tf[][] = new Cellule[3][3];
        
        // Initialisation des cellules
        Tf[0][0] = new Cellule(new int[]{-38, -27, -54, -13});
        Tf[0][1] = new Cellule(new int[]{-74, -62, -48, -32});
        Tf[0][2] = new Cellule(new int[]{-13, -28, -12, -40});
        Tf[1][0] = new Cellule(new int[]{-34, -27, -38, -41});
        Tf[1][1] = new Cellule(new int[]{-64, -48, -72, -35});
        Tf[1][2] = new Cellule(new int[]{-45, -37, -20, -15});
        Tf[2][0] = new Cellule(new int[]{-17, -50, -44, -33});
        Tf[2][1] = new Cellule(new int[]{-27, -28, -32, -45});
        Tf[2][2] = new Cellule(new int[]{-30, -20, -60, -40});
        
        // Receiver (Terminal Mobile)
        Cellule TM = new Cellule(new int[]{-26, -42, -13, -46});
        
        int kcases[][] = new int[4][2]; // Tableau qui stocke les coords (4) de chaque proche de TM
        boolean presence = false; // Boolean pour vérifier que les kcases ne contiennent pas déjà une certaine case
        
        // Récupération du max
        int somme = Tf[0][0].somme();
        int max[] = new int[2];
        
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                int Tf_sum = Tf[i][j].somme();
                if(Tf_sum > somme) {
                    max[0] = i;
                    max[1] = j;
                    somme = Tf_sum;
                }
            }
        }
        // System.out.println(somme);
        // Le max est indispensable pour l'initialisation de chaque
        // kcase[k] (de plus dans notre exemple la case (0, 0) est la plus petite
        
        // Recherche des k cases les + proches (et on récupère 2 coords)  
        for(int k=0; k < 4; k++) {
            kcases[k][0] = max[0];
            kcases[k][1] = max[1];
            
            for(int i=0; i < 3; i++) {
                for(int j=0; j < 3; j++) {
                    for(int l=0; l < k; l++) {
                        if(kcases[l][0] == i && kcases[l][1] == j)
                            presence = true;
                    }
                    
                    if(!presence) {
                        if(Math.abs(Tf[i][j].somme() - TM.somme()) < Math.abs(Tf[kcases[k][0]][kcases[k][1]].somme() - TM.somme())) {
                            kcases[k][0] = i;
                            kcases[k][1] = j;
                        }
                    }
                    presence = false;
                }
            }
        }
        
        int moy_x, moy_y;
        moy_x = moy_y = 0;
        
        for(int element[]: kcases) {
            element[0] = element[0]*4 + 2;
            element[1] = element[1]*4 + 2;
            
            moy_x += element[1];
            moy_y += element[0];
            
            System.out.println("K proches: " + element[1] + ", " + element[0]);
        }
        
        System.out.println("Receiver Mobile Coords (x,y): (" + moy_x/4 + ", " + moy_y/4 + ")");
    }
    
}
