package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.BookingDTO;

public class BookingNotFoundException extends ElementNotFoundException{

    private int index;

    public BookingNotFoundException(int id) {
        super(id, BookingDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
