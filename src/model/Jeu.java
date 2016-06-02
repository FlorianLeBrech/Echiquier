/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import tools.ChessPiecesFactory;

/**
 *
 * @author hugo.talbot
 */
public class Jeu implements Game {

    private Couleur couleur;
    private List<Pieces> pieces;
    boolean castlingPossible;

    public Jeu(Couleur couleur) {
        this.pieces = ChessPiecesFactory.newPieces(couleur);
        this.castlingPossible = false;
        this.couleur = couleur;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu(Couleur.BLANC);
        System.out.println(jeu);
    }

    @Override
    public String toString() {
        return "Jeu{" + "pieces=" + pieces + '}';
    }

    private Pieces findPiece(int x, int y) { // a changer 
        ListIterator<Pieces> itr = pieces.listIterator();
        while (itr.hasNext()) {
            Pieces p = itr.next();
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        /*
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
                return pieces.get(i);
            }
        }*/
        return null;
    }

    public boolean setCastlingPossible() {
        return castlingPossible;

    }

    public boolean getCastlingPossible() {
        return castlingPossible;
    }

    @Override
    public boolean isPieceHere(int x, int y) { //a changer 
        if (this.findPiece(x, y) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public List<Pieces> getPieces() {
        return pieces;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        Pieces p;
        if ((p = findPiece(xInit, yInit)) != null) {
            return p.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
        }
        return false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {//comme au dessus
        findPiece(xInit, yInit).move(xFinal, yFinal);
        return false;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PieceIHMs> getPiecesIHM() {
        PieceIHMs newPieceIHM = null;
        List<PieceIHMs> list = new LinkedList<PieceIHMs>();

        for (Pieces piece : pieces) {
            //si la pièce est toujours en jeu 
            if (piece.getX() != -1) {
                newPieceIHM = new PieceIHM(piece);
                list.add(newPieceIHM);
            }
        }
        return list;
    }

    public Couleur getPieceColor(int x, int y) {
        return this.findPiece(x, y).getCouleur();

    }

}
