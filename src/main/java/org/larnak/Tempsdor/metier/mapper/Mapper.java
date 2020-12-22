package org.larnak.Tempsdor.metier.mapper;

public interface Mapper <DTO, ENTITY>{

    DTO toDTO(ENTITY entity);
    ENTITY toENTITY(DTO dto);

}
