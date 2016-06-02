/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import model.Couleur;
import model.PieceIHMs;
import model.Pieces;
import model.observable.ChessGame;
import tools.ChessImageProvider;
import tools.ChessPieceImage;

/**
 *
 * @author hugo.talbot
 */
public class ChessGameGUI extends JFrame implements Observer {

    String jeu_echec;
    ChessGameControlers chessGameControler;
    Dimension dim;

    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private JLabel chessPiece;
    private int xAdjustment;
    private int yAdjustment;

    public ChessGameGUI(String jeu_déchec, ChessGameControlers chessGameControler, Dimension dim) {
        super();

        this.chessGameControler = chessGameControler;
        this.jeu_echec = jeu_déchec;
        this.dim = dim;

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        //layeredPane.addMouseListener(this);
        //layeredPane.addMouseMotionListener(this);
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(this.dim);
        chessBoard.setBounds(0, 0, this.dim.width, this.dim.height);
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            square.setPreferredSize(new Dimension(10, 10));
            square.setSize(10, 10);
            chessBoard.add(square);
            int row = (i / 8) % 2;
            if (row == 0) {
                square.setBackground(i % 2 == 0 ? Color.black : Color.white);
            } else {
                square.setBackground(i % 2 == 0 ? Color.white : Color.black);
            }
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        //chessBoard.removeAll();
        List<PieceIHMs> list = (List<PieceIHMs>) arg;
        ListIterator<PieceIHMs> itr = list.listIterator();
        while (itr.hasNext()) {
            PieceIHMs p = itr.next();
            JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(p.toString(), p.getCouleur())));
            System.out.println(ChessImageProvider.getImageFile(p.toString(), p.getCouleur()));
            JPanel panel = (JPanel) chessBoard.getComponent(p.getX() + p.getY() * 8);
            panel.add(piece);
        }
        chessBoard.repaint();

    }

}
