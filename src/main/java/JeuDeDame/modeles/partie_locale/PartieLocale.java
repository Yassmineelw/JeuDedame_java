package JeuDeDame.modeles.partie_locale;

import commun.debogage.J;
import JeuDeDame.modeles.partie.Partie;

public class      PartieLocale 
       extends    Partie<PartieLocaleLectureSeule> 
       implements PartieLocaleLectureSeule { 
	
	public PartieLocale() {
		super();
		J.appel(this);
		
		
	}
}
