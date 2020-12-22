package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PresUserDTO {

    private int id;
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private List<Integer> roomIds;
    private List<Integer> bookingIds;
}
