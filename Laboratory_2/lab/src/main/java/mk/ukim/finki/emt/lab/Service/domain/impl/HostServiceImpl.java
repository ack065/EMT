package mk.ukim.finki.emt.lab.Service.domain.impl;
import mk.ukim.finki.emt.lab.Model.domain.Country;
import mk.ukim.finki.emt.lab.Model.domain.Host;
import mk.ukim.finki.emt.lab.Repository.HostRepository;
import mk.ukim.finki.emt.lab.Service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }
}