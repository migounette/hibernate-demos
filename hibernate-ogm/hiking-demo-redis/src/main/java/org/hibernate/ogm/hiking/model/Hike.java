package org.hibernate.ogm.hiking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
//@NamedNativeQuery( name = "hikesByTripId", query = "{ recommendedTrip_id: { $in: [ 27 ] } }", resultClass = Hike.class )
public class Hike {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	//@Type(type = "objectid")
	public String id;

	@NotNull
	public String start;

	@NotNull
	public String destination;

	@ManyToOne
	public Trip recommendedTrip;

	@ElementCollection
	@OrderColumn(name="order")
	public List<Section> sections = new ArrayList<>();

	Hike() {
	}

	public Hike(String start, String destination) {
		this.start = start;
		this.destination = destination;
	}
}
