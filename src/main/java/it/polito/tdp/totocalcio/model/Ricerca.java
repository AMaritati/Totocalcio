package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	private Pronostico pronostico;
	private int N;
	private List<Risultato> soluzione;
	
	public List<Risultato> cerca(Pronostico pronostico) {
		
		this.pronostico = pronostico;
		this.N = pronostico.size();
		
		List<RisultatoPartita> parziale = new ArrayList<>();
		int livello = 0;
		
		this.soluzione = new ArrayList<Risultato>();
		ricorsiva(parziale,livello);
		
		return this.soluzione; // TODO:RESTITUIRE L'ELENCO
	}
	
	private void ricorsiva( List<RisultatoPartita> parziale , int livello ) {
		
		// caso terminale?
		if (livello == N) {
			// questa soluzione parziale è una completa
			//System.out.println(parziale);
			// TODO: restituire al chiamante
			this.soluzione.add(new Risultato(parziale));
		}
		else {
			// caso generale
			
			//[parziale da 0 a livello-1] [livello] [livello+1 in poi]
		    PronosticoPartita pp = pronostico.get(livello);
		    //  pp sono i sotto-problemi da provare
		    
		    for (RisultatoPartita ris : pp.getRisultati()) {
		    	//provo a mettere 'ris' nella posizione livello
		    	//della slz parziale
		    	
		    	// costruzione soluzione parziale(sottoproblem)
		    	parziale.add(ris);
		    	//chiamata ricorsiva
		    	ricorsiva(parziale,livello+1);
		    	//backtracking
		    	parziale.remove(parziale.size()-1);
		    	
		    }
		}
	}

}
