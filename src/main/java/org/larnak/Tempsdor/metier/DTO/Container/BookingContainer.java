package org.larnak.Tempsdor.metier.DTO.Container;

import org.larnak.Tempsdor.metier.DTO.BookingDTO;

import java.util.List;

public class BookingContainer extends ElementsContainer<BookingDTO> {
    public BookingContainer(List<BookingDTO> list, int count) {
        super(list, count);
    }
}
