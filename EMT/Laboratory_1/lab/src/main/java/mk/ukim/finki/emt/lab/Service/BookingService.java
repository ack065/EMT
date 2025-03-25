package mk.ukim.finki.emt.lab.Service;

import mk.ukim.finki.emt.lab.Model.Booking;
import mk.ukim.finki.emt.lab.Model.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    Booking create(BookingDTO bookingDTO) throws Exception;

    Booking update(Long ID, BookingDTO bookingDTO) throws Exception;

    void delete(Long ID);

    Booking reservation(Long ID) throws Exception;
}
