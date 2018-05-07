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

}
