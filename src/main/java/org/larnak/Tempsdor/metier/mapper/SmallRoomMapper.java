package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.metier.DTO.SmallRoomDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallRoomMapper implements Mapper<SmallRoomDTO, Room> {


    @Override
    public SmallRoomDTO toDTO(Room room) {

        if (room == null) return null;

        SmallRoomDTO smallRoomDTO = new SmallRoomDTO();

        smallRoomDTO.setId(room.getId());
        smallRoomDTO.setCapacity(room.getCapacity());
        smallRoomDTO.setAddress(room.getAddress());
        smallRoomDTO.setCity(room.getCity());

        return smallRoomDTO;
    }

    @Override
    public Room toENTITY(SmallRoomDTO smallRoomDTO) {

        if (smallRoomDTO == null) return null;

        Room room = new Room();

        room.setId(smallRoomDTO.getId());
        room.setCapacity(smallRoomDTO.getCapacity());
        room.setAddress(smallRoomDTO.getAddress());
        room.setCity(smallRoomDTO.getCity());

        return room;
    }
}
