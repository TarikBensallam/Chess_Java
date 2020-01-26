import javax.swing.ImageIcon;

public abstract class piece {
	protected String couleur;
	protected ImageIcon icon;
	protected Case case_l;
	
	// is it a good idea to add a player here 
	
	
	protected piece(int x ,int y,Echiquier E) {
		this.case_l = new Case(x,y,E);
		
	}
	
	// Get Icon
	ImageIcon getIcon() {
		return this.icon;
	}
	
	//to get the location of the piece on the board
	public Case getLocation() {
		return case_l;
	}
	
	// to set the location of the piece on the board
	public void setLocation(Case case_1) {
		this.case_l=case_1;
	}
	
	// this should be redefined 
	public abstract boolean canMoveTo(Case Location);

	
	public Case getCase() {
		return this.case_l;
	}
	
	
}
