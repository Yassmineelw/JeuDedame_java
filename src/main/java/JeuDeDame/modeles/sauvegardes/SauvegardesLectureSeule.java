package JeuDeDame.modeles.sauvegardes;

import java.util.List;  

import JeuDeDame.modeles.sauvegardes.UneSauvegardeLectureSeule;
import commun.modeles.ModeleLectureSeule;

public interface SauvegardesLectureSeule extends ModeleLectureSeule {
	
	List<UneSauvegardeLectureSeule> getLesSauvegardes();

}
