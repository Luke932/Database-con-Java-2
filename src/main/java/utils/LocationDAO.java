package utils;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Location;

public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location e) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(e);

		t.commit();
		System.out.println("Evento salvato correttamente");
	}

	public Location findById(UUID id) {
		Location found = em.find(Location.class, id);
		return found;
	}

	public void findByIdandDelete(UUID id) {
		Location found = em.find(Location.class, id);
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
