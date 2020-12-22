package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.metier.DTO.PresRoomDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PresRoomMapper implements Mapper<PresRoomDTO, Room> {

    @Override
    public PresRoomDTO toDTO(Room room) {
        if (room == null) return null;

        PresRoomDTO presRoomDTO = new PresRoomDTO();

        presRoomDTO.setId(room.getId());
        presRoomDTO.setCapacity(room.getCapacity());
        presRoomDTO.setAddress(room.getAddress());
        presRoomDTO.setCity(room.getCity());
        presRoomDTO.setUserId(room.getUser().getId());
        if (room.getBookings() != null)
            presRoomDTO.setBookingIds(room.getBookings()
                    .stream()
                    .map(Booking::getId)
                    .collect(Collectors.toList()));

        return presRoomDTO;
    }

    @Override
    public Room toENTITY(PresRoomDTO presRoomDTO) {
        return null;
    }
}
