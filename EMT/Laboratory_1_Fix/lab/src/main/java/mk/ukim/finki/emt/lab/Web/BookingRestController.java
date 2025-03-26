package mk.ukim.finki.emt.lab.Web;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import mk.ukim.finki.emt.lab.Model.Booking;
import mk.ukim.finki.emt.lab.Model.Currency;
import mk.ukim.finki.emt.lab.Model.dto.BookingDTO;
import mk.ukim.finki.emt.lab.Service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
//@SecurityRequirement(name = "Authentication")

public class BookingRestController {
    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findAll() {
        return ResponseEntity.ok(this.bookingService.findAll());
    }

    @PostMapping("/add-booking")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Booking> addBooking(@RequestBody BookingDTO bookingDTO) throws Exception {
        return ResponseEntity.ok(this.bookingService.create(bookingDTO));
    }

    @PutMapping("/edit-booking/{ID}")
//    @PreAuthorize("hasRole('DEVELOPER')")
    public ResponseEntity<Booking> editBooking(@PathVariable Long ID,
                                               @RequestBody BookingDTO bookingDTO) throws Exception {
        return ResponseEntity.ok(this.bookingService.update(ID, bookingDTO));
    }

    @DeleteMapping("delete-booking/{ID}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long ID) {
        this.bookingService.delete(ID);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("reservation/{ID}")
//    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Booking> reservation(@PathVariable Long ID) throws Exception {
        return ResponseEntity.ok(this.bookingService.reservation(ID));
    }

    @PostMapping("/convert-currency/{ID}/{targetCurrency}")
//    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Double> convertBookingPrice(@PathVariable Long ID,
                                                      @PathVariable Currency targetCurrency) throws Exception {
        Optional<Booking> booking = this.bookingService.findById(ID);
        double convertedPrice = this.bookingService.convertPrices(booking.orElse(null), targetCurrency);

        return ResponseEntity.ok(convertedPrice);
    }

}
