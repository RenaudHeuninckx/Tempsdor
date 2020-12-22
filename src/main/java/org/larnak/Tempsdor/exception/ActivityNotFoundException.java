package org.larnak.Tempsdor.exception;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;

public class ActivityNotFoundException extends ElementNotFoundException{

    private int index;

    public ActivityNotFoundException(int id) {
        super(id, ActivityDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}
