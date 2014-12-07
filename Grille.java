import java.util.*;
public class Grille {

	int nbLignes, nbColonnes;
	Map<String, Case> uneGrille; // = new HashMap<String, Case>();
	
	//Constructeur
	Grille(int nbL, int nbC) {
		nbLignes = nbL;
		nbColonnes = nbC;
		uneGrille = new HashMap<String, Case>();
	}
	
	void getValeur(String nomCase) {
		nomCase.valeur();
	}
	
	void putCase(String nomCase, Case c) {
		uneGrille.put(nomCase, c);
	}
	
	void afficherMap(){
		Iterator<String> keySetIterator = uneGrille.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  if(!uneGrille.get(key).formulePresente)
			  System.out.println("case : " + key + " valeur : " +  uneGrille.get(key).valeur() );
		  else{
			  System.out.println("case : " + key + " formule : " + uneGrille.get(key).getFormule() + " valeur : " +  uneGrille.get(key).valeur()  );
			  }
			  
		  }
			  
	}
	

	
	public static void main(String[] args) {
		Grille tabloo = new Grille(20,20);
		
		Case A1 = new Case("A", 1, 100.0);
		Case A2 = new Case("A", 2, 50.0);
		Case A3 = new Case("A", 3, 0.5);		
		
		tabloo.putCase("A1", A1);
		tabloo.putCase("A2", A2);
		tabloo.putCase("A3", A3);
		
		//tabloo.afficherMap();

		OperationBinaire operation1 = new Addition(A1,A3);
		//Formule formule1 = operation1;
		Formule formule1;
		formule1 = operation1;
		formule1.op = operation1;
		
		Case A4 = new Case("A", 4, operation1.eval());
		A4.setFormule(formule1);
		tabloo.putCase("A4", A4);
		
		
		Fonction fonction2 = new Somme(A1,A2,A3);
		Formule formule2 = fonction2;
		formule2.fonct = fonction2;
		Case A5 = new Case("A", 5 /* fonction2.eval() */ );
		A5.setFormule(formule2);
		A5.fixerValeur( fonction2.eval() );
		tabloo.putCase("A5", A5);
		
		Fonction fonction3 = new Moyenne(A1,A2,A3);
		Formule formule3 = fonction3;
		formule3.fonct = fonction3;
		Case A6 = new Case("A", 6 /* fonction2.eval() */ );
		
		boolean test;
		test=A6.cycle(formule3);
		System.out.println(test);
		
		
		A6.setFormule(formule3);
		A6.fixerValeur( fonction3.eval() );
		tabloo.putCase("A6", A6);
		tabloo.afficherMap();
		System.out.println("apres");
		A1.fixerValeur(20);
		A1.propagation();
		
		
		
		
		
		
		
		
		
		tabloo.afficherMap();
	}
	
}
