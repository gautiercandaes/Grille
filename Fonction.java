import java.util.Vector;


public abstract class Fonction extends Formule{
	Vector <Case> cases = new Vector <Case> ();
	
	/*Constructeur*/
	Fonction(Case ... args){
		 
		for(Case arg:args){
			cases.addElement(arg);
		}
	}
	

}
