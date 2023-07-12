package utils;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Persona;

public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona e) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(e);

		t.commit();
		System.out.println("Evento salvato correttamente");
	}

	public Persona findById(UUID id) {
		Persona found = em.find(Persona.class, id);
		return found;
	}

	public void findByIdandDelete(UUID id) {
		Persona found = em.find(Persona.class, id);
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
