
public class Multiplication extends OperationBinaire {

	public Multiplication(Case g, Case d){
		super(g,d);
		operande = 3;
	}
	
	double eval() {
		return gauche.valeur() * droite.valeur();
	}
	
}
