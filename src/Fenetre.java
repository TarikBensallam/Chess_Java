import javax.swing.JFrame;

// La fenetre principale de notre applicaiton


public class Fenetre extends JFrame{
	public Fenetre() {
		this.setTitle("Jeu d'échecs");
		this.setSize(1000,1000);
		this.setLocationRelativeTo(null);
		this.setContentPane(new Echiquier());
		this.setVisible(true);
	}
}
