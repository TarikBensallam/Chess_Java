
public class Player {
	
	private String name;
	private king kingP;
	private piece Pieces[]= new piece[16]; 
	
	private boolean MyMove;
	
	public Player(String name,king kingP,piece PieceP[]) {
		this.name=name;
		this.kingP=kingP;
		for(int i=0;i<16;i++) {
			Pieces[i]=PieceP[i];
		}
		
	}
	
	// setters and getters 
	public String getName() {
		return this.name;
	}
	public king getkingP() {
		return this.kingP;
	}
	public piece[] getPieces() {
		return this.Pieces;
	}
	public boolean getMyMove() {
		return this.MyMove;
	}
	public void setMyMove(boolean b) {
		this.MyMove=b;
	}
}
