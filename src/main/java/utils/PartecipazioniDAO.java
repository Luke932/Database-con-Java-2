package utils;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Partecipazione;

public class PartecipazioniDAO {
	private final EntityManager em;

	public PartecipazioniDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione e) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(e);

		t.commit();
		System.out.println("Evento salvato correttamente");
	}

	public Partecipazione findById(UUID id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void findByIdandDelete(UUID id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			System.out.println("Studente eliminato correttamente");
		} else {
			System.out.println("Studente non trovato");
		}
	}
}
