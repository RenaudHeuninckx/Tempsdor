package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDTO {

    private int id;

    @NotNull
    @Size(max = 20)
    private String name;

    @Size(max = 255)
    private String description;

    private Collection<SmallRoomDTO> rooms;
}
