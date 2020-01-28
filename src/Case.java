import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
					
					String MovingPcolor=from_C.p.couleur; // Color of the piece that is moving 
					this.To_C=this;
					System.out.println("Possible going to : "+To_C.x+","+To_C.y);
					// we add the condition that the player can move
					/*
					if(this.from_C.p.getClass().getName()=="king" && this.from_C.p.couleur=="white")
						WkCase=this;
					if(this.from_C.p.getClass().getName()=="king" && this.from_C.p.couleur=="black")
						WkCase=this;					*/
					// Setting the new occupant of the new case
					piece o = this.p; // to not loose the piece when we eat it
					
					this.setP(this.from_C.getOccupant());
					this.setIcon(this.from_C.p.getIcon());
					
					if(o!=null && o.couleur==this.p.couleur)System.out.println("i'm the same thing");
					// Setting the last case to null
					this.from_C.setIcon(null);
					this.from_C.p=null;
				
					
				// checking if white king is checkmated 
					if(this.WhiteIsCheckmated())
						System.out.println("white is checkmated");
					if(this.BlackIsCheckmated())
						System.out.println("black is checkmated");
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
	
	
	public boolean WhiteIsCheckmated() {
		// i need the white king 
		int i=0,j=0;
		Case WkCase=new Case(4,0,this.getE());
		king Wk= (king) WkCase.p;
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
			if(this.getE().getCases()[i][j].p!=null && this.getE().getCases()[i][j].p.getClass().getName()=="king" && this.getE().getCases()[i][j].p.couleur=="white"  )
				{
			WkCase=this.getE().getCases()[i][j];
			 Wk=(king) WkCase.p;
				}
			}
		}
		// to check if there's a white piece on the board that can move to any square
	
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				if(this.getE().getCases()[i][j].p!=null &&  this.getE().getCases()[i][j].p.couleur=="white"  ) {
					for(int l=0;l<8;l++) {
						for(int m=0;m<8;m++) {
							Case.from_C=this.getE().getCases()[i][j];
								if(this.getE().getCases()[i][j].p.canMoveTo(this.getE().getCases()[l][m]))
								{
									System.out.println("i am who can move "+i+" "+j+"to the square"+l+" "+m+"piece"+this.getE().getCases()[i][j].p.getClass().getName());
									return false;
								}
				}
						}}
			}
		}
		if(!Wk.isInCheck(WkCase)) 
		{
		System.out.println("White king is not in checkmate but stalemated");
		return false;
		
		}
		System.out.println("white is checkmated");
		return true;
	}
	
	
	public boolean BlackIsCheckmated() {
		// i need the white king 
				int i=0,j=0;
				Case BkCase=new Case(4,7,this.getE());
				king Bk= (king) BkCase.p;
				for(i=0;i<8;i++) {
					for(j=0;j<8;j++) {
					if(this.getE().getCases()[i][j].p!=null && this.getE().getCases()[i][j].p.getClass().getName()=="king" && this.getE().getCases()[i][j].p.couleur=="black"  )
						{
					BkCase=this.getE().getCases()[i][j];
					 Bk=(king) BkCase.p;
						}
					}
				}
				// to check if there's a white piece on the board that can move to any square
			
				for(i=0;i<8;i++) {
					for(j=0;j<8;j++) {
						if(this.getE().getCases()[i][j].p!=null &&  this.getE().getCases()[i][j].p.couleur=="black"  ) {
							for(int l=0;l<8;l++) {
								for(int m=0;m<8;m++) {
									Case.from_C=this.getE().getCases()[i][j];
										if(this.getE().getCases()[i][j].p.canMoveTo(this.getE().getCases()[l][m]))
										{
											System.out.println("i am who can move "+i+" "+j+"to the square"+l+" "+m+"piece"+this.getE().getCases()[i][j].p.getClass().getName());
											return false;
										}
						}
								}}
					}
				}
				if(!Bk.isInCheck(BkCase)) 
				{
				System.out.println("Black king is not in checkmate but stalemated");
				return false;
				
				}
				System.out.println("Black is checkmated");
				return true;
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
