package org.larnak.Tempsdor.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Booking implements Serializable {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nb_personnes", nullable = false)
    private int nbPersonnes;

    @Column(nullable = false)
    @Future
    private Date arrival;

    @Column(nullable = false)
    private Date departure;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @AssertTrue
    public boolean isValidNbPersonne(){
        return nbPersonnes < room.getCapacity() && nbPersonnes > 0;
    }

    @AssertTrue
    public boolean isDepartureOlderThanArrival(){
        return departure.after(arrival);
    }

}
