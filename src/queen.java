import java.awt.Image;

import javax.swing.ImageIcon;

public class queen extends piece{
	public queen(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_queen.png");
		}
		else {
			I = new ImageIcon("black_queen.png");
		}
		Image img = I.getImage(); 
		Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		this.icon = new ImageIcon(newimg);
	}

	
	public boolean canMoveTo(Case Location_dest) {
		if(Location_dest.from_C.p==null)  // this is needed for the checkmate function , if not we have a problem with a null pointer
			return false;
		
		// Case can give us the x,y
		Case Case1= Location_dest.from_C;
				int x = Location_dest.from_C.getX();
				int y= Location_dest.from_C.getY();
				// When the destination has the same piece color as this piece
				if(Location_dest.p!= null && this.couleur==Location_dest.p.couleur) return false;
				// a queen can move vertically 
				if(x==Location_dest.getX())
				{	System.out.println("yes i got in here for x==location");
					// we still need to check if that horizontal line is clear or not 
					if(!this.getCase().getE().isClearX(Case1, Location_dest) || this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest))
						{
						System.out.println("I'm in QueenCanMoveTo and i'm returning false 1");

						return false;}
					
					return true;
				}
				else if(y==Location_dest.getY()) {
					System.out.println("yes i got in here for y==location");
					//need to check if the vertical line is clear or not
					if(!this.getCase().getE().isClearY(Case1, Location_dest) || this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest))
					{
						System.out.println("I'm in QueenCanMoveTo and i'm returning false 2");

						return false;}
					return true;
				}
				// a queen can move in a diagonal
				else if(Math.abs(Location_dest.getX()-x)==Math.abs(Location_dest.getY()-y)) {
					// need to check if that diagonal is clear or not
					System.out.println("yes i am diagonaaaale lol");
					if(!this.getCase().getE().isClearDiagonale(Case1, Location_dest) || this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest))
					{
						System.out.println("I'm in QueenCanMoveTo and i'm returning false 3");

						return false;}
					System.out.println("I'm in QueenCanMoveTo "+Location_dest.getX()+" "+x +" "+Location_dest.getY()+" "+y);
					System.out.println("I'm in QueenCanMoveTo and i'm returning true 1");
					return true;
				}
				System.out.println("I'm in QueenCanMoveTo "+Location_dest.getX()+" "+x +" "+Location_dest.getY()+" "+y);

				System.out.println("I'm in QueenCanMoveTo and i'm returning false 4");
				return false;
			}
}
