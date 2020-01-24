import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Case extends JButton implements ActionListener{
	private int x ,y;
	protected piece p;
	public static Case from_C; // from case will hold the value of case "from where" we want to move
	public static Case To_C; // to case will hold the value of case to where we want to move
	protected static Echiquier E;
	
	// Case Constructor
	Case(int X,int Y,Echiquier E){
		this.x=X;
		this.y=Y;
		this.E = E;
		this.p=null;
		this.setOpaque(true);
		// Setting Border Color for button
		this.setBorder(new LineBorder(Color.BLACK));
		// Sets the action listener
		this.addActionListener(this);
	}
	
	// The ON click event
	public void actionPerformed(ActionEvent e) {
		System.out.println(""+x+","+y);
		if(this.p!=null || this.from_C!=null) { 
			
			if(this.from_C==null) {
			// this is the case where the user clicks a non empty case
				System.out.println("a"+this.p.getClass().getName()+" is on the move");
				this.from_C = this; //this is the 'from' tile in  our methods 
				System.out.println("from_C is now : "+from_C.x+","+from_C.y);
			}
			else {
			// this is the case where the user clicks the case where to move
				
				if(this.from_C.p.canMoveTo(this)) {
					this.To_C=this;
					System.out.println("Possible going to : "+To_C.x+","+To_C.y);
					// Setting the new occupant of the new case
					this.setP(this.from_C.getOccupant());
					this.setIcon(this.from_C.p.getIcon());
					
					// Setting the last case to null
					this.from_C.setIcon(null);
					this.from_C.p=null;
				}
				else {
					System.out.println("not possible");
				}
				
				this.from_C =null;
				this.To_C =null;
			}
		}
		else {
			// This is the case where the player clicks on an empty case
			System.out.println("this is an empty case");
		}	
	}

	
	
	//If the case is occupied by some piece
	public boolean isOccupied() {
		if(this.p != null)
			return true ;
		else
			return false;
	}
	
	
	
	
	
	
	// Setters
	void setX(int x) {
		this.x =x;
	}
	
	void setY(int y) {
		this.y =y;
	}
	
	void setP(piece P) {
		this.p = P;
		P.setLocation(this);
	}
	
	
	
	// Getters
	public Echiquier getE() {
		return this.E;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public piece getOccupant() {
		return this.p;
	}
	

}
