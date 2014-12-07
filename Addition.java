
public class Addition extends OperationBinaire {

	public Addition(Case g, Case d){
		super(g,d);
		operande = 1;
	}
	
	double eval() {
		return gauche.valeur() + droite.valeur();
	}
	
}
