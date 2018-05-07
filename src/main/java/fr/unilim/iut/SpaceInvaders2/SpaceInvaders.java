package fr.unilim.iut.SpaceInvaders2;

public class SpaceInvaders {
	char marque;
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	private int x;
	private int y;
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	@Override
	public String toString() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				if (this.aUnVaisseauQuiOccupeLaPlace(x, y))
					espaceDeJeu.append('V');
				else
					espaceDeJeu.append('.');
			}
			espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}
	public boolean aUnVaisseauQuiOccupeLaPlace(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}
	public boolean aUnVaisseau() {
		return vaisseau!=null;
	}

	public void positionnerUnNouveauVaisseau(int x, int y) {
		this.vaisseau = new Vaisseau (x,y);
	}

}