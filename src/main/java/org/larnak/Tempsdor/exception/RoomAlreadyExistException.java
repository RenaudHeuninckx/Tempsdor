package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.RoomDTO;

public class RoomAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public RoomAlreadyExistException(int id) {
        super(id, RoomDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
