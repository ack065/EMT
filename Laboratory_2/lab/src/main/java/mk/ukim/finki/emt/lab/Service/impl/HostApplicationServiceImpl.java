package mk.ukim.finki.emt.lab.Service.impl;

import mk.ukim.finki.emt.lab.Model.domain.Country;
import mk.ukim.finki.emt.lab.Model.domain.Host;
import mk.ukim.finki.emt.lab.Model.dto.create.CreateHostDTO;
import mk.ukim.finki.emt.lab.Model.dto.display.DisplayHostDTO;
import mk.ukim.finki.emt.lab.Repository.CountryRepository;
import mk.ukim.finki.emt.lab.Repository.HostRepository;
import mk.ukim.finki.emt.lab.Service.HostApplicationService;
import mk.ukim.finki.emt.lab.Service.domain.HostService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;
    private final HostService hostService;

    public HostApplicationServiceImpl(HostRepository hostRepository,
                                      CountryRepository countryRepository, HostService hostService) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayHostDTO> findAll() {
        return hostService.findAll().stream().map(DisplayHostDTO::from).collect(Collectors.toList());
    }

    @Override
    public DisplayHostDTO create(CreateHostDTO createHostDto) {
        Host host = new Host(
                createHostDto.name(),
                createHostDto.surname(),
                createHostDto.toHost().getCountry()
        );

        Host createdHost = hostRepository.save(host);
        return DisplayHostDTO.from(createdHost);
    }

    @Override
    public DisplayHostDTO update(Long id, CreateHostDTO updateDto) {
        Host host = hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        Country country = countryRepository.findById(updateDto.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        host.setName(updateDto.name());
        host.setSurname(updateDto.surname());
        host.setCountry(country);

        Host updatedHost = hostRepository.save(host);
        return DisplayHostDTO.from(updatedHost);
    }

    @Override
    public void delete(Long id) {
        hostRepository.deleteById(id);
    }

    @Override
    public Optional<DisplayHostDTO> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDTO.to());
    }
}
