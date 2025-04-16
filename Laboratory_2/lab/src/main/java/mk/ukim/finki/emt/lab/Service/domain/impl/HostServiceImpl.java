package mk.ukim.finki.emt.lab.Service.domain.impl;
import mk.ukim.finki.emt.lab.Model.domain.Host;
import mk.ukim.finki.emt.lab.Repository.HostRepository;
import mk.ukim.finki.emt.lab.Service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }
}