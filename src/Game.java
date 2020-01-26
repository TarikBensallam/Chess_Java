import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
public class Game extends JFrame{
	public int click;
	public Player PlayerW;
	public Player PlayerB;
	
		// Starting a game
		Game(){
			
			piece Wpieces[]= new piece[16];
			piece Bpieces[]= new piece[16];
			
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
         			Bpieces[0]=B_R1;
         			E.getCases()[1][7].setP(B_K1);// Knight
         			Bpieces[1]=B_K1;
         			E.getCases()[2][7].setP(B_B1);// Bishop
         			Bpieces[2]=B_B1;
         			E.getCases()[3][7].setP(B_Q);// queen
         			Bpieces[3]=B_Q;
         			E.getCases()[4][7].setP(B_King);// king
         			Bpieces[4]=B_King;
         			E.getCases()[5][7].setP(B_B2);// bishop
         			Bpieces[5]=B_B2;
         			E.getCases()[6][7].setP(B_K2);// knight
         			Bpieces[6]=B_K2;
         			E.getCases()[7][7].setP(B_R2);// rook
         			Bpieces[7]=B_R2;
         			E.getCases()[0][6].setP(B_P1);// pawn
         			Bpieces[8]=B_P1;
         			E.getCases()[1][6].setP(B_P2);// pawn
         			Bpieces[9]=B_P2;
         			E.getCases()[2][6].setP(B_P3);// pawn
         			Bpieces[10]=B_P3;
         			E.getCases()[3][6].setP(B_P4);// pawn
         			Bpieces[11]=B_P4;
         			E.getCases()[4][6].setP(B_P5);// pawn
         			Bpieces[12]=B_P5;
         			E.getCases()[5][6].setP(B_P6);// pawn
         			Bpieces[13]=B_P6;
         			E.getCases()[6][6].setP(B_P7);// pawn
         			Bpieces[14]=B_P7;
         			E.getCases()[7][6].setP(B_P8);// pawn
         			Bpieces[15]=B_P1;
         			
         			
         			E.getCases()[0][0].setP(W_R1);// rook
         			Wpieces[0]=W_R1;
         			E.getCases()[1][0].setP(W_K1);// knight
         			Wpieces[1]=W_K1;
         			E.getCases()[2][0].setP(W_B1);// bishop
         			Wpieces[2]=W_B1;
         			E.getCases()[3][0].setP(W_Q);// king
         			Wpieces[3]=W_Q;
         			E.getCases()[4][0].setP(W_King);// queen
         			Wpieces[4]=W_King;
         			E.getCases()[5][0].setP(W_B2);// bishop
         			Wpieces[5]=W_B2;
         			E.getCases()[6][0].setP(W_K2);// knight
         			Wpieces[6]=W_K2;
         			E.getCases()[7][0].setP(W_R2);// rook
         			Wpieces[7]=W_R2;
         			E.getCases()[0][1].setP(W_P1);// pawn
         			Wpieces[8]=W_P1;
         			E.getCases()[1][1].setP(W_P2);// pawn
         			Wpieces[9]=W_P2;
         			E.getCases()[2][1].setP(W_P3);// pawn
         			Wpieces[10]=W_P3;
         			E.getCases()[3][1].setP(W_P4);// pawn
         			Wpieces[11]=W_P4;
         			E.getCases()[4][1].setP(W_P5);// pawn
         			Wpieces[12]=W_P5;
         			E.getCases()[5][1].setP(W_P6);// pawn
         			Wpieces[13]=W_P6;
         			E.getCases()[6][1].setP(W_P7);// pawn
         			Wpieces[14]=W_P7;
         			E.getCases()[7][1].setP(W_P8);// pawn
         			Wpieces[15]=W_P1;
         			
         			this.PlayerW=new Player("white",W_King,Wpieces);
        			this.PlayerB=new Player("black",B_King,Bpieces);
        		
        			PlayerW.setMyMove(true);
        			PlayerB.setMyMove(false);
			this.setContentPane(E);
			this.setVisible(true);
			
			
			
		}
		
		// setter player
	
}
