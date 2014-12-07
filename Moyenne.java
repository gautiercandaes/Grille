
public class Moyenne extends Fonction {

	public Moyenne(Case ... args){
		super(args);
		operande = 6;
	}
	
	double eval() {
		double som = 0;
		for( int i = 0 ; i < cases.size() ; i++ ){
			som += cases.elementAt(i).valeur();	
		}
		
		return (som/cases.size());
	}
	
}
