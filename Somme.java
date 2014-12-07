
public class Somme extends Fonction{
    
	public Somme(Case ... args){
		super(args);
		operande = 5;
	}
	
	double eval() {
		double som = 0;
		for( int i = 0 ; i < cases.size() ; i++ ){
			som += cases.elementAt(i).valeur();
			
		}
		return som;
	}
	

}
