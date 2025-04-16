package mk.ukim.finki.emt.lab.Web;


import mk.ukim.finki.emt.lab.Model.dto.create.CreateBookingDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayBookingDTO;
import mk.ukim.finki.emt.lab.Model.enumerations.Currency;
import mk.ukim.finki.emt.lab.Service.BookingApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@SecurityRequirement(name = "Authentication")
public class BookingRestController {
    private final BookingApplicationService bookingApplicationService;

    public BookingRestController(BookingApplicationService bookingApplicationService) {
        this.bookingApplicationService = bookingApplicationService;
    }

    @GetMapping
    public List<DisplayBookingDTO> findAll() {
        return bookingApplicationService.findAll();
    }

    @PostMapping("/add-booking")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DisplayBookingDTO> addBooking(@RequestBody CreateBookingDTO createBookingDto) throws Exception {
        return ResponseEntity.ok(bookingApplicationService.create(createBookingDto));
    }

    @PutMapping("/edit-booking/{id}")
    @PreAuthorize("hasRole('DEVELOPER')")
    public ResponseEntity<DisplayBookingDTO> editBooking(
            @PathVariable Long id,
            @RequestBody CreateBookingDTO updateDto) throws Exception {
        return ResponseEntity.ok(bookingApplicationService.update(id, updateDto));
    }

    @DeleteMapping("/delete-booking/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reservation/{id}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<DisplayBookingDTO> reservation(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(bookingApplicationService.reservation(id));
    }

    @PostMapping("/convert-currency/{id}/{targetCurrency}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Double> convertBookingPrice(
            @PathVariable Long id,
            @PathVariable Currency targetCurrency) throws Exception {
        return ResponseEntity.ok(bookingApplicationService.convertPrices(id, targetCurrency));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookingDTO> getBookingById(@PathVariable Long id) {
        return bookingApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
