package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Activity;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.SmallRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ActivityMapper implements Mapper<ActivityDTO, Activity> {

    @Autowired
    private Mapper<SmallRoomDTO, Room> mapperRoom;


    @Override
    public ActivityDTO toDTO(Activity activity) {

        if (activity == null) return null;

        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setDescription(activity.getDescription());
        if (activity.getRooms() != null)
            activityDTO.setRooms(activity.getRooms().stream()
                    .map(mapperRoom::toDTO).collect(Collectors.toList()));

        return activityDTO;
    }

    @Override
    public Activity toENTITY(ActivityDTO activityDTO) {

        if(activityDTO == null) return null;

        Activity activity = new Activity();

        activity.setId(activityDTO.getId());
        activity.setName(activityDTO.getName());
        activity.setDescription(activityDTO.getDescription());
        if(activityDTO.getRooms() != null)
            activity.setRooms(activityDTO.getRooms().stream()
                    .map(mapperRoom::toENTITY).collect(Collectors.toList()));

        return activity;
    }
}
