package org.larnak.Tempsdor.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Activity implements Serializable {

    @Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name", nullable = false)
    @Size(max = 20)
    private String name;

    @Column
    @Size(max = 255)
    private String description;

    @ManyToMany
    @JoinTable( name = "room_activity",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Collection<Room> rooms;
}
