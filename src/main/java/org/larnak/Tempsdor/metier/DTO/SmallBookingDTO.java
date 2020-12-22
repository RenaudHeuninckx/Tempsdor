package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SmallBookingDTO {

    private int id;
    private int nbPersonnes;
    private Date arrival;
    private Date departure;

}
