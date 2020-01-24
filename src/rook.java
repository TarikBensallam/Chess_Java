import java.awt.Image;

import javax.swing.ImageIcon;

public class rook extends piece{
	private boolean MovedBefore=false;
	public rook(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_rook.png");
		}
		else {
			I = new ImageIcon("black_rook.png");
		}
		Image img = I.getImage(); 
		Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		this.icon = new ImageIcon(newimg);
	}

	@Override
	public boolean canMoveTo(Case Location_dest) {
		// Case can give us the x,y
				Case Case1= this.getLocation();
						int x = Case1.getX();
						int y= Case1.getY();
						// When the destination has the same piece color as this piece
						if(Location_dest.p!= null && this.couleur==Location_dest.p.couleur) return false;
						// a rook can move vertically 
						if(x==Location_dest.getX())
						{	System.out.println("yes i got in here for x==location");
							// we still need to check if that horizontal line is clear or not 
							if(!this.getCase().getE().isClearX(Case1, Location_dest))
								return false;
							this.setMoved();
							return true;
						}
						else if(y==Location_dest.getY()) {
							System.out.println("yes i got in here for y==location");
							//need to check if the vertical line is clear or not
							if(!this.getCase().getE().isClearY(Case1, Location_dest))
								return false;
							this.setMoved();
							return true;
						}
		return false;
	}
	public void setMoved() {
		this.MovedBefore=true;
	}
	public boolean getMoved() {
		return this.MovedBefore;
	}
}
