import java.awt.Image;

import javax.swing.ImageIcon;

public class king extends piece{
	private boolean MovedBefore=false;
	public king(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_king.png");
		}
		else {
			I = new ImageIcon("black_king.png");
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
		System.out.println("bbbbbbbbbbb "+X+","+Y);
		//King of white color
		if(this.couleur=="white") {
		if((Location.from_C.getY() == Y-1 || Location.from_C.getY() == Y+1 || Location.from_C.getY() == Y) && (Location.from_C.getX() == X || Location.from_C.getX() == X-1 || Location.from_C.getX() ==X+1) && (!this.getCase().getE().getCases()[X][Y].isOccupied() || (this.getCase().getE().getCases()[X][Y].p.couleur=="black"))) {
			
			if(this.getCase().getE().notMovingInCheck(Location,this.couleur)==false || this.getCase().getE().PuttingKingInCheck(Location.from_C,Location)==true )
				return false;
			this.setMoved();
			System.out.println("ayayayayayayaya"+Location.from_C.getX()+" "+ Location.from_C.getY());
			return true;
		}
		// we're going to add the castling 
		//castling on the right for white king 
		if((X==6) && Y==0 && Location.from_C.getX()==4 && Location.from_C.getY()==0 && (getMoved()==false)) { 
			// we've checked if the king has moved , now we need to check if the rook has moved
			// we check if the king is currently in check || squares he's going to go through are attacked 
			if(this.isInCheck(Location.from_C) || this.isInCheck(new Case(5,0,this.getCase().getE())) || this.isInCheck(new Case(6,0,this.getCase().getE())))
				return false;
			
			if(this.getCase().getE().CanCastle(Location)) {
				// Setting the rook in it's square
				Location.E.cases[5][0].p=Location.E.cases[7][0].p;
				Location.E.cases[5][0].p.setLocation(Location.E.cases[5][0]);
				Location.E.cases[5][0].setIcon(Location.E.cases[7][0].getIcon());
				// Setting the place of the rook empty
				Location.E.cases[7][0].p=null;
				Location.E.cases[7][0].setIcon(null);
				
			
				return true;
			}
			return false;
		}
		//Castling on the left side for white king 
		if((X==2) && Y==0 && Location.from_C.getX()==4 && Location.from_C.getY()==0 && (getMoved()==false)) { 
			// we've checked if the king has moved , now we need to check if the rook has moved
			// we check if the king is currently in check || squares he's going to go through are attacked 
			if(this.isInCheck(Location.from_C) || this.isInCheck(new Case(3,0,this.getCase().getE())) || this.isInCheck(new Case(2,0,this.getCase().getE())))
				return false;
			
			if(this.getCase().getE().CanCastle(Location)) {
				// Setting the rook in it's square
				Location.E.cases[3][0].p=Location.E.cases[0][0].p;
				Location.E.cases[3][0].p.setLocation(Location.E.cases[5][0]);
				Location.E.cases[3][0].setIcon(Location.E.cases[7][0].getIcon());
				// Setting the place of the rook empty
				Location.E.cases[0][0].p=null;
				Location.E.cases[0][0].setIcon(null);
				
				return true;
			}
			return false;
		}
		return false;
		}
		//King of black color
		else {
			if((Location.from_C.getY() == Y-1 || Location.from_C.getY() == Y+1 || Location.from_C.getY() == Y) && (Location.from_C.getX() == X || Location.from_C.getX() == X-1 || Location.from_C.getX() ==X+1)  && (!this.getCase().getE().getCases()[X][Y].isOccupied() || (this.getCase().getE().getCases()[X][Y].p.couleur=="white"))) {
				if(this.getCase().getE().notMovingInCheck(Location,this.couleur)==false || this.getCase().getE().PuttingKingInCheck(Location.from_C,Location)==true )
					return false;
				return true;
			}
			// we add castling on the right for black king 
			if((X==6) && Y==7 && Location.from_C.getX()==4 && Location.from_C.getY()==7 && (getMoved()==false)) { 
				// we've checked if the king has moved , now we need to check if the rook has moved
				// we check if the king is currently in check || squares he's going to go through are attacked 
				if(this.isInCheck(Location.from_C) || this.isInCheck(new Case(5,7,this.getCase().getE())) || this.isInCheck(new Case(6,7,this.getCase().getE())))
					return false;
				
				if(this.getCase().getE().CanCastle(Location)) {
					// we need to move the rook from it s square to it's supposed square
					// Setting the rook in it's square
					Location.E.cases[5][7].p=Location.E.cases[7][7].p;
					Location.E.cases[5][7].p.setLocation(Location.E.cases[5][7]);
					Location.E.cases[5][7].setIcon(Location.E.cases[7][7].getIcon());
					// Setting the place of the rook empty
					Location.E.cases[7][7].p=null;
					Location.E.cases[7][7].setIcon(null);
					return true;
				}
				return false;
			}
			//Castling on the left side for white king 
			if((X==2) && Y==7 && Location.from_C.getX()==4 && Location.from_C.getY()==7 && (getMoved()==false)) { 
				// we've checked if the king has moved , now we need to check if the rook has moved
				// we check if the king is currently in check || squares he's going to go through are attacked 
				if(this.isInCheck(Location.from_C) || this.isInCheck(new Case(3,7,this.getCase().getE())) || this.isInCheck(new Case(2,7,this.getCase().getE())))
					return false;
				
				if(this.getCase().getE().CanCastle(Location)) {
					// we need to move the rook from it s square to it's supposed square
					// Setting the rook in it's square
					Location.E.cases[3][7].p=Location.E.cases[0][7].p;
					Location.E.cases[3][7].p.setLocation(Location.E.cases[5][7]);
					Location.E.cases[3][7].setIcon(Location.E.cases[7][7].getIcon());
					// Setting the place of the rook empty
					Location.E.cases[0][7].p=null;
					Location.E.cases[0][7].setIcon(null);
					return true;
				}
				return false;
			}
			return false;
			}
		
	}
	public boolean isInCheck(Case Location) {
		if(!this.getCase().getE().notMovingInCheck(Location,this.couleur))
			return true;
		return false;
	}
	public void setMoved() {
		this.MovedBefore=true;
	}
	public boolean getMoved() {
		return this.MovedBefore;
	}
}
