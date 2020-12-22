package org.larnak.Tempsdor.DAL.repository;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
