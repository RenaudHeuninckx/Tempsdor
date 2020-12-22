package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank
    @Size(min = 4, max = 20)
    private String name;

    @NotBlank
    private byte[] passwd;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Email
    private String email;

    private Collection<SmallRoomDTO> rooms;

    private Collection<SmallBookingDTO> bookings;
}
