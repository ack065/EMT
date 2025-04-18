package mk.ukim.finki.emt.lab.Service;

import mk.ukim.finki.emt.lab.Model.dto.create.CreateHostDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayHostDTO;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDTO> findAll();
    DisplayHostDTO create(CreateHostDTO createHostDto);
    DisplayHostDTO update(Long id, CreateHostDTO updateDto);
    void delete(Long id);

    Optional<DisplayHostDTO> findById(Long id);
}
