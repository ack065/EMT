package mk.ukim.finki.emt.lab.Web;

import mk.ukim.finki.emt.lab.Model.dto.create.CreateCountryDTO;
import mk.ukim.finki.emt.lab.Model.dto.create.CreateHostDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayBookingDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayCountryDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayHostDTO;
import mk.ukim.finki.emt.lab.Service.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostRestController {

    private final HostApplicationService hostApplicationService;

    public HostRestController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping
    public List<DisplayHostDTO> findAll() {
        return this.hostApplicationService.findAll();
    }
    @PostMapping("/add-country")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<DisplayHostDTO> addHost(@RequestBody CreateHostDTO createHostDTO) {
        return ResponseEntity.ok(hostApplicationService.create(createHostDTO));
    }

    @PutMapping("/edit-country/{id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<DisplayHostDTO> editHost(
            @PathVariable Long id,
            @RequestBody CreateHostDTO updateDto) {
        return ResponseEntity.ok(hostApplicationService.update(id, updateDto));
    }

    @DeleteMapping("/delete-country/{id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        hostApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDTO> getHostById(@PathVariable Long id) {
        return hostApplicationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}