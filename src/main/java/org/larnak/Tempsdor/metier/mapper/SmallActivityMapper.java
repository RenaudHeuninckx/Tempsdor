package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Activity;
import org.larnak.Tempsdor.metier.DTO.SmallActivityDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallActivityMapper implements Mapper<SmallActivityDTO, Activity> {


    @Override
    public SmallActivityDTO toDTO(Activity activity) {

        if (activity == null) return null;

        SmallActivityDTO smallActivityDTO = new SmallActivityDTO();

        smallActivityDTO.setId(activity.getId());
        smallActivityDTO.setName(activity.getName());
        smallActivityDTO.setDescription(activity.getDescription());

        return smallActivityDTO;
    }

    @Override
    public Activity toENTITY(SmallActivityDTO smallActivityDTO) {

        if (smallActivityDTO == null) return null;

        Activity activity = new Activity();

        activity.setId(smallActivityDTO.getId());
        activity.setName(smallActivityDTO.getName());
        activity.setDescription(smallActivityDTO.getDescription());

        return activity;
    }
}
