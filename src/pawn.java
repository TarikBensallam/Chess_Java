import java.awt.Image;

import javax.swing.ImageIcon;

public class pawn extends piece{

	public pawn(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_pawn.png");
		}
		else {
			I = new ImageIcon("black_pawn.png");
		}
		Image img = I.getImage(); 
		Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		this.icon = new ImageIcon(newimg);
	}

	@Override
	public boolean canMoveTo(Case Location) {
		int X,Y;
		X=Location.getX();
		Y=Location.getY();
		System.out.println(X+","+Y);
		//Pawn of white color
		if(this.couleur=="white") {
		// case of going straight up by two squares 
		if(Location.from_C.getY()==1 && Location.from_C.getY() == Y-2 && Location.from_C.getX() == X && !this.getCase().getE().getCases()[X][Y-1].isOccupied()  && !this.getCase().getE().getCases()[X][Y].isOccupied())
			return true;
		// case of going straight up by one square
		if(Location.from_C.getY() == Y-1 && Location.from_C.getX() == X  && !this.getCase().getE().getCases()[X][Y].isOccupied()) {
			return true;
		} 
		else {
			if(Location.from_C.getY() == Y-1 && Location.from_C.getX() == X+1 && this.getCase().getE().getCases()[X][Y].isOccupied() && this.getCase().getE().getCases()[X][Y].p.couleur=="black") return true;
			if(Location.from_C.getY() == Y-1 && Location.from_C.getX() == X-1 && this.getCase().getE().getCases()[X][Y].isOccupied() && this.getCase().getE().getCases()[X][Y].p.couleur=="black") return true;
			return false;
		}
		}
		//Pawn of black color
		else {
			//going straight up by two squares
			if(Location.from_C.getY()==6 && Location.from_C.getY() == Y+2 && Location.from_C.getX() == X && !this.getCase().getE().getCases()[X+1][Y+1].isOccupied()  && !this.getCase().getE().getCases()[X][Y].isOccupied())
				return true;
			//going straight up by one square 
			if(Location.from_C.getY() == Y+1 && Location.from_C.getX() == X  && !this.getCase().getE().getCases()[X][Y].isOccupied()) {
				return true;
			}
			else {
				if(Location.from_C.getY() == Y+1 && Location.from_C.getX() == X-1 && this.getCase().getE().getCases()[X][Y].isOccupied() && this.getCase().getE().getCases()[X][Y].p.couleur=="white") return true;
				if(Location.from_C.getY() == Y+1 && Location.from_C.getX() == X+1 && this.getCase().getE().getCases()[X][Y].isOccupied() && this.getCase().getE().getCases()[X][Y].p.couleur=="white") return true;
				return false;
			}
			}
		}

		}

