package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.metier.DTO.PresUserDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PresUserMapper implements Mapper<PresUserDTO, User>{
    @Override
    public PresUserDTO toDTO(User user) {
        if (user == null) return null;

        PresUserDTO presUserDTO = new PresUserDTO();

        presUserDTO.setId(user.getId());
        presUserDTO.setName(user.getName());
        presUserDTO.setLastName(user.getLastName());
        presUserDTO.setFirstName(user.getFirstName());
        presUserDTO.setEmail(user.getEmail());
        if (user.getBookings() != null)
            presUserDTO.setBookingIds(user.getBookings().stream()
                    .map(Booking::getId)
                    .collect(Collectors.toList()));
        if (user.getRooms()!= null)
            presUserDTO.setRoomIds(user.getRooms().stream()
                    .map(Room::getId)
                    .collect(Collectors.toList()));

        return presUserDTO;
    }

    @Override
    public User toENTITY(PresUserDTO presUserDTO) {
        return null;
    }
}
