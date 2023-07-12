package Entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "evento")
public class Evento {
	@Id
	@GeneratedValue
	private UUID id;

	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<Partecipazione> partecipazioni;

	@ManyToOne
	private Location location;

	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	private String numeroMassimoPartecipanti;

	public Evento(String titolo, String dataEvento, String descrizione, Location location, TipoEvento tipoEvento,
			String numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = LocalDate.parse(dataEvento);
		this.descrizione = descrizione;
		this.location = location;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.partecipazioni = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", location=" + location + ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti="
				+ numeroMassimoPartecipanti + "]";
	}

}
