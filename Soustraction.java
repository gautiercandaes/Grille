
public class Soustraction extends OperationBinaire{

	public Soustraction(Case g, Case d){
		super(g,d);
		operande = 2;
	}
	
	double eval() {
		return gauche.valeur() - droite.valeur();
	}
	
}
