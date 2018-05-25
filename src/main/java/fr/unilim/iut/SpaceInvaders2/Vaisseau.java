package fr.unilim.iut.SpaceInvaders2;

public class Vaisseau {
	int x;
	int y;

	public Vaisseau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean occupeLaPosition(int x2, int y2) {
		// TODO Auto-generated method stub
		
		return (x2==x&&y2==y);
	}
	 public void seDeplacerVersLaDroite() {
	      this.x = this.x + 1 ;
  }
	 public void seDeplacerVersLaGauche() {
	      this.x = this.x -1 ;
 }

	public int abscisse() {
		// TODO Auto-generated method stub
		return this.x;
	}

}
