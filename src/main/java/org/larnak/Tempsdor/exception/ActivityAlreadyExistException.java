package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.BookingDTO;

public class ActivityAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public ActivityAlreadyExistException(int id) {
        super(id, ActivityDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
