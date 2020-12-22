package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.BookingDTO;
import org.larnak.Tempsdor.metier.DTO.UserDTO;

public class UserNotFoundException extends ElementNotFoundException{

    private int index;

    public UserNotFoundException(int id) {
        super(id, UserDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
