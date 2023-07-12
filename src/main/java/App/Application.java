package App;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entities.Evento;
import Entities.TipoEvento;
import utils.EventiDAO;
import utils.JpaUtil;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Siamo pronti");

		Evento estivo = new Evento("IanniceComeUnaScimmia", "2023-05-25", "GaradeScoreggie", TipoEvento.PRIVATO,
				"Max 5000ps");
		EventiDAO ev = new EventiDAO(em);

		// --------------------SAVE-----------------------------

		ev.save(estivo);

		// ---------------------FIND BY ID------------------------

		Evento moveTheCol = ev.findById(UUID.fromString("5a01dea4-f217-480f-8a41-248f85107bde"));
		System.out.println(moveTheCol);

		// ----------------------DELETE----------------------------

		ev.findByIdandDelete(UUID.fromString("1ddce1ef-5fd0-4202-a7b8-1c4756f84248"));

		// -----------------------REFRESH---------------------------
		ev.refresh(UUID.fromString("6bd97b7f-c935-44e8-826e-c25fd913476a"));

		em.close();
		emf.close();
	}
}
