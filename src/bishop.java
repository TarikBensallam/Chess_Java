import java.awt.Image;

import javax.swing.ImageIcon;

public class bishop extends piece{
	public bishop(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_bishop.png");
		}
		else {
			I = new ImageIcon("black_bishop.png");
		}
		Image img = I.getImage(); 
		Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		this.icon = new ImageIcon(newimg);
	}

	@Override
	public boolean canMoveTo(Case Location_dest) {
		// TODO Auto-generated method stub
		if(Location_dest.from_C.p==null)  // this is needed for the checkmate function , if not we have a problem with a null pointer
			return false;
		
		Case Case1= Location_dest.from_C;
		int x = Location_dest.from_C.getX();
		int y= Location_dest.from_C.getY();
		// When the destination has the same piece color as this piece
		if(Location_dest.p!= null && this.couleur==Location_dest.p.couleur) return false;
		if(Math.abs(Location_dest.getX()-x)==Math.abs(Location_dest.getY()-y)) {
			// need to check if that diagonal is clear or not
			System.out.println("yes i am diagonaaaale lol");
			if(!this.getCase().getE().isClearDiagonale(Case1, Location_dest) || this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest))
				return false;
			
			return true;
		}
		
		return false;
	}
}
