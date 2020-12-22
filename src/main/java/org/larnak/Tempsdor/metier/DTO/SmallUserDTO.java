package org.larnak.Tempsdor.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmallUserDTO {

    private int id;
    private String name;
    private byte[] passwd;
    private String lastName;
    private String firstName;
    private String email;
}
