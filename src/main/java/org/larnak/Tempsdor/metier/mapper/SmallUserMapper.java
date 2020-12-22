package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.metier.DTO.SmallUserDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallUserMapper implements Mapper<SmallUserDTO, User> {


    @Override
    public SmallUserDTO toDTO(User user) {

        if (user == null) return null;

        SmallUserDTO smallUserDTO = new SmallUserDTO();

        smallUserDTO.setId(user.getId());
        smallUserDTO.setName(user.getName());
        smallUserDTO.setPasswd(user.getPasswd());
        smallUserDTO.setLastName(user.getLastName());
        smallUserDTO.setFirstName(user.getFirstName());
        smallUserDTO.setEmail(user.getEmail());

        return smallUserDTO;
    }

    @Override
    public User toENTITY(SmallUserDTO smallUserDTO) {

        if (smallUserDTO == null) return null;

        User user = new User();

        user.setId(smallUserDTO.getId());
        user.setName(smallUserDTO.getName());
        user.setPasswd(smallUserDTO.getPasswd());
        user.setLastName(smallUserDTO.getLastName());
        user.setFirstName(smallUserDTO.getFirstName());
        user.setEmail(smallUserDTO.getEmail());

        return user;
    }
}
