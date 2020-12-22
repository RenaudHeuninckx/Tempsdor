package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.BookingDTO;
import org.larnak.Tempsdor.metier.DTO.RoomDTO;

public class RoomNotFoundException extends ElementNotFoundException{

    private int index;

    public RoomNotFoundException(int id) {
        super(id, RoomDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
