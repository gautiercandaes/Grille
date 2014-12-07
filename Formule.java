
public abstract class Formule {

	OperationBinaire op;
	Fonction fonct;
	
	int operande;
	/*Constructeurs*/
/*
	Formule(OperationBinaire o){
		op = o;
	}
	Formule(Fonction f){
		fonct = f;	
	}
*/	
	abstract double eval() {
		
	}
	
}
