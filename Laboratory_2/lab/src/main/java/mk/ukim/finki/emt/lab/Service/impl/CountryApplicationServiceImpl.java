package mk.ukim.finki.emt.lab.Service.impl;

import mk.ukim.finki.emt.lab.Model.domain.Country;
import mk.ukim.finki.emt.lab.Model.dto.create.CreateCountryDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayCountryDTO;
import mk.ukim.finki.emt.lab.Repository.CountryRepository;
import mk.ukim.finki.emt.lab.Service.CountryApplicationService;
import mk.ukim.finki.emt.lab.Service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryRepository countryRepository;
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryRepository countryRepository, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDTO> findAll() {
        return countryService.findAll().stream().map(DisplayCountryDTO::from).collect(Collectors.toList());
    }
    @Override
    public Country create(CreateCountryDTO createCountryDto) {
        Country country = new Country(
                createCountryDto.name(),
                createCountryDto.continent(),
                createCountryDto.currency()
        );
        return countryRepository.save(country);
    }

    @Override
    public Country update(Long id, CreateCountryDTO updateDto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        country.setName(updateDto.name());
        country.setContinent(updateDto.continent());
        country.setCurrency(updateDto.currency());

        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
