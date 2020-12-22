package org.larnak.Tempsdor.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", nullable = false)
    @Size(min = 4, max = 20)
    private String name;

    @Column(nullable = false, columnDefinition="blob")
    private byte[] passwd;

    @Column(name = "last_name", nullable = false)
    @Size(max = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    @Size(max = 50)
    private String firstName;

    @Column(nullable = false)
    @Email
    private String email;

    @OneToMany(mappedBy = "id")
    private Collection<Room> rooms;

    @OneToMany(mappedBy = "id")
    private Collection<Booking> bookings;

}
