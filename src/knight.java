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
		// When the destination has the same piece color as this piece
				if(Location_dest.p!= null && this.couleur==Location_dest.p.couleur) return false;
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
		if(Location_dest.from_C.getX() == a && Location_dest.from_C.getY() == h) return true;
		if(Location_dest.from_C.getX() == a && Location_dest.from_C.getY() == f) return true;
		if(Location_dest.from_C.getX() == b && Location_dest.from_C.getY() == g) return true;
		if(Location_dest.from_C.getX() == b && Location_dest.from_C.getY() == e) return true;
		if(Location_dest.from_C.getX() == c && Location_dest.from_C.getY() == h) return true;
		if(Location_dest.from_C.getX() == c && Location_dest.from_C.getY() == f) return true;
		if(Location_dest.from_C.getX() == d && Location_dest.from_C.getY() == g) return true;
		if(Location_dest.from_C.getX() == d && Location_dest.from_C.getY() == e) return true;
		return false;
	}
	
	
}
