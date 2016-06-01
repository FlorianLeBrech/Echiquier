/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tools.ChessPiecesFactory;

/**
 *
 * @author hugo.talbot
 */
public class Jeu implements Game {
    Couleur couleur;
    List<Pieces> pieces;
    public Jeu(Couleur couleur) {
        this.pieces=ChessPiecesFactory.newPieces(couleur);
    }
    
    public static void main (String[] args){
        Jeu jeu = new Jeu(Couleur.BLANC);
        System.out.println(jeu);
    }

    @Override
    public String toString() {
        return "Jeu{" + "pieces=" + pieces + '}';
    }
     
    @Override
    public boolean isPieceHere(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
