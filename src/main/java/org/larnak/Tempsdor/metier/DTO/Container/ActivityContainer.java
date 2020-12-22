package org.larnak.Tempsdor.metier.DTO.Container;

import org.larnak.Tempsdor.metier.DTO.ActivityDTO;

import java.util.List;

public class ActivityContainer extends ElementsContainer<ActivityDTO> {
    public ActivityContainer(List<ActivityDTO> list, int count) {
        super(list, count);
    }
}
