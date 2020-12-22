package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PresRoomDTO {

    private int id;
    private int capacity;
    private String address;
    private String city;
    private int userId;
    private List<Integer> bookingIds;
}
