import java.util.*;
public class Case {

	String colonne;
	int ligne;
	double valeur;
	Vector<Case> CasesDependantesDeCetteCase=new Vector <Case> ();
	Formule form;
	//OperationBinaire op;
	boolean formulePresente;//s'il y a une formule alors vrai sinon faux
	
	/*Constructeur case avec valeur*/
	Case(String c, int l, double v){
		colonne = c;
		ligne = l;
		valeur = v;
		formulePresente = false;
	}
	
	Case(String c, int l){
		colonne = c;
		ligne = l;
		formulePresente = false;
	}
	
	/*Constructeur case avec formule*/
/*	
	Case(String c, int l, double v, Formule f){
		colonne = c;
		ligne = l;
		valeur = v;
		//op = o;
		form = f;
		formulePresente = true;
	}
*/	
	
	double valeur() {
		return this.valeur;	
	}
	
	void fixerValeur(double x) {//pour modifier la valeur d'une case
		this.valeur = x;
	}
	
	void setFormule(Formule f) {
		this.form = f;
		
		if(f instanceof OperationBinaire) {
			/*
			CasesDependantesDeCetteCase.addElement(f.op.gauche);
			CasesDependantesDeCetteCase.addElement(f.op.droite);
			 */
			f.op.gauche.CasesDependantesDeCetteCase.addElement(this);
			f.op.droite.CasesDependantesDeCetteCase.addElement(this);
		}
		
		else {
			for( int i = 0 ; i < f.fonct.cases.size() ; i++ ){
				//CasesDependantesDeCetteCase.addElement(f.fonct.cases.elementAt(i));
				f.fonct.cases.elementAt(i).CasesDependantesDeCetteCase.addElement(this);
			}
		}
		
	}
	


	
	String getFormule(){//retourne la formule de la case
		String f;
		f = "";
		
		
		switch(this.form.operande){
		  	case 1:
		  		f = this.form.op.gauche.getNom() + " + " + this.form.op.droite.getNom() ;
			break;
		  	case 2:
		  		f = this.form.op.gauche.getNom() + " - " + this.form.op.droite.getNom() ;
			break;
		  	case 3:
		  		f = this.form.op.gauche.getNom() + " * " + this.form.op.droite.getNom() ;
			break;
		  	case 4:
		  		f = this.form.op.gauche.getNom() + " / " + this.form.op.droite.getNom() ;
			break;
		
		}
		 
		return f;
	}
	
	String getNom() {
		return colonne + ligne ;
	}
	
	void propagation(/* Case uneCase */){
		Iterator <Case> parcours = CasesDependantesDeCetteCase.iterator(); 
		Case CaseEnCoursDeTraitement;
		while ( parcours.hasNext ()) {
			CaseEnCoursDeTraitement = parcours.next();
			 // if(	CaseEnCoursDeTraitement != NULL){
			if ( CaseEnCoursDeTraitement.form instanceof Fonction )
				CaseEnCoursDeTraitement.fixerValeur(CaseEnCoursDeTraitement.form.fonct.eval());
			else
				CaseEnCoursDeTraitement.fixerValeur( CaseEnCoursDeTraitement.form.op.eval() );
			
			CaseEnCoursDeTraitement.propagation();
			
		}
	}

	
	
	boolean cycle (Formule f) {
		Iterator <Case> parcours = CasesDependantesDeCetteCase.iterator (); 
		Case CaseEnCoursDeTraitement;
		boolean isCycle = false;
		while ( parcours.hasNext () && !isCycle ) {
			CaseEnCoursDeTraitement = parcours.next();
			if (CaseEnCoursDeTraitement == this){
				return true;
			}
			else {
				CaseEnCoursDeTraitement.cycle();
			}
		}
		return false;
	}



	
}
