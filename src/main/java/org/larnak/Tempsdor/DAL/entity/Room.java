package org.larnak.Tempsdor.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Room implements Serializable {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Min(1)
    private int capacity;

    @Column(nullable = false)
    @Size(min = 10, max = 100)
    private String address;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "room")
    private Collection<Booking> bookings;

    @ManyToMany
    @JoinTable( name = "room_activity",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private Collection<Activity> activities;
}
