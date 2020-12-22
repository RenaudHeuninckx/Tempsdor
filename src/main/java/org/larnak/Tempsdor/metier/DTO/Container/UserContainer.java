package org.larnak.Tempsdor.metier.DTO.Container;

import org.larnak.Tempsdor.metier.DTO.PresUserDTO;

import java.util.List;

public class UserContainer extends ElementsContainer<PresUserDTO> {
    public UserContainer(List<PresUserDTO> list, int count) {
        super(list, count);
    }
}
