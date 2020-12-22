package org.larnak.Tempsdor.metier.DTO.Container;

import org.larnak.Tempsdor.metier.DTO.PresRoomDTO;

import java.util.List;

public class RoomContainer extends ElementsContainer<PresRoomDTO> {
    public RoomContainer(List<PresRoomDTO> list, int count) {
        super(list, count);
    }
}
