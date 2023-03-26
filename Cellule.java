/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ubfc.embedded.fingerprinting2d;

/**
 *
 * @author Fiacre Tsevi & Rifat Jian Lia
 */
public class Cellule {
    
    int[] tpr;
    
    public Cellule(int[] tpr) {
        this.tpr = tpr;
    }
    
    public int somme() {
        int s = 0;
        for(int i = 0; i < tpr.length; i++) {
            s += tpr[i];
        }
        return s;
    }
    
}
