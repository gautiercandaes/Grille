
public class Division extends OperationBinaire{

	public Division(Case g, Case d){
		super(g,d);
		operande = 4;
	}
	
	double eval() {
		return gauche.valeur() / droite.valeur();
	}
	
}
