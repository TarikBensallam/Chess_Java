import java.awt.*;
import javax.swing.ImageIcon;

public class knight extends piece{
	
	// Knight Constructor
	
	public knight(String color,int x, int y,Echiquier E) {
		super(x,y,E);
		this.couleur = color;
		ImageIcon I;
		if(color == "white") {
			I = new ImageIcon("white_knight.png");
		}
		else {
			I = new ImageIcon("black_knight.png");
		}
		Image img = I.getImage(); 
		Image newimg = img.getScaledInstance( 70, 70,  java.awt.Image.SCALE_SMOOTH ) ;  
		this.icon = new ImageIcon(newimg);
	}

	@Override
	public boolean canMoveTo(Case Location_dest) {
		int a,b,c,d,e,f,g,h,X,Y;
		if(Location_dest.from_C.p==null)  // this is needed for the checkmate function , if not we have a problem with a null pointer
			return false;
		
		// When the destination has the same piece color as this piece
				if(Location_dest.p!= null && this.couleur==Location_dest.p.couleur) return false;
		// we need to add that it can't move unless the king is not in check , or it's move will make the king out of check
		X=Location_dest.getX();
		Y=Location_dest.getY();
		a=X+2;
		b=X+1;
		c=X-2;
		d=X-1;
		e=Y+2;
		f=Y+1;
		g=Y-2;
		h=Y-1;
		if(Location_dest.from_C.getX() == a && Location_dest.from_C.getY() == h && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == a && Location_dest.from_C.getY() == f && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == b && Location_dest.from_C.getY() == g && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == b && Location_dest.from_C.getY() == e && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == c && Location_dest.from_C.getY() == h && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == c && Location_dest.from_C.getY() == f && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == d && Location_dest.from_C.getY() == g && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		if(Location_dest.from_C.getX() == d && Location_dest.from_C.getY() == e && !this.getCase().getE().PuttingKingInCheck(Location_dest.from_C,Location_dest)) return true;
		return false;
	}
	
	
}
