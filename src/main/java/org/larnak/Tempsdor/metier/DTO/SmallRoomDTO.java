package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmallRoomDTO {

    private int id;
    private int capacity;
    private String address;
    private String city;
}
