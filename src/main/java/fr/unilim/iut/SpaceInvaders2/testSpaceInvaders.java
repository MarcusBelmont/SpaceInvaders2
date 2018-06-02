package fr.unilim.iut.SpaceInvaders2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.SpaceInvaders2.utils.DebordementEspaceJeuException;
import fr.unilim.iut.SpaceInvaders2.utils.HorsEspaceJeuException;

public class testSpaceInvaders {
	 private SpaceInvaders spaceinvaders;
	 @Before
	    public void initialisation() {
		    spaceinvaders = new SpaceInvaders(15, 10);
	    }
	@Test
	public void test_AuDebut_JeuSpaceInvaderEstVide() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		assertEquals("" + 
				"...............\n" + 
				"...............\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
	@Test
	public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(7,9));
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......V.......\n" , spaceinvaders.toString());
	}		

	 @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
			
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,10));
		}
	 @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropAGauche_UneExceptionEstLevee() throws Exception {
	
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(-1,9));
		}
	 @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnHaut_UneExceptionEstLevee() throws Exception {
	
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,-1));
		}
	 
	 @Test
		public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(15,9));
				fail("Position trop Ã  droite : devrait dÃ©clencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(-1,9));
				fail("Position trop Ã  gauche : devrait dÃ©clencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(14,10));
				fail("Position trop en bas : devrait dÃ©clencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,-1));
				fail("Position trop Ã  haut : devrait dÃ©clencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
				
		}
	

	
	 @Test
		public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(0,9));

			spaceinvaders.deplacerVaisseauVersLaGauche();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"V..............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	 @Test
		public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(9,2),new Position(7,9));
				fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension( 3,4),new Position(7,1));
				fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
			
				
		}
	   @Test
	    public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2), new Position(7,9));
			spaceinvaders.deplacerVaisseauVersLaDroite();
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"........VVV....\n" + 
			"........VVV....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   @Test
		public void test_VaisseauAvecDimensionImmobile_DeplacerVaisseauVersLaDroite() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2), new Position(12,9));
			spaceinvaders.deplacerVaisseauVersLaDroite();
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"............VVV\n" + 
			"............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   @Test
		public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9));
			spaceinvaders.deplacerVaisseauVersLaGauche();
		
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"......VVV......\n" + 
			"......VVV......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	   @Test
		public void test_VaisseauAvecDimensionImmobile_DeplacerVaisseauVersLaGauche() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2), new Position(0,9));
			spaceinvaders.deplacerVaisseauVersLaGauche();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"VVV............\n" + 
			"VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}

}
