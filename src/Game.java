import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
public class Game extends JFrame{
	public int click;
	
		// Starting a game
		Game(){
			this.setTitle("Jeu d'échecs");
			this.setSize(1000,1000);
			this.setLocationRelativeTo(null);
			Echiquier E = new Echiquier();
			//Setting first placement
			pawn B_P1 = new pawn("black",0,6,E);
            pawn B_P2 = new pawn("black",1,6,E);
            pawn B_P3 = new pawn("black",2,6,E);
            pawn B_P4 = new pawn("black",3,6,E);
            pawn B_P5 = new pawn("black",4,6,E);
            pawn B_P6 = new pawn("black",5,6,E);
            pawn B_P7 = new pawn("black",6,6,E);
            pawn B_P8 = new pawn("black",7,6,E);
            pawn W_P1 = new pawn("white",0,1,E);
            pawn W_P2 = new pawn("white",1,1,E);
            pawn W_P3 = new pawn("white",2,1,E);
            pawn W_P4 = new pawn("white",3,1,E);
            pawn W_P5 = new pawn("white",4,1,E);
            pawn W_P6 = new pawn("white",5,1,E);
            pawn W_P7 = new pawn("white",6,1,E);
            pawn W_P8 = new pawn("white",7,1,E);
            
			knight B_K1 = new knight("black",1,7,E);
            knight B_K2 = new knight("black",6,7,E);
            knight W_K1 = new knight("white",1,0,E);
            knight W_K2 = new knight("white",6,0,E);
            bishop B_B1 = new bishop("black",2,7,E);
            bishop B_B2 = new bishop("black",5,7,E);
            bishop W_B1 = new bishop("white",2,0,E);
            bishop W_B2 = new bishop("white",5,0,E);
            king B_King = new king("black",4,7,E);
            king W_King = new king("white",4,0,E);
            
            queen B_Q = new queen("black",3,7,E);
            queen W_Q = new queen("white",3,0,E);
            rook B_R1 = new rook("black",7,7,E);
            rook B_R2 = new rook("black",0,7,E);
            rook W_R1 = new rook("white",7,0,E);
            rook W_R2 = new rook("white",0,0,E);
         // Setting black pieces
         			E.getCases()[0][7].setIcon(B_R1.getIcon());// Rook
         			E.getCases()[1][7].setIcon(B_K1.getIcon());// Knight
         			E.getCases()[2][7].setIcon(B_B1.getIcon());// Bishop
         			E.getCases()[3][7].setIcon(B_Q.getIcon());// queen
         			E.getCases()[4][7].setIcon(B_King.getIcon());// king
         			E.getCases()[5][7].setIcon(B_B2.getIcon());// bishop
         			E.getCases()[6][7].setIcon(B_K2.getIcon());// knight
         			E.getCases()[7][7].setIcon(B_R2.getIcon());// rook
         			E.getCases()[0][6].setIcon(B_P1.getIcon());// pawn
         			E.getCases()[1][6].setIcon(B_P2.getIcon());// pawn
         			E.getCases()[2][6].setIcon(B_P3.getIcon());// pawn
         			E.getCases()[3][6].setIcon(B_P4.getIcon());// pawn
         			E.getCases()[4][6].setIcon(B_P5.getIcon());// pawn
         			E.getCases()[5][6].setIcon(B_P6.getIcon());// pawn
         			E.getCases()[6][6].setIcon(B_P7.getIcon());// pawn
         			E.getCases()[7][6].setIcon(B_P8.getIcon());// pawn
         			
         			// Setting white pieces
         			E.getCases()[0][0].setIcon(W_R1.getIcon());// rook
         			E.getCases()[1][0].setIcon(W_K1.getIcon());// knight
         			E.getCases()[2][0].setIcon(W_B1.getIcon());// bishop
         			E.getCases()[3][0].setIcon(W_Q.getIcon());// king
         			E.getCases()[4][0].setIcon(W_King.getIcon());// queen
         			E.getCases()[5][0].setIcon(W_B2.getIcon());// bishop
         			E.getCases()[6][0].setIcon(W_K2.getIcon());// knight
         			E.getCases()[7][0].setIcon(W_R2.getIcon());// rook
         			E.getCases()[0][1].setIcon(W_P1.getIcon());// pawn
         			E.getCases()[1][1].setIcon(W_P2.getIcon());// pawn
         			E.getCases()[2][1].setIcon(W_P3.getIcon());// pawn
         			E.getCases()[3][1].setIcon(W_P4.getIcon());// pawn
         			E.getCases()[4][1].setIcon(W_P5.getIcon());// pawn
         			E.getCases()[5][1].setIcon(W_P6.getIcon());// pawn
         			E.getCases()[6][1].setIcon(W_P7.getIcon());// pawn
         			E.getCases()[7][1].setIcon(W_P8.getIcon());// pawn
         			
         			// Setting pieces
         			E.getCases()[0][7].setP(B_R1);
         			E.getCases()[1][7].setP(B_K1);// Knight
         			E.getCases()[2][7].setP(B_B1);// Bishop
         			E.getCases()[3][7].setP(B_Q);// queen
         			E.getCases()[4][7].setP(B_King);// king
         			E.getCases()[5][7].setP(B_B2);// bishop
         			E.getCases()[6][7].setP(B_K2);// knight
         			E.getCases()[7][7].setP(B_R2);// rook
         			E.getCases()[0][6].setP(B_P1);// pawn
         			E.getCases()[1][6].setP(B_P2);// pawn
         			E.getCases()[2][6].setP(B_P3);// pawn
         			E.getCases()[3][6].setP(B_P4);// pawn
         			E.getCases()[4][6].setP(B_P5);// pawn
         			E.getCases()[5][6].setP(B_P6);// pawn
         			E.getCases()[6][6].setP(B_P7);// pawn
         			E.getCases()[7][6].setP(B_P8);// pawn
         			
         			
         			E.getCases()[0][0].setP(W_R1);// rook
         			E.getCases()[1][0].setP(W_K1);// knight
         			E.getCases()[2][0].setP(W_B1);// bishop
         			E.getCases()[3][0].setP(W_Q);// king
         			E.getCases()[4][0].setP(W_King);// queen
         			E.getCases()[5][0].setP(W_B2);// bishop
         			E.getCases()[6][0].setP(W_K2);// knight
         			E.getCases()[7][0].setP(W_R2);// rook
         			E.getCases()[0][1].setP(W_P1);// pawn
         			E.getCases()[1][1].setP(W_P2);// pawn
         			E.getCases()[2][1].setP(W_P3);// pawn
         			E.getCases()[3][1].setP(W_P4);// pawn
         			E.getCases()[4][1].setP(W_P5);// pawn
         			E.getCases()[5][1].setP(W_P6);// pawn
         			E.getCases()[6][1].setP(W_P7);// pawn
         			E.getCases()[7][1].setP(W_P8);// pawn
			this.setContentPane(E);
			this.setVisible(true);
		}
}
