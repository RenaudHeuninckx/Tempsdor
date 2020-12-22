package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {

    private int id;

    @NotNull
    @Min(1)
    private int capacity;

    @NotBlank
    @Size(min = 10, max = 100)
    private String address;

    @NotBlank
    @Size(min = 2, max = 50)
    private String city;

    private SmallUserDTO user;
    private Collection<SmallBookingDTO> bookings;
    private Collection<SmallActivityDTO> activities;
}
