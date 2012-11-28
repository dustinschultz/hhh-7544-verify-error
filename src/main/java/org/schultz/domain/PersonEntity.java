package org.schultz.domain;

import static org.hibernate.annotations.LazyToOneOption.NO_PROXY;
import static org.hibernate.annotations.NotFoundAction.IGNORE;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "FPERSON")
public class PersonEntity {

	@Id
	@Basic(optional=false)
	@Column(name = "fperson_id")
	private Long id;

	@LazyToOne(NO_PROXY)
	@NotFound(action = IGNORE)
	@OneToMany(targetEntity = ObservationEntity.class, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fperson_id", insertable = false, updatable = false, nullable = true) })
	private Collection<ObservationEntity> observations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ObservationEntity> getObservations() {
		return observations;
	}

	public void setObservations(Collection<ObservationEntity> observations) {
		this.observations = observations;
	}

}
