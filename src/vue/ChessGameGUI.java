/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controler.ChessGameControlers;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author hugo.talbot
 */
public class ChessGameGUI extends JFrame{

     String jeu_echec;
     ChessGameControlers chessGameControler;
     Dimension dim;
    public ChessGameGUI(String jeu_déchec, ChessGameControlers chessGameControler, Dimension dim) {
    this.chessGameControler=chessGameControler;
    this.jeu_echec=jeu_déchec;
    this.dim=dim;
    
    }
    
}
