package mk.ukim.finki.emt.lab.Repository;

import mk.ukim.finki.emt.lab.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
