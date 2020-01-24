import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// l'échiquier 

public class Echiquier extends JPanel {
	public Case cases[][];
	
	// Getter cases
	public Case[][] getCases() {
		return this.cases;
	}
	
	public Echiquier() {
		this.cases = new Case[8][8];
		GridLayout grids = new GridLayout(8,2);
		this.setLayout(grids);
		// Dessin de l'Ã©chiquier

		for(int i=7;i>-1;i--) {
			
			for(int j=7;j>-1;j--) {
				
				
				if(i%2==0) {
					if(j%2==0) {
						this.cases[i][j] = new Case(i,j,this);
						this.cases[i][j].setOpaque(true);
						this.cases[i][j].setBorder(new LineBorder(Color.BLACK));
						this.cases[i][j].setBackground(Color.GRAY);
						
					}
					else {
						this.cases[i][j] = new Case(i,j,this);
						this.cases[i][j].setOpaque(true);
						this.cases[i][j].setBorder(new LineBorder(Color.BLACK));
						this.cases[i][j].setBackground(Color.ORANGE);
						
					}
				}
				else {
					if(j%2==1) {
						this.cases[i][j] = new Case(i,j,this);
						this.cases[i][j].setOpaque(true);
						this.cases[i][j].setBorder(new LineBorder(Color.BLACK));
						this.cases[i][j].setBackground(Color.GRAY);
						
					}
					else {
						this.cases[i][j] = new Case(i,j,this);
						this.cases[i][j].setOpaque(true);
						this.cases[i][j].setBorder(new LineBorder(Color.BLACK));
						this.cases[i][j].setBackground(Color.ORANGE);
						
						
					}
				}
				
			}
			
		}
		
		// Setting the layout
		for(int i=7;i>-1;i--) {
			this.add(this.cases[0][i]);
			this.add(this.cases[1][i]);
			this.add(this.cases[2][i]);
			this.add(this.cases[3][i]);
			this.add(this.cases[4][i]);
			this.add(this.cases[5][i]);
			this.add(this.cases[6][i]);
			this.add(this.cases[7][i]);
		}
		
	}
	
	
	
	public boolean isClearY(Case from,Case To) {
		Case p = new Case(from.getX(),from.getY(),from.getE());

		// we need to check first if they are on the same X file
		if(from.getY()!=To.getY())
		{
			System.out.println("From : "+from.getX()+","+from.getY());
			System.out.println("To : "+To.getX()+","+To.getY());
			System.out.println("not on the same Y");
			return false;
		}
		
		
		else {
			
			if(To.getX()>from.getX()) { // when To is on the right 
				p.setX(p.getX()+1); // we don't need to check the clickable case if occupied or not
				for(;p.getX()!=To.getX();p.setX(p.getX()+1)) {
					if(cases[p.getX()][p.getY()].isOccupied()) // if one of the cases before the TO case is occupied
						return false;
				}
			}
			else {
				p.setX(p.getX()-1); // we don't need to check if our case is occupied
				for(;p.getX()!=To.getX();p.setX(p.getX()-1)) { // when To is on the left 
					if(cases[p.getX()][p.getY()].isOccupied())
						return false;
				}
			}
			return true ;
		 // we didn't check if the from or To case is occupied yet				
		}
		
	}
	
	
	
	// we check if every square from -> to is clear on the Y file 
	public boolean isClearX(Case from,Case To) {
		Case p = new Case(from.getX(),from.getY(),from.getE());
		// we need to check first if they are on the same Y file
		System.out.println(Case.from_C.getY()+"===>"+To.getY());
		if(from.getX()!=To.getX()) {
			return false;
		}

		else {
			if(To.getY()>from.getY()) { 
				System.out.println("moving top");
				p.setY(p.getY()+1); // we don't need to check the clickable case if occupied or not
				for(;p.getY()!=To.getY();p.setY(p.getY()+1)) {
					System.out.println("P : "+p.getX()+","+p.getY());
					// P doesn't point on real cases in our board 
					
					if(cases[p.getX()][p.getY()].isOccupied()) // if one of the cases before the TO case is occupied
						return false;
				}
			}
			else {
				System.out.println("moving down");
				p.setY(p.getY()-1); // we don't need to check if our case is occupied
				for(;p.getY()!=To.getY();p.setY(p.getY()-1)) { // when To is on the left 
					if(cases[p.getX()][p.getY()].isOccupied())
						return false;
				}
			}
			return true ;
		 // we didn't check if the from or To case is occupied yet				
		}
		
	}
	
	
	
	// we check if every square from -> to is clear on the Diagonale file 
	public boolean isClearDiagonale(Case from,Case To) {
		Case p = new Case(from.getX(),from.getY(),from.getE());
		
		// this to check if the from , To are on the same diagonal 
		if(Math.abs(from.getX()-To.getX())!=Math.abs(from.getY()-To.getY())) {
			System.out.println("they re not on saaaame diagonaale ");
		return false;}
		
			// we have 4 possible directions 
			if(To.getX()>from.getX() && To.getY()>from.getY()) { //right top
				p.setX(p.getX()+1);
				p.setY(p.getY()+1);
				for(;p.getY()!=To.getY();p.setX(p.getX()+1),p.setY(p.getY()+1)) {
					
					if (cases[p.getX()][p.getY()].isOccupied()) {
						return false;
					}
				}
				}
			if(To.getX()>from.getX() && To.getY()<from.getY()) { //right down
				p.setX(p.getX()+1);
				p.setY(p.getY()-1);
				for(;p.getY()!=To.getY();p.setX(p.getX()+1),p.setY(p.getY()-1)) {
				
					if (cases[p.getX()][p.getY()].isOccupied()) return false;
				}
			}
				if(To.getX()<from.getX() && To.getY()<from.getY()) { //left down
					p.setX(p.getX()-1);
					p.setY(p.getY()-1);
					for(;p.getY()!=To.getY();p.setX(p.getX()-1),p.setY(p.getY()-1)) {
					
						if (cases[p.getX()][p.getY()].isOccupied()) return false;
					}
				}
				if(To.getX()<from.getX() && To.getY()>from.getY()) {// left top
					p.setX(p.getX()-1);
					p.setY(p.getY()+1);
					for(;p.getY()!=To.getY();p.setX(p.getX()-1),p.setY(p.getY()+1)) {
						if (cases[p.getX()][p.getY()].isOccupied()) return false;
					}
				}
				// we didn't check if From , To cases are occupied or not 
				return true;
			}
	
	public boolean notMovingInCheck(Case Location) {

		// our king is on Location.from_C 
		// our king can actually move to the Location
		// we check if in the horizontal line of Location exist a black piece that can attack us
		Case p = new Case(Location.getX(),Location.getY(),Location.getE()); // this is our new location
		int i=p.getX();
		// we check on the right 
		for(;i<7;i++) {
			p.setX(p.getX()+1);
			// if we find it occupied with a black piece that is rook or queen 
			if(cases[p.getX()][p.getY()].isOccupied()) {
				if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="rook" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
					return false;
				else
					break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
			}
		}
		p = new Case(Location.getX(),Location.getY(),Location.getE());
		i=p.getX();
		// we check on the left 
				for(;i>0;i--) {
					p.setX(p.getX()-1);
					// if we find it occupied with a black piece that is rook or queen 
					if(cases[p.getX()][p.getY()].isOccupied()) {
						if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="rook" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
							return false;
						else
							break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
					}
				}
		
		// we check if in the vertical line of Location exist a black piece that can attack us
		p = new Case(Location.getX(),Location.getY(),Location.getE());
		i=p.getY();
		// from the top 
		for(;i<7;i++) {
			p.setY(p.getY()+1);
			// if we find it occupied with a black piece that is rook or queen 
			if(cases[p.getX()][p.getY()].isOccupied()) {
				if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="rook" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
					return false;
				else
					break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
			}
		}
		// from lta7it
		p = new Case(Location.getX(),Location.getY(),Location.getE());
		i=p.getY();
		for(;i>0;i--) {
			p.setY(p.getY()-1);
			// if we find it occupied with a black piece that is rook or queen 
			if(cases[p.getX()][p.getY()].isOccupied()) {
				if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="rook" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
					return false;
				else
					break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
			}
		}
		// now we need to check diagonals 
	 p = new Case(Location.getX(),Location.getY(),Location.getE());
	 i=p.getX();
	 int j = p.getY();
	 	// top right 
	 for(;i<7 && j<7;i++,j++) {
		 p.setX(p.getX()+1);
		 p.setY(p.getY()+1);
		 if(cases[p.getX()][p.getY()].isOccupied()) {
				if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="bishop" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
					return false;
				else
					break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
			}
	 }
	 	// right down
	 p = new Case(Location.getX(),Location.getY(),Location.getE());
	 i=p.getX();
	 j = p.getY();
	 for(;i<7 && j>0;i++,j--) {
		 p.setX(p.getX()+1);
		p.setY(p.getY()-1); 
		if(cases[p.getX()][p.getY()].isOccupied()) {
			if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="bishop" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
				return false;
			else
				break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
		}
	 }
	 //left down
	 p = new Case(Location.getX(),Location.getY(),Location.getE());
	 i=p.getX();
	 j = p.getY();
	 for(;i>0 && j>0;i--,j--) {
		p.setX(p.getX()-1);
		p.setY(p.getY()-1);
		if(cases[p.getX()][p.getY()].isOccupied()) {
			if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="bishop" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
				return false;
			else
				break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
		}
	 }
	// left top
	 p = new Case(Location.getX(),Location.getY(),Location.getE());
	 i=p.getX();
	 j = p.getY();
	 for(;i>0 && j<7;i--,j++) {
		p.setX(p.getX()-1);
		p.setY(p.getY()+1);
		if(cases[p.getX()][p.getY()].isOccupied()) {
			if(cases[p.getX()][p.getY()].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()][p.getY()].p.getClass().getName()=="bishop" || cases[p.getX()][p.getY()].p.getClass().getName()=="queen" ))
				return false;
			else
				break; // otherwise if we found one occupied and it s not harmful to the king we just quit the loop
		}
	 }
	 // now we need to check if there's a knight in the area :3
	 p = new Case(Location.getX(),Location.getY(),Location.getE());
	 if(-1<(p.getX()+1) && (p.getX()+1)<8 && -1<p.getY()+2 && p.getY()+2<8 && cases[p.getX()+1][p.getY()+2].p!=null && cases[p.getX()+1][p.getY()+2].p.getClass().getName()=="knight" && cases[p.getX()+1][p.getY()+2].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()+2) && (p.getX()+2)<8 && -1<p.getY()+1 && p.getY()+1<8 && cases[p.getX()+2][p.getY()+1].p!=null && cases[p.getX()+2][p.getY()+1].p.getClass().getName()=="knight" && cases[p.getX()+2][p.getY()+1].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()+1) && (p.getX()+1)<8 && -1<p.getY()-2 && p.getY()-2<8 && cases[p.getX()+1][p.getY()-2].p!=null && cases[p.getX()+1][p.getY()-2].p.getClass().getName()=="knight" && cases[p.getX()+1][p.getY()-2].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()+2) && (p.getX()+2)<8 && -1<p.getY()-1 && p.getY()-1<8 && cases[p.getX()+2][p.getY()-1].p!=null && cases[p.getX()+2][p.getY()-1].p.getClass().getName()=="knight" && cases[p.getX()+2][p.getY()-1].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()-1) && (p.getX()-1)<8 && -1<p.getY()+2 && p.getY()+2<8 && cases[p.getX()-1][p.getY()+2].p!=null && cases[p.getX()-1][p.getY()+2].p.getClass().getName()=="knight" && cases[p.getX()-1][p.getY()+2].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()-2) && (p.getX()-2)<8 && -1<p.getY()+1 && p.getY()+1<8 && cases[p.getX()-2][p.getY()+1].p!=null && cases[p.getX()-2][p.getY()+1].p.getClass().getName()=="knight" && cases[p.getX()-2][p.getY()+1].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()-1) && (p.getX()-1)<8 && -1<p.getY()-2 && p.getY()-2<8 && cases[p.getX()-1][p.getY()-2].p!=null && cases[p.getX()-1][p.getY()-2].p.getClass().getName()=="knight" && cases[p.getX()-1][p.getY()-2].p.couleur!=Location.from_C.p.couleur  ) return false;
	 if(-1<(p.getX()-2) && (p.getX()-2)<8 && -1<p.getY()-1 && p.getY()-1<8 && cases[p.getX()-2][p.getY()-1].p!=null && cases[p.getX()-2][p.getY()-1].p.getClass().getName()=="knight" && cases[p.getX()-2][p.getY()-1].p.couleur!=Location.from_C.p.couleur  ) return false;
	 
	 // we need to check for the pawns
	p = new Case(Location.getX(),Location.getY(),Location.getE());
	if(Location.from_C.p.couleur=="white") { //for white king
	if(-1<(p.getX()+1) && (p.getX()+1)<8 && -1<p.getY()+1 && p.getY()+1<8 && cases[p.getX()+1][p.getY()+1].isOccupied()) {
		System.out.println("im in here !!!!!!!!");
		if(cases[p.getX()+1][p.getY()+1].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()+1][p.getY()+1].p.getClass().getName()=="pawn" ))
			return false;}
	if(-1<(p.getX()-1) && (p.getX()-1)<8 && -1<p.getY()+1 && p.getY()+1<8 && cases[p.getX()-1][p.getY()+1].isOccupied()) {
		if(cases[p.getX()-1][p.getY()+1].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()-1][p.getY()+1].p.getClass().getName()=="pawn" ))
			return false;}
	}
	else { // for black king , not moving in front of pawns
		if(-1<(p.getX()+1) && (p.getX()+1)<8 && -1<p.getY()-1 && p.getY()-1<8 && cases[p.getX()+1][p.getY()-1].isOccupied()) {
			System.out.println("im in here !!!!!!!!");
			if(cases[p.getX()+1][p.getY()-1].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()+1][p.getY()-1].p.getClass().getName()=="pawn" ))
				return false;}
		if(-1<(p.getX()-1) && (p.getX()-1)<8 && -1<p.getY()-1 && p.getY()-1<8 && cases[p.getX()-1][p.getY()-1].isOccupied()) {
			if(cases[p.getX()-1][p.getY()-1].p.couleur!=Location.from_C.p.couleur && (cases[p.getX()-1][p.getY()-1].p.getClass().getName()=="pawn" ))
				return false;}
	}
		return true;
	}

	public boolean KingIsInCheck(Case LocationKing) {
		if(notMovingInCheck(LocationKing)) // if the square of the king is not attacked by any black piece 
			return true;
		return false;
	}
	public boolean CanCastle(Case Location) {
		System.out.println("i'm in CanCastle ,  has moved ");
		// King and rook haven't previously moved ++ need a counter in rook and king
		if(Location.getX()==6) {
		if(this.getCases()[7][0].p.getClass().getName()!="rook" || ((rook) this.getCases()[7][0].p).getMoved()) {
			return false;
				}
		}
		else if(Location.getX()==2) {
			if(this.getCases()[0][0].p.getClass().getName()!="rook" || ((rook) this.getCases()[0][0].p).getMoved()) {
				return false;
					}
			}
		//no pieces between rook and king 
		if(this.isClearY(Location.from_C,Location))
			return true;
		// King may not castle if already in check 
		// king may not castle if one of the squares is attacked
		//king does not end up in check
		
		return false;
	}
}
