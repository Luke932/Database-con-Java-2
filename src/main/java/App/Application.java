package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entities.Evento;
import Entities.Location;
import Entities.Partecipazione;
import Entities.Persona;
import Entities.Sesso;
import Entities.Stato;
import Entities.TipoEvento;
import utils.EventiDAO;
import utils.JpaUtil;
import utils.LocationDAO;
import utils.PartecipazioniDAO;
import utils.PersonaDAO;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Siamo pronti");

		// DAO variables
		PersonaDAO pd = new PersonaDAO(em);
		LocationDAO lt = new LocationDAO(em);
		EventiDAO vt = new EventiDAO(em);
		PartecipazioniDAO pt = new PartecipazioniDAO(em);

		// --------------------SAVE-----------------------------
		Persona luca = new Persona("Manuel", "Centini", "manu@libero.it", "1993-04-30", Sesso.MASCHIO);
		pd.save(luca);
		System.out.println();

		Location country = new Location("Centro Congressi", "Roma");
		lt.save(country);
		System.out.println();

		Evento fut = new Evento("Parlamento", "2018-05-01", "Voti", country, TipoEvento.PRIVATO, "250");
		vt.save(fut);
		System.out.println();

		Partecipazione ptc = new Partecipazione();
		ptc.setPersona(luca);
		ptc.setEvento(fut);
		ptc.setStato(Stato.CONFERMATA);

		fut.getPartecipazioni().add(ptc);

		fut.setLocation(country);

		pt.save(ptc);

		// em.close();
		// emf.close();
	}
}
