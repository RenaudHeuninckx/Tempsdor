package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {

    private int id;
    private int nbPersonnes;

    @NotBlank
    @Future
    private Date arrival;

    @NotBlank
    private Date departure;

    private SmallUserDTO user;
    private SmallRoomDTO room;

    @AssertFalse
    public boolean isValidNbPersonne(){
        return nbPersonnes < room.getCapacity() && nbPersonnes > 0;
    }

    @AssertTrue
    public boolean isDepartureOlderThanArrival(){
        return departure.after(arrival);
    }
}
