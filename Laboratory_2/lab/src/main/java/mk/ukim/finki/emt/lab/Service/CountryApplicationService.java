package mk.ukim.finki.emt.lab.Service;

import mk.ukim.finki.emt.lab.Model.domain.Country;
import mk.ukim.finki.emt.lab.Model.dto.create.CreateCountryDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayCountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDTO> findAll();
    Country create(CreateCountryDTO createCountryDto);
    Country update(Long id, CreateCountryDTO updateDto);
    void delete(Long id);
}
