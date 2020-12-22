package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.UserDTO;

public class UserAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public UserAlreadyExistException(int id) {
        super(id, UserDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
