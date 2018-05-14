package fr.unilim.iut.SpaceInvaders2;

import fr.unilim.iut.SpaceInvaders2.utils.HorsEspaceJeuException;

public class SpaceInvaders {
	
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
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
		return recupererEspaceJeuDansChaineASCII();
	}
	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}
	public char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPlace(x, y)) {
			
		
			marque = MARQUE_VAISSEAU;
		}
		else {
			marque = MARQUE_VIDE;
		}
		return marque;
	}
	public boolean aUnVaisseauQuiOccupeLaPlace(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}
	public boolean aUnVaisseau() {
		return vaisseau!=null;
	}

	public void positionnerUnNouveauVaisseau(int x, int y) {

		if ((x<0) || (x >= longueur))
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
		
		if ((y<0) || (y >= hauteur))
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 
	}

}